package space.wyu;

/**
 * Created by WangYu on 2017/5/30.
 */
public class GPSNode {
    float longitude;
    float latitude;
    String time;
    float speed;
    float direction;
    String date;

    public GPSNode(float longitude, float latitude, String time, float speed, float direction, String date) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.time = time;
        this.speed = speed;
        this.direction = direction;
        this.date = date;
    }

    @Override
    public String toString() {
        return "{\"longitude\":\""+longitude+"\",\"latitude\":\""+latitude+"\",\"time\":\""+time+"\",\"speed\":\""+speed+
                "\",\"direction\":\""+direction+"\",\"date\":\""+date+"\"}\n";
    }
}
