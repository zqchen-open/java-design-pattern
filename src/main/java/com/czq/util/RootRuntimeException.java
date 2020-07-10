package com.czq.util;


import com.czq.constants.CodeConstants;

import java.util.SortedMap;

/**
 * 平台根运行时异常
 * <p>
 * 其它运行时异常一般都继承此异常
 * <p>
 * Created by leon_zhangxf on 2017-11-28.
 */
public class RootRuntimeException extends RuntimeException {

    /**
     * 异常返回码
     */
    private String code;

    /**
     * 平台对应商户的加密用秘钥
     */
    private String platPrivateKey;

    /**
     * 返回结果集，应该为排序Map，如TreeMap、或者SortedMap子类实现等。
     */
    private SortedMap<String, Object> resultMap;

    public RootRuntimeException(String platPrivateKey) {
        super();
        this.platPrivateKey = platPrivateKey;
        this.setCode(CodeConstants.ROOTRUNTME_EXC_CODE);
    }

    public RootRuntimeException(String s, String platPrivateKey) {
        super(s);
        this.platPrivateKey = platPrivateKey;
        this.setCode(CodeConstants.ROOTRUNTME_EXC_CODE);
    }

    /**
     * @param message 对应对外相应信息的msg
     * @param cause
     */
    public RootRuntimeException(String message, Throwable cause, String platPrivateKey) {
        super(message, cause);
        this.setCode(CodeConstants.ROOTRUNTME_EXC_CODE);
    }

    public RootRuntimeException(Throwable cause, String platPrivateKey) {
        super(cause);
        this.setCode(CodeConstants.ROOTRUNTME_EXC_CODE);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public void setResultMap(SortedMap<String, Object> resultMap) {
        this.resultMap = resultMap;
    }
}
