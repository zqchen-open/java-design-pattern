package com.czq.pay.strategy;

import com.czq.configuration.ApplicationContextHelper;
import com.czq.constants.ClientTypeConstants;
import com.czq.pay.strategy.processor.PayProcessorStrategy;
import com.czq.util.ClassUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 支付环境角色：三方渠道支付处理器
 * <p>
 * 只有有参构造，根据被选择的渠道支付方式code确定具体的支付策略，
 * 由具体的支付策略进行下单操作，并返回渠道支付
 *
 * @author leonzhangxf
 */
public class PayProcessorStrategyHandler {

    private static Logger logger = LoggerFactory.getLogger(PayProcessorStrategyHandler.class);

    private static final String STRATEGY_CODE_KEY = "STRATEGY_CODE";

    /**
     * 其它渠道支付方式code = 具体的支付策略的映射集合
     */
    private static Map<String, Class<? extends PayProcessorStrategy>> strategyMap = new ConcurrentHashMap<>(10);

    /**
     * app渠道支付方式code = 具体的支付策略的映射集合
     */
    private static Map<String, Class<? extends PayProcessorStrategy>> appStrategyMap = new ConcurrentHashMap<>(2);

    /**
     * h5渠道支付方式code = 具体的支付策略的映射集合
     */
    private static Map<String, Class<? extends PayProcessorStrategy>> h5StrategyMap = new ConcurrentHashMap<>(2);

    /**
     * pc渠道支付方式code = 具体的支付策略的映射集合
     */
    private static Map<String, Class<? extends PayProcessorStrategy>> pcStrategyMap = new ConcurrentHashMap<>(2);

    /**
     * 平台
     */
    private String clientType;
    /**
     * 支付渠道
     */
    private String strategyCode;

    /**
     * 根据渠道支付方式确定的支付策略
     * 实现的具体支付策略应该都定义在 {@see impl} 路径下
     */
    private PayProcessorStrategy payProcessorStrategy;

    /**
     * 私有构造函数
     */
    private PayProcessorStrategyHandler(String clientType, String strategyCode) {
        this.clientType = clientType;
        this.strategyCode = strategyCode;
    }

    static {
//        @SuppressWarnings("unchecked")
//        Set<Class<? extends PaymentStrategy>> classes =
//                (Set) ClassUtils.getClassesByInterfaceAndPackageName(PaymentStrategy.class,
//                        "trade.wcoawxprog", true);
        @SuppressWarnings("unchecked")
        Set<Class<? extends PayProcessorStrategy>> appClasses =
                (Set) ClassUtils.getClassesByInterfaceAndPackageName(PayProcessorStrategy.class,
                        "com.czq.strategyreflect.trade.app", true);
        @SuppressWarnings("unchecked")
        Set<Class<? extends PayProcessorStrategy>> h5Classes =
                (Set) ClassUtils.getClassesByInterfaceAndPackageName(PayProcessorStrategy.class,
                        "com.czq.strategyreflect.trade.h5", true);
        @SuppressWarnings("unchecked")
        Set<Class<? extends PayProcessorStrategy>> pcClasses =
                (Set) ClassUtils.getClassesByInterfaceAndPackageName(PayProcessorStrategy.class,
                        "com.czq.strategyreflect.trade.pc", true);
//        fullFillStrategyMap(classes, PaymentHandler.strategyMap);
        fullFillStrategyMap(appClasses, PayProcessorStrategyHandler.appStrategyMap);
        fullFillStrategyMap(h5Classes, PayProcessorStrategyHandler.h5StrategyMap);
        fullFillStrategyMap(pcClasses, PayProcessorStrategyHandler.pcStrategyMap);
    }

