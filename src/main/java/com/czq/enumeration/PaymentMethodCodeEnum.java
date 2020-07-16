package com.czq.enumeration;

import org.springframework.util.StringUtils;

/**
 * 平台支付方式枚举
 * <p>
 * 命名规范：支付方式_终端
 *
 * @author leonzhangxf
 * @date 20190604
 */
public enum PaymentMethodCodeEnum {

    /**
     * 支付宝PC
     */
    ALIPAY_PC("ALIPAY_PC"),

    /**
     * 支付宝H5
     */
    ALIPAY_H5("ALIPAY_H5"),

    /**
     * 微信PC
     */
    WEIXIN_PC("WEIXIN_PC"),

    /**
     * 微信H5
     */
    WEIXIN_H5("WEIXIN_H5"),

    /**
     * 微信 微信公众号
     */
    WEIXIN_WCOA("WEIXIN_WCOA"),

    /**
     * 微信 微信小程序
     */
    WEIXIN_WXPROG("WEIXIN_WXPROG"),

    /**
     * POS H5
     */
    POS_H5("POS_H5"),

    /**
     * POS 微信公众号
     */
    POS_WCOA("POS_WCOA"),

    /**
     * POS APP
     */
    POS_APP("POS_APP"),

    /**
     * 招行一网通H5
     */
    YWT_H5("YWT_H5"),

    /**
     * 招行一网通WCOA
     */
    YWT_WCOA("YWT_WCOA"),

    /**
     * 微信APP
     */
    WEIXIN_APP("WEIXIN_APP"),

    /**
     * 支付宝APP
     */
    ALIPAY_APP("ALIPAY_APP"),

    /**
     * 百度有钱花PC
     */
    UMONEY_PC("UMONEY_PC");

    private String value;

    PaymentMethodCodeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    /**
     * 根据字符串查询对应的支付方式Code
     *
     * @param code 查询字符串
     * @return 支付方式Code
     */
    public static PaymentMethodCodeEnum getPaymentMethodCode(String code) {
        if (!StringUtils.hasText(code)) {
            return null;
        }
        for (PaymentMethodCodeEnum value : PaymentMethodCodeEnum.values()) {
            if (value.getValue().equals(code)) {
                return value;
            }
        }
        return null;
    }

    public static PaymentMethodCodeEnum getBySuffix(String codeSuffix) {
        if (!StringUtils.hasText(codeSuffix)) {
            return null;
        }
        for (PaymentMethodCodeEnum value : PaymentMethodCodeEnum.values()) {
            if (codeSuffix.endsWith(value.getValue())) {
                return value;
            }
        }
        return null;
    }
}
