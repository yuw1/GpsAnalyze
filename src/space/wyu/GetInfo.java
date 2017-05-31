package space.wyu;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import org.apache.log4j.PropertyConfigurator;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by WangYu on 2017/5/28.
 */
public class GetInfo extends ActionSupport {
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String execute() throws Exception {
        AnalyzeOriginInfo.getData();
        JSONArray ja = JSONArray.fromObject(AnalyzeOriginInfo.route.toString());
        AnalyzeOriginInfo.route.clear();
        Logger log = Logger.getLogger(String.valueOf(GetInfo.class));
        PropertyConfigurator.configure("log4j.properties");
        result = ja.toString();
        log.info(result);
        return SUCCESS;
    }

    public static void main(String[] args) throws IOException {
        AnalyzeOriginInfo.getData();
        JSONArray ja = JSONArray.fromObject(AnalyzeOriginInfo.route.toString());
        Logger log = Logger.getLogger(String.valueOf(GetInfo.class));
        PropertyConfigurator.configure("log4j.properties");
        String result = ja.toString();
        log.info(result);
        AnalyzeOriginInfo.route.clear();
    }
}
