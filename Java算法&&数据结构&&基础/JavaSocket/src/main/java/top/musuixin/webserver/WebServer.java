package top.musuixin.webserver;

import cn.hutool.http.ContentType;
import cn.hutool.http.HttpUtil;

public class WebServer {
    public WebServer() {
        run();
    }

    public void run() {
        HttpUtil.createServer(8888).
                addFilter(((httpServerRequest, httpServerResponse, chain) -> {
                    httpServerResponse.write("{\"msg\": \"密码错误\"}", ContentType.JSON.toString());
//                    chain.doFilter(httpServerResponse.getHttpExchange());
                })) // 返回JSON数据测试
                .addAction("/restTest", (request, response) ->
                        response.write("{\"id\": 1, \"msg\": \"OK\"}", ContentType.JSON.toString())).start();
    }
}
