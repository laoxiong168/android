package com.example.liuhui.myapplication1;

import com.electronic.util.CommonUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketThread extends Thread {
    private static String localIp = "127.0.0.1";
    private static String ip = "10.10.13.101";
    private static int port = 9999;

    public void run() {
        try {
            Socket socket = new Socket(ip, port);
            CommonUtils.log("socket监听线程已启动");
            //由系统标准输入设备构造BufferedReader对象
            PrintWriter write = new PrintWriter(socket.getOutputStream());
            //由Socket对象得到输出流，并构造PrintWriter对象
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //由Socket对象得到输入流，并构造相应的BufferedReader对象
            String readline;
            int i = 0;
            while (true) {
                //若从标准输入读入的字符串为 "end"则停止循环
                write.println("手机IP地址 " +MainActivity.androidIp );
                //将从系统标准输入读入的字符串输出到Server
                write.flush();
                CommonUtils.log("接收到的服务器的数据为: " + in.readLine());
            }
      /*      write.close(); //关闭Socket输出流
            in.close(); //关闭Socket输入流
            socket.close(); //关闭Socket
*/
        } catch (Exception e) {
            CommonUtils.logError("socket监听线程出错!");
        }
    }
}


