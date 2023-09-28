package com.harrison.wblg.home.service.impl;

import com.harrison.wblg.client.product.ProductFeignClient;
import com.harrison.wblg.client.search.SkuFeignClient;
import com.harrison.wblg.activity.client.ActivityFeignClient;
import com.harrison.wblg.home.service.ItemService;
import com.harrison.wblg.vo.product.SkuInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private ActivityFeignClient activityFeignClient;

    @Autowired
    private SkuFeignClient skuFeignClient;
    @Resource
    private ThreadPoolExecutor threadPoolExecutor;
    //详情
    @Override
    public Map<String, Object> item(Long skuId, Long userId) {
        Map<String, Object> result = new HashMap<>();

        //skuId查询
        CompletableFuture<SkuInfoVo> skuInfocompletableFuture =
                CompletableFuture.supplyAsync(() -> {
            //远程调用获取sku对应数据
            SkuInfoVo skuInfoVo = productFeignClient.getSkuInfoVo(skuId);
            result.put("skuInfoVo", skuInfoVo);
            return skuInfoVo;
        },threadPoolExecutor);

        //sku对应优惠卷信息
        CompletableFuture<Void> activityCompletableFuture = CompletableFuture.runAsync(() -> {
            //远程调用获取优惠卷
            Map<String,Object> activityMap =
                    activityFeignClient.findActivityAndCoupon(skuId,userId);
            result.putAll(activityMap);
        },threadPoolExecutor);

        //更新商品热度
        CompletableFuture<Void> hotCompletableFuture = CompletableFuture.runAsync(() -> {
            //远程调用更新热度
            skuFeignClient.incrHotScore(skuId);
        },threadPoolExecutor);

        //任务组合

//
//        CompletableFuture allCompletableFuture=CompletableFuture.allOf(
//                skuInfocompletableFuture,
//                activityCompletableFuture,
//                hotCompletableFuture
//        );

        CompletableFuture.allOf(
                skuInfocompletableFuture,
                activityCompletableFuture,
                hotCompletableFuture
        ).join();
//        allCompletableFuture.whenComplete((result, ex) -> {
//            if (ex != null) {
//                if (skuInfocompletableFuture.isCompletedExceptionally()) {
//                    System.err.println("skuInfocompletableFuture failed: " + ex.getMessage());
//                }
//                if (activityCompletableFuture.isCompletedExceptionally()) {
//                    System.err.println("activityCompletableFuture failed: " + ex.getMessage());
//                }
//                if (hotCompletableFuture.isCompletedExceptionally()) {
//                    System.err.println("hotCompletableFuture failed: " + ex.getMessage());
//                }
//            }
//        }).join();

        return result;
    }
}
