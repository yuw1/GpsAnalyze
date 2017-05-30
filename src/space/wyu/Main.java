package space.wyu;

import javax.swing.*;
import java.io.*;
import java.util.Properties;
import java.util.PropertyResourceBundle;

public class Main {

    static int longitude;
    static int latitude;
    static String time = "00:00:00:000";
    static Properties pr = new Properties();
    static String gpsRoute = "F:\\IdeaProjects\\GPSAnalyze\\info.txt";

    public static void getData() throws IOException {
        File file = new File(gpsRoute);
        BufferedReader br = new BufferedReader(new FileReader(file));
        int rl;
        StringBuilder sb = new StringBuilder();
        while ((rl =  br.read())!=-1) {
            if(rl == 10){
                String[] info = sb.toString().split(",");
                System.out.println(sb);
                sb.setLength(0);
                analyze(info);
            }else {
                sb.append((char)rl);
            }

        }
    }
    public static void analyze(String[]info){
        switch (info[0]){
            case "$GPGSA"://GPS DOP和活动卫星信息
                break;
            case "$GPGSV"://当前GPS卫星状态信息
                break;
            case "$GPGGA"://位置信息
                StringBuilder sb = new StringBuilder(info[1]);
                sb.replace(6,7,":");
                sb.insert(4,":");
                sb.insert(2,":");
                time = sb.toString();
                break;
            case "$GPGLL"://地理位置和经纬度信息
                break;
            case "$GPRMC"://推荐的最简定位信息
                break;
            case "$GPVTG"://地面速度信息
                break;
            default:
                break;
        }
    }
}
