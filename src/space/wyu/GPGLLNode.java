package space.wyu;

/**
 * Created by WangYu on 2017/6/1.
 */
public class GPGLLNode {
    static float longitude;
    static float latitude;
    static String time;
    static char gpsStatus;
    static char mode;
    public static String toString1() {
        return "{\"信息类型\":\"GPGLL\",\",\"经度\":\""+longitude+"\",\"纬度\":\""+latitude+"\",\"时间\":\""+time+"\",\"定位状态\":\""+gpsStatus+
                "\",\"模式指示\":\""+mode+"\"}\n";
    }
}
