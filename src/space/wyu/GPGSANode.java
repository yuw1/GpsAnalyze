package space.wyu;

/**
 * Created by WangYu on 2017/6/1.
 */
public class GPGSANode {
    static char mode;
    static int type;
    static int prn;
    static float pdop;
    static float hdop;
    static float vdop;

    public static String toString1() {
        return "{\"信息类型\":\"GPGSA\",\",\"模式\":\""+mode+"\",\"定位类型\":\""+type+"\",\"PRN码\":\""+prn+"\",\"PDOP位置精度因子\":\""+pdop+
                "\",\"HDOP水平精度因子\":\""+hdop+"\",\"VDOP垂直精度因子\":\""+vdop+"\"}\n";
    }
}
