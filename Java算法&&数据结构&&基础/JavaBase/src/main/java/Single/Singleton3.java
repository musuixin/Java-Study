package Single;

/**
 * 枚举式
 * @author musuixin
 * @date 2020-02-13 21:41
 */
public enum Singleton3 {
    INSTANCE {
        @Override
        protected void doSomething() {
            System.err.println("doSomething");
        }
    };

    protected abstract void doSomething();
}
