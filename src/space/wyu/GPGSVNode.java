package space.wyu;

import java.util.ArrayList;

/**
 * Created by WangYu on 2017/6/1.
 */
public class GPGSVNode {
    static int count;
    static int id;
    static int visibleCount;
    static int prn;
    static float elevationAngle;
    static float azimuth;
    static String stor;
    static ArrayList<SingleGPGSV>data = new ArrayList<>();

    public static String toString1() {
        return "{\"信息类型\":\"GPGSV\",\",\"GSV语句的总数\":\""+count+"\",\"本句GSV的编号\":\""+id+"\""+data.toString()+"}\n";
    }
}
