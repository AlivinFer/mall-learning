package com.alivin.mall.tiny.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Fer
 * @date 2021/8/11
 */
@Service
public class ScheduledService {

    // Seconds Minutes Hours DayofMonth Month DayofWeek
    // 8 月 11 号 每个小时 从 10 分开始 每隔 10分钟触发一次
    @Scheduled(cron = "0 10/10 * 11 8 ?")
    public void test() {
        String str = "you are so handsome";
        System.out.println("SpringTask任务："+str);
    }
}
