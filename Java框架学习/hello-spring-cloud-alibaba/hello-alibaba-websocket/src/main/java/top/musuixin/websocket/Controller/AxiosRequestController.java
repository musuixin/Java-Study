package top.musuixin.websocket.Controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author musuixin
 * @date 2020-09-28 10:54
 */
@RestController
@CrossOrigin
@RequestMapping("/axios")
public class AxiosRequestController {

    @GetMapping("/get")
    public String getAxios(String name) {
        System.err.println(name);
        return "GET";
    }

    @PostMapping("/post")
    public String postAxios(@RequestBody News news) {
        System.err.println(news);
        return "POST";
    }
}




class News {
    private String title;
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}