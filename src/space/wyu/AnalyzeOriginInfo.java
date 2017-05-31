package space.wyu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AnalyzeOriginInfo {
    static List <GPSNode> route = new ArrayList<>();
    static String newGpsInfo = "F:"+File.separator+"IdeaProjects"+File.separator+"GPSAnalyze"+File.separator+"newGpsInfo.txt";
    static String gpsInfoHistory = "F:"+File.separator+"IdeaProjects"+File.separator+"GPSAnalyze"+File.separator+"gpsInfoHistory.txt";

    private AnalyzeOriginInfo() {
    }

    public static void getData() throws IOException {
        FileInputStream  fis = new FileInputStream(newGpsInfo);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        int rl;
        StringBuilder sb = new StringBuilder();
        while ((rl =  br.read())!=-1) {
            if(rl == 10){
                String[] info = sb.toString().split(",");
                sb.setLength(0);
                analyze(info);
            }else {
                sb.append((char)rl);
            }

        }
        br.close();
        isr.close();
        fis.close();
    }
    public static void analyze(String[]info){
        switch (info[0]){
            case "$GPGSA"://GPS DOP和活动卫星信息
                break;
            case "$GPGSV"://当前GPS卫星状态信息
                break;
            case "$GPGGA"://位置信息
                break;
            case "$GPGLL"://地理位置和经纬度信息
                break;
            case "$GPRMC"://推荐的最简定位信息
                route.add(new GPSNode(Float.parseFloat(info[5])/100,Float.parseFloat(info[3])/100,
                        analyzeTime(info[1]),Float.parseFloat(info[7]),Float.parseFloat(info[8]),info[9]));
                break;
            case "$GPVTG"://地面速度信息
                break;
            default:
                break;
        }
    }
    public static String analyzeTime(String time){
        StringBuilder sb = new StringBuilder(time);
        sb.replace(6,7,":");
        sb.insert(4,":");
        sb.insert(2,":");
        return sb.toString();
    }
}
