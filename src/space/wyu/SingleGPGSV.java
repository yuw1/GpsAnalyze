package space.wyu;

/**
 * Created by WangYu on 2017/6/1.
 */
public class SingleGPGSV {
    int prn;
    float elevationAngle;
    float azimuth;
    String stor;

    public SingleGPGSV(int prn, float elevationAngle, float azimuth, String stor) {
        this.prn = prn;
        this.elevationAngle = elevationAngle;
        this.azimuth = azimuth;
        this.stor = stor;
    }

    @Override
    public String toString() {
        return "\"PRN码\":\""+prn+ "\",\"卫星仰角\":\""+elevationAngle+"\",\"卫星方位角\":\""+azimuth+"\",\"信噪比\":\""+stor+"dB\"";
    }
}
