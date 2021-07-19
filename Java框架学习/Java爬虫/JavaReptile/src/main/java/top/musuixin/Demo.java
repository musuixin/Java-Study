package top.musuixin;

import java.io.File;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class Demo {
    public static void main(String[] args) throws Exception {
        CloseableHttpClient closeableHttpClient = HttpClients.createDefault(); //1、创建实例
        HttpGet httpGet = new HttpGet("http://www.musuixin.top:8080/assets/images/portfolio/%E7%99%BB%E9%99%86%E6%B3%A8%E5%86%8C1.0.PNG"); //2、创建请求
        httpGet.addHeader(":authority", "www.mzitu.com");
        httpGet.addHeader("cookie", "Hm_lvt_dbc355aef238b6c32b43eacbbf161c3c=1580967770,1580969187; Hm_lpvt_dbc355aef238b6c32b43eacbbf161c3c=1580969192");
        httpGet.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.88 Safari/537.36");
        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet); //3、执行
        HttpEntity httpEntity = closeableHttpResponse.getEntity(); //4、获取实体

        if (httpEntity != null) {
            System.out.println("ContentType:" + httpEntity.getContentType().getValue());
            InputStream inputStream = httpEntity.getContent();
            FileUtils.copyToFile(inputStream, new File("D://xx.png")); //将图片保存在本次磁盘D盘，命名为xxx.png
        }

        closeableHttpResponse.close();
        closeableHttpClient.close();
    }
}