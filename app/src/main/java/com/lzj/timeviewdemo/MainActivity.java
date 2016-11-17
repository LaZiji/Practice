package com.lzj.timeviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Description:
 * <br/>选择日期时间
 * <br/>本实例通过DatePicker（时间选择器）和
 * <br/>TimePicker（日期选择器）来提供用户选择日期和时间
 * <br/>为了获取选择的日期程序为DatePicker注册了OnDateChangedListener
 * <br/>监听器，为了获取选择的时间程序为TimePicker注册OnTimeChangedListener
 * <br/>监听器
 * @author jph
 * Date:2014.20.57
 */
public class MainActivity extends AppCompatActivity
{
    // 定义5个记录当前时间的变量
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatePicker datePicker = (DatePicker)
                findViewById(R.id.datePicker);
        TimePicker timePicker = (TimePicker)
                findViewById(R.id.timePicker);
        // 获取当前的年、月、日、小时、分钟
        Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        // 初始化DatePicker组件，初始化时指定监听器
        datePicker.init(year, month, day, new OnDateChangedListener()
        {

            @Override
            public void onDateChanged(DatePicker arg0, int year
                    , int month, int day)
            {
                MainActivity.this.year = year;
                MainActivity.this.month = month;
                MainActivity.this.day = day;
                // 显示当前日期、时间
                showDate(year, month, day, hour, minute);
                Toast.makeText(MainActivity.this,"您选择的日期："+year+"年  "
                        +month+"月  "+day+"日", Toast.LENGTH_SHORT).show();
            }
        });
        // 为TimePicker指定监听器
        timePicker.setOnTimeChangedListener(new OnTimeChangedListener()
        {

            @Override
            public void onTimeChanged(TimePicker view
                    , int hourOfDay, int minute)
            {
                MainActivity.this.hour = hourOfDay;
                MainActivity.this.minute = minute;
                // 显示当前日期、时间
                showDate(year, month, day, hour, minute);
                Toast.makeText(MainActivity.this,"您选择的时间："+hourOfDay+"时  "
                        +minute+"分", Toast.LENGTH_SHORT).show();
//
            }
        });
    }

    // 定义在EditText中显示当前日期、时间的方法
    private void showDate(int year, int month
            , int day, int hour, int minute)
    {
        EditText show = (EditText) findViewById(R.id.show);
        show.setText("您选择的日期和时间为：" + year + "年"
                + (month + 1) + "月" + day + "日  "
                + hour + "时" + minute + "分");
    }
}