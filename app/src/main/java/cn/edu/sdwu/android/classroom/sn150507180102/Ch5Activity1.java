package cn.edu.sdwu.android.classroom.sn150507180102;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Ch5Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ch5_1);

    }

    public void toast1(View view) {
        Toast.makeText(this, "toast1", Toast.LENGTH_LONG).show();
    }

    public void toast2(View view) {
        Toast toast = Toast.makeText(this, "toast2", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void toast3(View view) {
        //加载自定义的布局文件，将其转换为一个View类的实例
        LayoutInflater layoutInflater = getLayoutInflater();
        View view1 = layoutInflater.inflate(R.layout.layout_toast, null);

        //设置显示的文本
        TextView textView = (TextView) view1.findViewById(R.id.toast_tv);
        textView.setText("toast3");

        Toast toast = new Toast(this);
        toast.setView(view1);//设置界面
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }

    public void notification(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        //在构造器中，完成各种属性的设置
        builder.setContentTitle("title");
        builder.setContentText("message");
        builder.setWhen(System.currentTimeMillis());
        builder.setSmallIcon(android.R.drawable.ic_input_delete);//引用系统的资源
        //调用build方法
        Notification notification = builder.build();
        //使用NotificationManager通知管理器
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(101, notification);

    }

    public void cancel_notification(View view) {
        //使用NotificationManage取消通知
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.cancel(101);

    }

    public void alert_dialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //在构造器中设置对话框的属性
        builder.setTitle("title");
        builder.setMessage("message");
        builder.setIcon(android.R.drawable.ic_dialog_email);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //添加点击按键后的，处理
                Toast.makeText(Ch5Activity1.this, "ok", Toast.LENGTH_SHORT).show();
            }

        });


        builder.setNegativeButton("exit",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface,int i){
                Toast.makeText(Ch5Activity1.this,"exit",Toast.LENGTH_SHORT).show();
            }

        });
        builder.setNeutralButton("cancel",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface,int i){
                Toast.makeText(Ch5Activity1.this,"cancel",Toast.LENGTH_SHORT).show();
            }
        });

        builder.create().show();
    }




}
