package top.musuixin;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

/**
 * @author musuixin
 * @date 2020-02-05 13:12
 */
public class JsoupTest {
    @Test
    public void testFirst() throws IOException {
        Document parse = Jsoup.parse(new URL("https://news.baidu.com/"), 1000);
        System.err.println(parse);
        String title = parse.getElementsByTag("title").first().text();
        System.err.println(title);
    }
    @Test
    public void domTest() throws IOException {
        int j = 0;
        for (int i = 0; i <= 225; i = i + 25) {
            Document parse = Jsoup.parse(new URL("https://movie.douban.com/top250?start=" + i + "&filter="), 1000);
            Elements grid_view = parse.getElementsByAttributeValue("width", "100");
            for (Element element : grid_view) {
                System.out.println(++j + "." + element.getAllElements().attr("alt"));
            }
        }
    }

    @Test
    public void selectDom() throws IOException {
        Document parse = Jsoup.parse(new URL("https://movie.douban.com/top250"), 1000);
        Elements select = parse.select("div.pic img");
        System.out.println(select);
    }

    @Test
    public void maiZiImg() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://www.mzitu.com/218251");
        httpGet.addHeader(":authority", "www.mzitu.com");
        httpGet.addHeader("cookie", "Hm_lvt_dbc355aef238b6c32b43eacbbf161c3c=1580967770,1580969187; Hm_lpvt_dbc355aef238b6c32b43eacbbf161c3c=1580969192");
        httpGet.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");
        CloseableHttpResponse execute = httpClient.execute(httpGet);
        Document document = Jsoup.parse(EntityUtils.toString(execute.getEntity(), "utf-8"));
        System.err.println(document.getElementsByClass("main-image").select("img").attr("src"));
        CloseableHttpClient httpClient1 = HttpClients.createDefault();
        HttpGet httpGet1 = new HttpGet(document.getElementsByClass("main-image").select("img").attr("src"));
        httpGet1.addHeader(":authority", "www.mzitu.com");
        httpGet1.addHeader("cookie", "Hm_lvt_dbc355aef238b6c32b43eacbbf161c3c=1580967770,1580969187; Hm_lpvt_dbc355aef238b6c32b43eacbbf161c3c=1580969192");
        httpGet1.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");
        CloseableHttpResponse execute1 = httpClient1.execute(httpGet1);
        HttpEntity entity = execute1.getEntity();
        InputStream content = entity.getContent();
        FileUtil.writeFromStream(content,"d:/1.html");

    }
}
