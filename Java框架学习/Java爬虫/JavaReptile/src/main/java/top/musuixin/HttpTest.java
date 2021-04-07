package top.musuixin;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author musuixin
 * @date 2020-02-05 09:39
 */
public class HttpTest {
    @Test
    public void GetNoParameter() {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //要Post
        HttpGet httpGet = new HttpGet("https://www.baidu.com/");
        CloseableHttpResponse execute = null;
        try {
            execute = httpClient.execute(httpGet);
            String s = EntityUtils.toString(execute.getEntity(), "utf-8");
            System.err.println(s);
            int statusCode = execute.getStatusLine().getStatusCode();
            System.err.println(statusCode);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                execute.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void GetParameter() throws URISyntaxException {
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //创建URI
        URIBuilder uriBuilder = new URIBuilder("https://www.baidu.com/s");
        uriBuilder.setParameter("wd", "hello world");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        System.err.println(httpGet);
        CloseableHttpResponse execute = null;
        try {
            execute = httpClient.execute(httpGet);
            String s = EntityUtils.toString(execute.getEntity(), "utf-8");
            System.err.println(s);
            int statusCode = execute.getStatusLine().getStatusCode();
            System.err.println(statusCode);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                execute.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
