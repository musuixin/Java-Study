package top.musuixin.Hello;

import org.springframework.stereotype.Component;

/**
 * @author musuixin
 * @date 2020-01-10 13:36
 */
@Component
public class CompactDisc {
    public CompactDisc() {
        System.out.println("CD构造");
    }

    public void play() {
        System.out.println("CD正在播放");
    }
}
