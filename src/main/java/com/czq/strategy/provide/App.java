package com.czq.strategy.provide;

import com.czq.strategy.ResponseProvide;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component("APP")
public class App implements ResponseProvide {
    @Override
    public boolean supportClientType(String clientType) {
        return "APP".equals(clientType);
    }

    @Override
    public Map<String, Object> getResponse(String key, String vulue) {
        System.out.println("APP执行了！");
        return null;
    }
}
