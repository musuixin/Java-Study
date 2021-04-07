package top.musuixin.Hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author musuixin
 * @date 2020-01-10 13:38
 */
@Component
public class CDPlay {
    private Power power;
    private CompactDisc cd;

    public CDPlay() {
        System.out.println("CDplay无参构造函数");
    }

    @Autowired(required = false)
    public CDPlay(CompactDisc cd, Power power) {
        this.cd = cd;
        this.power = power;
        System.out.println("有参构造函数");
    }

    public void playCd() {
        power.suplly();
        cd.play();
    }
}
