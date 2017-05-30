package space.wyu;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println(ja);
        AnalyzeOriginInfo.route.clear();
        result = ja.toString();
        return SUCCESS;
    }

    public static void main(String[] args) throws IOException {
        AnalyzeOriginInfo.getData();
        JSONArray ja = JSONArray.fromObject(AnalyzeOriginInfo.route.toString());
        System.out.println(ja);
        AnalyzeOriginInfo.route.clear();
    }
}
