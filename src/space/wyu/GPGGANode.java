package space.wyu;

/**
 * Created by WangYu on 2017/6/1.
 */
public class GPGGANode {
    static float longitude;
    static float latitude;
    static String time;
    static int gpsStatus;
    static int count;
    static float hdop;
    static float absoluteHeight;
    static String relativeHeight;
    static float timeBlank;
    static String id;
    public static String toString1() {
        return "{\"信息类型\":\"GPGGA\",\",\"经度\":\""+longitude+"\",\"纬度\":\""+latitude+"\",\"时间\":\""+time+"\",\"GPS状态\":\""+gpsStatus+
                "\",\"卫星数量\":\""+count+"\",\"HDOP水平精度因子\":\""+hdop+"\",\"海拔高度\":\""+absoluteHeight+"\",\"地球椭球面相对大地水准面的高度\":\""+
                relativeHeight+"\",\"差分时间\":\""+timeBlank+"\",\"差分站ID\":\""+id+"\"}\n";
    }
}
