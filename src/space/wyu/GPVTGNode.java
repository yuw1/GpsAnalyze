package space.wyu;

/**
 * Created by WangYu on 2017/6/1.
 */
public class GPVTGNode {
    static float trueNorthAngle;
    static float magneticNorthAngle;
    static float rate1;
    static float rate2;
    static char mode;
    public static String toString1() {
        return "{\"信息类型\":\"GPVTG\",\",\"以真北为参考基准的地面航向\":\""+trueNorthAngle+"度\",\"以磁北为参考基准的地面航向\":\""+magneticNorthAngle+"度\",\"地面速率\":\""+rate1+"节\",\"地面速率\":\""+rate2+
                "公里/小时\",\"模式指示\":\""+mode+"\"}\n";
    }

}
