package com.czq.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ResponseHandler {

    // 第一种策略模式（推荐使用）
    @Autowired
    private Map<String, ResponseProvide> providers;

    public Map<String, Object> handle(String clientType, String key, String vulue) {
        ResponseProvide provide = providers.get(clientType);
        if (provide == null) {
            System.out.println(clientType + ",对不起，暂不支持该终端。");
            return null;
        }
        return provide.getResponse(key, vulue);
    }

    // 第二种策略模式
//    @Autowired
//    private List<ResponseProvide> disposers;
//
//    public ResponseHandler() {
//    }
//
//    public ResponseHandler(List<ResponseDisposer> disposers) {
//        this.disposers = disposers;
//    }
//
//
//    public Map<String, Object> handle(String clientType, String key, String vulue) {
//        ResponseProvide responseDisposer = disposers.stream()
//                .filter(disposer -> disposer.supportClientType(clientType))
//                .findFirst().orElseThrow(() -> {
//                    System.out.println(clientType + ",对不起，暂不支持该终端。");
//                    return new RootRuntimeException("对不起，暂不支持该终端。", clientType);
//                });
//        return responseDisposer.getResponse(key, vulue);
//    }


}
