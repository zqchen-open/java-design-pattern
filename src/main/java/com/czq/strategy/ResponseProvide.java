package com.czq.strategy;

import java.util.Map;

public interface ResponseProvide {

    boolean supportClientType(String clientType);

    Map<String, Object> getResponse(String key, String vulue);
}
