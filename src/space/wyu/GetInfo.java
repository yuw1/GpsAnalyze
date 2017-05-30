package space.wyu;

import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;

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
        JSONObject jo = new JSONObject();
        jo.put("name","wangyu");
        result = jo.toString();

        return SUCCESS;
    }
}
