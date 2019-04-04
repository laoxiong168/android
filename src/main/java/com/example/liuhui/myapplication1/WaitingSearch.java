package com.example.liuhui.myapplication1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

/**
 * @Name: wata
 * @Description: 功能描述
 * @Copyright: Copyright (c) 2018
 * @Author: xiongzhenyu
 * @Create Date : 2019/3/26 21:41
 * @Version: 1.0.0
 */
public class WaitingSearch extends Thread{

    private static final int DEVICE_FIND_PORT = 9000;
    private static final int RECEIVE_TIME_OUT = 1500; // 接收超时时间
    private static final int RESPONSE_DEVICE_MAX = 200; // 响应设备的最大个数，防止UDP广播攻击
    private static final byte PACKET_TYPE_FIND_DEVICE_REQ_10 = 0x10; // 搜索请求
    private static final byte PACKET_TYPE_FIND_DEVICE_RSP_11 = 0x11; // 搜索响应
    private static final byte PACKET_TYPE_FIND_DEVICE_CHK_12 = 0x12; // 搜索确认
    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                String msg="handle";
                System.out.println("第 "+i+" 次发送数据" );
                DatagramSocket ds = new DatagramSocket();
                DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length,
                        InetAddress.getByName("255.255.255.255"), 9999);
                ds.send(dp);
                ds.close();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
