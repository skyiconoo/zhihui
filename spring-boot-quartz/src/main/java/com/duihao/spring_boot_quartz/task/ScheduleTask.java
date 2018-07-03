package com.duihao.spring_boot_quartz.task;


import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;


/**
 * Author : YongBo Xie </br>
 * File Name: ScheduleTask.java </br>
 * Created Date: 2018年3月31日 下午3:37:43 </br>
 * Modified Date: 2018年3月31日 下午3:37:43 </br>
 * Version: 1.0 </br>
*/
@Configuration  
@Component // 此注解必加  
@EnableScheduling // 此注解必加
public class ScheduleTask {
    
    private static Logger logger = Logger.getLogger(ScheduleTask.class);
    
    public void marketingActivity() {
        logger.info("execute activity");
    }

}