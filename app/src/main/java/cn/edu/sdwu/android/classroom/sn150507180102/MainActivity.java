package cn.edu.sdwu.android.classroom.sn150507180102;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // onCreate：当这个界面创建时会自动进行回调
        //在其中完成一些初始化的工作：设置界面样式（布局文件）：设置界面响应
        super.onCreate(savedInstanceState);//调用父类的方法，不可省略
        setContentView(R.layout.activity_main);//设置界面的样式
        int a=1;
        //进行日志的输出（演示）,两个参数，tag，message
        Log.i(MainActivity.class.toString(),"content");
    }
}
