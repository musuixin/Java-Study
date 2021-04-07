package top.musuixin;


import cn.hutool.core.util.ReUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient aDefault = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://s.weibo.com/ajax/jsonp/gettopsug?uid=&ref=PC");
        CloseableHttpResponse reponse = aDefault.execute(httpGet);
        HttpEntity entity = reponse.getEntity();
        String s = EntityUtils.toString(entity, "utf-8");
        List<String> resultFindAll = ReUtil.findAll("\\\"word\":\".*?\"", s, 0, new ArrayList<String>());
        List<String> strings = new ArrayList<>();
        for (String str : resultFindAll) {
            strings.add(str.replace("\"word\":\"", "").replace("\"", ""));
        }
        System.err.println(strings);
    }
}