    /**
     * 根据实现装载支付策略
     *
     * @param classes     具体实现类文件
     * @param strategyMap 需要装载的策略映射，不能为空
     */
    private static void fullFillStrategyMap(Set<Class<? extends PayProcessorStrategy>> classes,
                                            Map<String, Class<? extends PayProcessorStrategy>> strategyMap) {
        if (null != classes && classes.size() > 0) {
            for (Class<? extends PayProcessorStrategy> clazz : classes) {
                try {
                    final Field strategyCode = clazz.getField(STRATEGY_CODE_KEY);
                    strategyMap.put(strategyCode.get(null).toString(), clazz);
                } catch (Exception ex) {
                    logger.error("##############################################");
                    logger.error("Get clazz field error.....");
                    logger.error("##############################################");
                    logger.error(ExceptionUtils.getStackTrace(ex));
                }
            }
        }
    }


    /**
     * 获取支付处理器实例，需要传入计算得到的渠道支付方式对象。
     * <p>
     *
     * @return 支付处理器，当查询不到时，会返回null
     */
    public static @Nullable
    PayProcessorStrategyHandler getInstance(String clientType, String strategyCode) {
        // 缺少必要数据，不会返回支付处理器实例
        if (StringUtils.isEmpty(clientType) || StringUtils.isEmpty(strategyCode)) {
            logger.warn("#####支付处理器生成失败：生成支付处理器参数错误.....");
            return null;
        }
        PayProcessorStrategyHandler payProcessorStrategyHandler = new PayProcessorStrategyHandler(clientType, strategyCode);
        // 根据被选择渠道支付方式code，匹配得到具体的支付策略
        PayProcessorStrategy payProcessorStrategy = payProcessorStrategyHandler.determinePaymentStrategy();
        if (null == payProcessorStrategy) {
            return null;
        }
        return payProcessorStrategyHandler;
    }

    /**
     * 根据被选择渠道支付方式code，匹配得到具体的支付策略
     *
     * @return 具体的支付策略
     */
    private PayProcessorStrategy determinePaymentStrategy() {
        //去掉第一个标识，使用第二和第三个标识来定位一个支付策略
        String strategyCode = this.strategyCode;
        if (!StringUtils.hasText(strategyCode)) {
            logger.warn("#####选择的渠道支付方式中不包含code字段");
            return null;
        }
        String code = strategyCode.substring((strategyCode.contains("_") ? strategyCode.indexOf("_") : -1) + 1);
        Class<? extends PayProcessorStrategy> strategyClazz;
        if (this.clientType.equals(ClientTypeConstants.CLIENT_TYPE_APP)) {
            strategyClazz = appStrategyMap.get(code);
        } else if (this.clientType.equals(ClientTypeConstants.CLIENT_TYPE_PC)) {
            strategyClazz = pcStrategyMap.get(code);
        } else if (this.clientType.equals(ClientTypeConstants.CLIENT_TYPE_H5)) {
            strategyClazz = h5StrategyMap.get(code);
        } else {
            strategyClazz = strategyMap.get(code);
        }
        if (null == strategyClazz) {
            logger.warn("#####暂不支持的支付策略，即渠道支付方式.....");
            return null;
        } else {
            try {
                //通过SpringConfigUtils获取spring生成的具体策略类实现
                PayProcessorStrategy payProcessorStrategy = ApplicationContextHelper.getBean(strategyClazz);
                this.payProcessorStrategy = payProcessorStrategy;
                return payProcessorStrategy;
            } catch (Exception ex) {
                logger.error("#####支付处理器的支付策略实例生成失败.....");
                logger.error(ExceptionUtils.getStackTrace(ex));
                return null;
            }
        }
    }

    /**
     * 统一下单
     *
     * @param paymentParams 支付请求参数实体，需要改实体中包含的成员不包含的额外属性，
     *                      请在该实体中添加成员，推荐不添加或者添加额外参数封装好的实体。
     *                      注意：必须除了扩展字段之外的数据封装完全，且数据完整性经过参数校验，
     *                      在接口实现方法中不会再进行更多的冗余参数校验，
     *                      假定传入的参数实体是完备的。推荐通过查询数据库获得完整实体后封装进入此支付参数实体之中。
     * @return 支付参数
     */
    public @NonNull
    String unifiedOrder(String paymentParams) {
        String unifiedOrder = payProcessorStrategy.unifiedOrder(paymentParams);
        return unifiedOrder;
    }


}
