package com.czq.strategy.provide;

import com.czq.strategy.ResponseProvide;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component("Web")
public class Web implements ResponseProvide {
    @Override
    public boolean supportClientType(String clientType) {
        return false;
    }

    @Override
    public Map<String, Object> getResponse(String key, String vulue) {
        System.out.println("Web执行了！");
        return null;
    }
}
