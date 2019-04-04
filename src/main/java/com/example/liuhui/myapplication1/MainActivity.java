package com.example.liuhui.myapplication1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.electronic.util.DragTV;
import com.electronic.util.MoveTextView;

public class MainActivity extends AppCompatActivity {
    private Handler mHandler;
    static public String androidIp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
// 去掉窗口标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
// 隐藏顶部的状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
//        final TextView tv = (TextView) findViewById(R.id.text1);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//横屏
        final DragTV myTv1 = (DragTV) findViewById(R.id.drag1);
        final DragTV myTv2 = (DragTV) findViewById(R.id.drag2);
        final DragTV myTv3 = (DragTV) findViewById(R.id.drag3);
        myTv1.setTextSize(40);
        myTv1.setLeft(100);
        myTv1.setTextColor(0xEEEE0000);
        myTv2.setTextSize(50);
        myTv2.setTextColor(0xEEEE0000);
        myTv3.setTextSize(40);
        myTv3.setTextColor(0xff0000ff);


//
//        mHandler = new Handler() {
//            @Override
//            public void handleMessage(Message msg) {
//                super.handleMessage(msg);
//                Toast.makeText(getApplicationContext(), "ip-: " + msg.obj, Toast.LENGTH_LONG).show();
//                tv.setText("本机IP地址: " + msg.obj);
//            }
//        };
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                NetService netService = new NetService();
//                String ip = netService.getHostIp();
//                Message message = Message.obtain(mHandler);
//                message.what = 10;
//                message.obj = ip;
//                androidIp=ip;
//                mHandler.sendMessageDelayed(message, 10); //通过延迟发送消息，每隔一秒发送一条消息
//            }
//        }).start();
//
//        new SocketThread().start();
    }


    public void touchMoveCallBack(int direction) {
        if (direction == 6) {
            Toast.makeText(MainActivity.this, "你在向左滑动！", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "你在向右滑动！", Toast.LENGTH_SHORT).show();
        }
    }


}


