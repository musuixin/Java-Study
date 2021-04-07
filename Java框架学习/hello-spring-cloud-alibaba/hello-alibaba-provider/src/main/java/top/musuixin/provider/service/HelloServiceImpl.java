package top.musuixin.provider.service;

import org.apache.dubbo.config.annotation.Service;
import top.musuixin.common.service.HelloService;

/**
 * @author musuixin
 * @date 2020-09-04 20:20
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String say() {
        return "Hello dubbo 8090";
    }
}
