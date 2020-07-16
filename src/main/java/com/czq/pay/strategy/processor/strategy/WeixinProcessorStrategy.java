package com.czq.pay.strategy.processor.strategy;

import com.czq.enumeration.PaymentMethodCodeEnum;
import com.czq.pay.strategy.processor.AbstractPayProcessorStrategy;
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
public class WeixinProcessorStrategy extends AbstractPayProcessorStrategy {


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
