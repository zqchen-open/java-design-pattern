package com.czq.pay.strategy.platform.h5;

import com.czq.enumeration.PaymentMethodCodeEnum;
import com.czq.pay.strategy.processor.strategy.AlipayPayProcessorStrategy;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 传智支付宝H5
 *
 * @author haikun zhang on 2017-12-22
 * @author leon_zhangxf 20180711
 */
@Component
public class AlipayH5PayProcessorStrategy extends AlipayPayProcessorStrategy {

    public static final PaymentMethodCodeEnum STRATEGY_CODE = PaymentMethodCodeEnum.ALIPAY_H5;

    @Override
    protected PaymentMethodCodeEnum getStrategyCode() {
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
        System.out.println("支付宝H5");
        return "支付宝H5";
    }
}
