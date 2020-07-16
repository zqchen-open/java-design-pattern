package com.czq.pay.strategy.platform.app;

import com.czq.enumeration.PaymentMethodCodeEnum;
import com.czq.pay.strategy.processor.strategy.AlipayPayProcessorStrategy;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 支付宝app支付
 */
@Component
public class AlipayAppPayProcessorStrategy extends AlipayPayProcessorStrategy {

    public static final PaymentMethodCodeEnum STRATEGY_CODE = PaymentMethodCodeEnum.ALIPAY_APP;

    @Override
    protected PaymentMethodCodeEnum getStrategyCode() {
        return STRATEGY_CODE;
    }

    @Override
    protected @Nullable
    SortedMap<String, Object> getExtraCommonSpecialParams(String paymentParams) {
        SortedMap<String, Object> parameterMap = new TreeMap<>();
        parameterMap.put("method", "alipay.trade.app.pay");
        return parameterMap;
    }

    @Override
    protected @Nullable
    SortedMap<String, Object> getExtraBizSpecialParams(String paymentParams) {
        SortedMap<String, Object> parameterMap = new TreeMap<>();
        parameterMap.put("product_code", "QUICK_MSECURITY_PAY");
        return parameterMap;
    }

    @Override
    protected String constructInvokeParamsByResult(SortedMap<String, Object> parameterMap, Map<String, String> channelAccountParamsMap) {
        System.out.println("支付宝APP");
        return "支付宝APP";
    }
}
