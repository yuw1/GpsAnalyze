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

    public static void main(String[]args) throws IOException {
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
                GPGSANode.mode = info[1].charAt(0);
                GPGSANode.type = info[2].charAt(0);
                GPGSANode.prn = Integer.parseInt(info[3]);
                GPGSANode.pdop = Float.parseFloat(info[4]);
                GPGSANode.hdop = Float.parseFloat(info[5]);
                GPGSANode.vdop = Float.parseFloat(info[6]);
                System.out.println(GPGSANode.toString1());
                break;
            case "$GPGSV"://当前GPS卫星状态信息
                GPGSVNode.count = Integer.parseInt(info[1]);
                GPGSVNode.id = Integer.parseInt(info[2]);
                GPGSVNode.visibleCount = Integer.parseInt(info[3]);
                int num = (info.length-3)/4;
                for (int i=0;i<num;i++){
                    GPGSVNode.data.add(new SingleGPGSV(Integer.parseInt(info[4]),Float.parseFloat(info[5]),Float.parseFloat(info[6]),info[7]));
                }
                System.out.println(GPGSVNode.toString1());
                GPGSVNode.data.clear();

                break;
            case "$GPGGA"://位置信息
                GPGGANode.time =  analyzeTime(info[1]);
                GPGGANode.latitude = Float.parseFloat(info[2])/100;
                GPGGANode.longitude = Float.parseFloat(info[4])/100;
                GPGGANode.gpsStatus = Integer.parseInt(info[6]);
                GPGGANode.count = Integer.parseInt(info[7]);
                GPGGANode.hdop = Float.parseFloat(info[8]);
                GPGGANode.absoluteHeight = Float.parseFloat(info[9]);
                GPGGANode.relativeHeight = info[10];
                GPGGANode.timeBlank = Float.parseFloat(info[11]);
                GPGGANode.id = info[12];
                System.out.println(GPGGANode.toString1());
                break;
            case "$GPGLL"://地理位置和经纬度信息
                GPGLLNode.latitude = Float.parseFloat(info[1])/100;
                GPGLLNode.longitude = Float.parseFloat(info[3])/100;
                GPGLLNode.time =  analyzeTime(info[5]);
                GPGLLNode.gpsStatus = info[6].charAt(0);
                GPGLLNode.mode = info[7].charAt(0);
                System.out.println(GPGLLNode.toString1());
                break;
            case "$GPRMC"://推荐的最简定位信息
                GPSNode temp = new GPSNode(Float.parseFloat(info[5])/100,Float.parseFloat(info[3])/100,
                        analyzeTime(info[1]),Float.parseFloat(info[7]),Float.parseFloat(info[8]),info[9]);
                route.add(temp);
                System.out.println(temp.toString());
                break;
            case "$GPVTG"://地面速度信息
                GPVTGNode.trueNorthAngle = Float.parseFloat(info[1]);
                GPVTGNode.magneticNorthAngle = Float.parseFloat(info[2]);
                GPVTGNode.rate1 = Float.parseFloat(info[3]);
                GPVTGNode.rate2 = Float.parseFloat(info[4]);
                GPVTGNode.mode = info[5].charAt(0);
                System.out.println(GPVTGNode.toString1());
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
