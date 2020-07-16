package com.czq.strategyreflect.trade.pc;

import com.alibaba.fastjson.JSON;
import com.czq.enumeration.PaymentMethodCodeEnum;
import com.czq.strategyreflect.payment.impl.AlipayPaymentStrategy;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 传智支付宝PC
 * <p>
 * Created by leon_zhangxf on 2017-11-29.
 */
@Component
public class AlipayPcPaymentStrategy extends AlipayPaymentStrategy {

    public static final PaymentMethodCodeEnum STRATEGY_CODE = PaymentMethodCodeEnum.ALIPAY_PC;

    @Override
    protected PaymentMethodCodeEnum getStrategyCode() {
        return STRATEGY_CODE;
    }

    @Override
    protected @Nullable
    SortedMap<String, Object> getExtraCommonSpecialParams(String paymentParams) {
        SortedMap<String, Object> parameterMap = new TreeMap<>();
        parameterMap.put("公共额外请求参数", "公共额外请求参数");
        return parameterMap;
    }

    @Override
    protected @Nullable
    SortedMap<String, Object> getExtraBizSpecialParams(String paymentParams) {
        SortedMap<String, Object> parameterMap = new TreeMap<>();
        parameterMap.put("业务额外参数", "业务额外参数");
        return parameterMap;
    }

    @Override
    protected String constructInvokeParamsByResult(SortedMap<String, Object> parameterMap, Map<String, String> channelAccountParamsMap) {
        System.out.println("支付宝PC执行了");
        System.out.println(JSON.toJSON(parameterMap));
        return "支付宝PC";
    }
}
