package com.czq.strategy.platform;

import com.czq.constants.ClientTypeConstants;
import com.czq.strategy.ResponseProvide;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component(ClientTypeConstants.CLIENT_TYPE_H5)
public class H5 implements ResponseProvide {
    @Override
    public boolean supportClientType(String clientType) {
        return false;
    }

    @Override
    public Map<String, Object> getResponse(String key, String vulue) {
        System.out.println("AH5执行了！");
        return null;
    }
}
