package com.czq.strategyreflect;


/**
 * 支付策略接口
 *
 * @author leonzhangxf
 */
public interface PaymentStrategy {

    /**
     * 统一下单接口
     *
     * @param paymentParams 支付请求参数实体，需要改实体中包含的成员不包含的额外属性，
     *                      请在该实体中添加成员，推荐不添加或者添加额外参数封装好的实体。
     *                      注意：必须除了扩展字段之外的数据封装完全，且数据完整性经过参数校验，
     *                      在接口实现方法中不会再进行更多的冗余参数校验，
     *                      假定传入的参数实体是完备的。推荐通过查询数据库获得完整实体后封装进入此支付参数实体之中。
     * @return 支付调用的参数封装
     */
    String unifiedOrder(String paymentParams);
}
