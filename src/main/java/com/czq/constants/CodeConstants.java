package com.czq.constants;

/**
 * 异常常量类
 *
 * @author leonzhangxf
 */
public class CodeConstants {

    /**
     * code参数键值
     */
    public static final String CODE_KEY = "code";
    public static final String MSG_KEY = "msg";

    /**
     * 成功 0000
     */
    public static final String SUCCESS_CODE = "0000";

    /**
     * 已经支付完成
     */
    public static final String PAY_FINISHED_CODE = "0001";

    /**
     * app_id 错误 0100
     */
    public static final String APPID_EXC_CODE = "0100";

    /**
     * 权限不足 0101
     */
    public static final String PERMISSION_EXC_CODE = "0101";

    /**
     * 签名错误 0200
     */
    public static final String SIGN_EXC_CODE = "0200";

    /**
     * 参数错误 0201
     */
    public static final String ILLEGALARGUMENT_EXC_CODE = "0201";

    /**
     * 缺少必填参数 0202
     */
    public static final String ARGUMENTMISSING_EXC_CODE = "0202";

    /**
     * 运行时异常 0500
     */
    public static final String ROOTRUNTME_EXC_CODE = "0500";
}
