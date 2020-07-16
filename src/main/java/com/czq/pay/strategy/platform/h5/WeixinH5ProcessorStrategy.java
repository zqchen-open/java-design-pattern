package com.czq.pay.strategy.platform.h5;

import com.czq.enumeration.PaymentMethodCodeEnum;
import com.czq.pay.strategy.processor.strategy.WeixinProcessorStrategy;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.SortedMap;

/**
 * 传智微信H5
 *
 * @author haikun zhang on 2017-12-22
 * @author leon_zhangxf 20180711
 */
@Component
public class WeixinH5ProcessorStrategy extends WeixinProcessorStrategy {

    public static final PaymentMethodCodeEnum STRATEGY_CODE = PaymentMethodCodeEnum.WEIXIN_H5;

    @Override
    protected @NonNull
    PaymentMethodCodeEnum getStrategyCode() {
        return STRATEGY_CODE;
    }

    @Override
    protected String constructInvokeParamsByResult(SortedMap<String, Object> parameterMap, Map<String, String> channelAccountParamsMap) {
        System.out.println("微信H5");
        return "微信H5";
    }
}
