package top.musuixin;

import Single.Singleton4;
import org.junit.Test;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        for (int i = 0; i < 20; ++i) {
            new Thread(() -> System.err.println(Singleton4.getInstance())).start();
        }
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
