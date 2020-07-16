package com.czq.strategyreflect.trade.pc;


import com.czq.enumeration.PaymentMethodCodeEnum;
import com.czq.strategyreflect.payment.impl.WeixinPaymentStrategy;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 传智微信PC
 *
 * @author leonzhangxf
 */
@Component
public class WeixinPcPaymentStrategy extends WeixinPaymentStrategy {

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
