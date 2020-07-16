package com.czq.pay.strategy.processor.strategy;

import com.czq.enumeration.PaymentMethodCodeEnum;
import com.czq.pay.strategy.processor.AbstractPayProcessorStrategy;
import com.czq.util.LocalDateTimeUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * 支付宝通用策略
 *
 * @author leonzhangxf
 * @date 20190604
 */
@Component
public class AlipayPayProcessorStrategy extends AbstractPayProcessorStrategy {

    @Override
    protected @NonNull
    PaymentMethodCodeEnum getStrategyCode() {
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
        // 公共请求参数
        SortedMap<String, Object> parameterMap = new TreeMap<>();
        parameterMap.put("app_id", "app_id");
        parameterMap.put("charset", "utf-8");
        parameterMap.put("sign_type", "RSA2");
        parameterMap.put("timestamp", LocalDateTimeUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        parameterMap.put("version", "1.0");
        parameterMap.put("notify_url", "notify_url");
        // 公共额外请求参数
        SortedMap<String, Object> extraSpecialParams = getExtraCommonSpecialParams(paymentParams);
        parameterMap.putAll(extraSpecialParams);
//        if (!CollectionUtils.isEmpty(extraSpecialParams)) {
//            for (Map.Entry<String, Object> entry : extraSpecialParams.entrySet()) {
//                parameterMap.put(entry.getKey(), entry.getValue());
//            }
//        }
        // 业务请求参数
        SortedMap<String, Object> bizContentMap = new TreeMap<>();
        bizContentMap.put("subject", "subject");
        bizContentMap.put("out_trade_no", "out_trade_no");
        bizContentMap.put("timeout_express", "2h");
        bizContentMap.put("total_amount", new BigDecimal(100).setScale(2, BigDecimal.ROUND_HALF_UP));
        // 业务额外参数
        SortedMap<String, Object> extraBizSpecialParams = getExtraBizSpecialParams(paymentParams);
        parameterMap.putAll(extraBizSpecialParams);
//        if (!CollectionUtils.isEmpty(extraBizSpecialParams)) {
//            for (Map.Entry<String, Object> entry : extraBizSpecialParams.entrySet()) {
//                bizContentMap.put(entry.getKey(), entry.getValue());
//            }
//        }
        //0.根据渠道支付方式查找商户参数信息
        Map<String, String> channelAccountParamsMap = new HashMap<>();
        return constructInvokeParamsByResult(parameterMap, channelAccountParamsMap);
    }
}
