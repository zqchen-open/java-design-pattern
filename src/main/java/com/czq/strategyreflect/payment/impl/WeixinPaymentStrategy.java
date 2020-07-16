package com.czq.strategyreflect.payment.impl;

import com.czq.enumeration.PaymentMethodCodeEnum;
import com.czq.strategyreflect.payment.AbstractPaymentStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.SortedMap;

/**
 * 微信公共支付策略
 *
 * @author leonzhangxf
 * @date 20190604
 */
@Component
public class WeixinPaymentStrategy extends AbstractPaymentStrategy {


    @Override
    protected PaymentMethodCodeEnum getStrategyCode() {
        return null;
    }

    @Override
    protected SortedMap<String, Object> getExtraCommonSpecialParams(String paymentParams) {
        return null;
    }

    @Override
    protected SortedMap<String, Object> getExtraBizSpecialParams(String paymentParams) {
        return null;
    }

    @Override
    protected String constructInvokeParamsByResult(SortedMap<String, Object> parameterMap, Map<String, String> channelAccountParamsMap) {
        return null;
    }

    @Override
    public String unifiedOrder(String paymentParams) {
        return null;
    }
}
