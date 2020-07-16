package com.czq.pay.strategy.processor;

import com.czq.enumeration.PaymentMethodCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.SortedMap;

/**
 * 支付策略抽象类，提供类部分公共方法，便捷查询和错误日志处理。
 *
 * @author leonzhangxf
 */
public abstract class AbstractPayProcessorStrategy implements PayProcessorStrategy {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 子类<strong>必须</strong>覆写此方法，提供策略Code
     *
     * @return 平台支付方式枚举
     */
    protected abstract PaymentMethodCodeEnum getStrategyCode();

    /**
     * 子类如果有除基本参数之外的额外<strong>公共</strong>参数需要传入，则实现此方法
     *
     * @param paymentParams 本次支付请求的参数
     * @return 子类需要的额外参数
     */
    protected abstract SortedMap<String, Object> getExtraCommonSpecialParams(String paymentParams);

    /**
     * 子类如果有除基本参数之外的额外<strong>业务biz</strong>参数需要传入，则实现此方法
     *
     * @param paymentParams 本次支付请求的参数
     * @return 子类需要的额外参数
     */
    protected abstract SortedMap<String, Object> getExtraBizSpecialParams(String paymentParams);

    /**
     * 子类<strong>必须</strong>根据请求得到的响应map映射，组装对应的成功时策略调用封装。
     * 如果存在异常，请抛出运行时异常，将在调用此方法时进行异常捕获和处理。
     *
     * @param parameterMap            参数映射
     * @param channelAccountParamsMap 对应的渠道参数映射
     * @return 请求调用响应封装
     */
    protected abstract String constructInvokeParamsByResult(SortedMap<String, Object> parameterMap, Map<String, String> channelAccountParamsMap);

}
