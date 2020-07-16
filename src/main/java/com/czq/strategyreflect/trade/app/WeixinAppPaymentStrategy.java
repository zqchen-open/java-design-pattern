package com.czq.strategyreflect.trade.app;

import com.czq.enumeration.PaymentMethodCodeEnum;
import com.czq.strategyreflect.payment.impl.WeixinPaymentStrategy;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 微信app支付
 *
 */
@Component
public class WeixinAppPaymentStrategy extends WeixinPaymentStrategy {

    public static final PaymentMethodCodeEnum STRATEGY_CODE = PaymentMethodCodeEnum.WEIXIN_APP;

    @Override
    protected @NonNull PaymentMethodCodeEnum getStrategyCode() {
        return STRATEGY_CODE;
    }

    @Override
    protected @Nullable
    SortedMap<String, Object> getExtraCommonSpecialParams(String paymentParams) {
        SortedMap<String, Object> parameterMap = new TreeMap<>();
        return parameterMap;
    }

    @Override
    protected @Nullable
    SortedMap<String, Object> getExtraBizSpecialParams(String paymentParams) {
        SortedMap<String, Object> parameterMap = new TreeMap<>();
        return parameterMap;
    }

    @Override
    protected String constructInvokeParamsByResult(SortedMap<String, Object> parameterMap, Map<String, String> channelAccountParamsMap) {
        System.out.println("微信APP");
        return "微信APP";
    }
}
