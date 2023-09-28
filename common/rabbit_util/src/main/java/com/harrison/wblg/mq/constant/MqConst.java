package com.harrison.wblg.mq.constant;

public class MqConst {
    /**
     * 消息补偿
     */
    public static final String MQ_KEY_PREFIX = "wblg.mq:list";
    public static final int RETRY_COUNT = 3;

    /**
     * 商品上下架
     */
    public static final String EXCHANGE_GOODS_DIRECT = "wblg.goods.direct";
    public static final String ROUTING_GOODS_UPPER = "wblg.goods.upper";
    public static final String ROUTING_GOODS_LOWER = "wblg.goods.lower";
    //队列
    public static final String QUEUE_GOODS_UPPER  = "wblg.goods.upper";
    public static final String QUEUE_GOODS_LOWER  = "wblg.goods.lower";

    /**
     * 团长上下线
     */
    public static final String EXCHANGE_LEADER_DIRECT = "wblg.leader.direct";
    public static final String ROUTING_LEADER_UPPER = "wblg.leader.upper";
    public static final String ROUTING_LEADER_LOWER = "wblg.leader.lower";
    //队列
    public static final String QUEUE_LEADER_UPPER  = "wblg.leader.upper";
    public static final String QUEUE_LEADER_LOWER  = "wblg.leader.lower";

    //订单
    public static final String EXCHANGE_ORDER_DIRECT = "wblg.order.direct";
    public static final String ROUTING_ROLLBACK_STOCK = "wblg.rollback.stock";
    public static final String ROUTING_MINUS_STOCK = "wblg.minus.stock";

    public static final String ROUTING_DELETE_CART = "wblg.delete.cart";
    //解锁普通商品库存
    public static final String QUEUE_ROLLBACK_STOCK = "wblg.rollback.stock";
    public static final String QUEUE_SECKILL_ROLLBACK_STOCK = "wblg.seckill.rollback.stock";
    public static final String QUEUE_MINUS_STOCK = "wblg.minus.stock";
    public static final String QUEUE_DELETE_CART = "wblg.delete.cart";

    //支付
    public static final String EXCHANGE_PAY_DIRECT = "wblg.pay.direct";
    public static final String ROUTING_PAY_SUCCESS = "wblg.pay.success";
    public static final String QUEUE_ORDER_PAY  = "wblg.order.pay";
    public static final String QUEUE_LEADER_BILL  = "wblg.leader.bill";

    //取消订单
    public static final String EXCHANGE_CANCEL_ORDER_DIRECT = "wblg.cancel.order.direct";
    public static final String ROUTING_CANCEL_ORDER = "wblg.cancel.order";
    //延迟取消订单队列
    public static final String QUEUE_CANCEL_ORDER  = "wblg.cancel.order";

    /**
     * 定时任务
     */
    public static final String EXCHANGE_DIRECT_TASK = "wblg.exchange.direct.task";
    public static final String ROUTING_TASK_23 = "wblg.task.23";
    //队列
    public static final String QUEUE_TASK_23  = "wblg.queue.task.23";
}