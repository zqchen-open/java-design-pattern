package com.czq.pay.strategy.platform.pc;


import com.czq.enumeration.PaymentMethodCodeEnum;
import com.czq.pay.strategy.processor.strategy.WeixinProcessorStrategy;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.SortedMap;

/**
 * 传智微信PC
 *
 * @author leonzhangxf
 */
@Component
public class WeixinPcProcessorStrategy extends WeixinProcessorStrategy {

    public static final PaymentMethodCodeEnum STRATEGY_CODE = PaymentMethodCodeEnum.WEIXIN_PC;

    private static final String CODE_URL_KEY = "code_url";

    @Override
    protected @NonNull
    PaymentMethodCodeEnum getStrategyCode() {
        return STRATEGY_CODE;
    }

    @Override
    protected @NonNull
    String constructInvokeParamsByResult(SortedMap<String, Object> resultMap, Map<String, String> channelAccountParamsMap) {
        System.out.println("微信PC");
        return "微信PC";
    }
}
