package top.musuixin.provider.observermodel;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

/**
 * @author musuixin
 * @date 2020-09-23 19:56
 */

class News {
    private String author;
    private String content;
    private LocalDateTime time;
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

class Taskbar extends Observable {
    public void releaseNews(News news) {
        setChanged();
        notifyObservers(news);
    }
}

class User implements Observer {
    private String userName;
    public String getUserName() {
        return userName;
    }
    public User(String userName) {
        this.userName = userName;
    }
    @Override
    public void update(Observable o, Object arg) {
        News news = (News) arg;
        System.err.println(news.getAuthor());
        System.err.println(news.getContent());
        System.err.println(news.getTime());
    }
}

public class ObserverTest {
    public static void main(String[] args) {
        Taskbar taskbar = new Taskbar();
        taskbar.addObserver(new User("musuixin"));
        taskbar.addObserver(new User("FangDangYu"));
        News news = new News();
        news.setAuthor("慕随心");
        news.setContent("今天是九月二十四号，下毛毛雨。挺舒服的天气。");
        news.setTime(LocalDateTime.now());
        taskbar.releaseNews(news);
    }
}
