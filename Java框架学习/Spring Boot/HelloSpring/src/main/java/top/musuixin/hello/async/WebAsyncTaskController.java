package top.musuixin.hello.async;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

@RestController
public class WebAsyncTaskController {
    @GetMapping("/r1")
    public Map<String, String> r1() {
        Instant now = Instant.now();
        Map<String, String> result = buildResult();
        doTask();
        System.out.println("r1 time consumption: " + ChronoUnit.SECONDS.between(now, Instant.now()) + " seconds");
        return result;
    }

    @GetMapping("/r2")
    public WebAsyncTask<Map<String, String>> r2() {
        Instant now = Instant.now();
        Callable<Map<String, String>> callable = this::buildResult;
        doTask();
        WebAsyncTask<Map<String, String>> webAsyncTask = new WebAsyncTask<>(callable);
        System.out.println("r2 time consumption: " + ChronoUnit.SECONDS.between(now, Instant.now()) + " seconds");
        return webAsyncTask;
    }

    private Map<String, String> buildResult() {
        System.out.println("building result");
        Map<String, String> result = new HashMap<>();
        try {
            Thread.sleep(3 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 1 * 1000; i++) {
            result.put(i + "-key", i + "value");
        }
        return result;
    }

    private void doTask() {
        System.out.println("do some tasks");
        try {
            Thread.sleep(3 * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
