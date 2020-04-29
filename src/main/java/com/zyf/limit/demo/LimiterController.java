package com.zyf.limit.demo;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimiterController {

    private static final AtomicInteger ATOMIC_INTEGER_1 = new AtomicInteger();
    private static final AtomicInteger ATOMIC_INTEGER_2 = new AtomicInteger();
    private static final AtomicInteger ATOMIC_INTEGER_3 = new AtomicInteger();

    /**
     * @author fu
     * @description
     * @date 2020/4/8 13:42
     */
    @Limit(key = "limitTest", period = 100, count = 3,name = "普通测试")
    @GetMapping("/limitTest1")
    public int testLimiter1() {

        return ATOMIC_INTEGER_1.incrementAndGet();
    }

    /**
     * @author fu
     * @description
     * @date 2020/4/8 13:42
     */
    @Limit(key = "customer_limit_test", period = 100, count = 3, limitType = LimitType.CUSTOMER,name = "用户测试")
    @GetMapping("/limitTest2")
    public int testLimiter2() {

        return ATOMIC_INTEGER_2.incrementAndGet();
    }

    /**
     * @author fu
     * @description 
     * @date 2020/4/8 13:42
     */
    @Limit(key = "ip_limit_test", period = 100, count = 3, limitType = LimitType.IP,name = "IP测试")
    @GetMapping("/limitTest3")
    public int testLimiter3() {

        return ATOMIC_INTEGER_3.incrementAndGet();
    }

}
