package Single;

/**
 * 登记式
 * 延迟加载
 * <p>
 * 线程安全
 * 经过修改可以阻止反射攻击
 *
 * @author musuixin
 * @date 2020-02-13 21:28
 */
public class Singleton2 {
    private static class SingletonHolder {
        private static Singleton2 instance = new Singleton2();
    }


    private Singleton2() {
        //阻止反射攻击
        if (SingletonHolder.instance != null) {
            return;
        }
    }

    //当调用此方法时，才会加载类
    public Singleton2 getInstance() {
        return SingletonHolder.instance;
    }
}
