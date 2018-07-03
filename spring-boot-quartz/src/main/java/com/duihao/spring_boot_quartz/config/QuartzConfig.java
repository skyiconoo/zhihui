package com.duihao.spring_boot_quartz.config;

import java.io.IOException;
import java.util.Properties;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.duihao.spring_boot_quartz.task.ScheduleTask;

/**
 * quartz定时任务调度
 * 
 * @author lichenglin
 *
 */
//@Configuration
public class QuartzConfig {

	/** 
     * Details：配置定时任务 
     */  
    @Bean(name = "marketingActivityJobDetail")  
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduleTask task) {// ScheduleTask为需要执行的任务  
        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();  
        /* 
         *  是否并发执行 
         *  例如每5s执行一次任务，但是当前任务还没有执行完，就已经过了5s了， 
         *  如果此处为true，则下一个任务会执行，如果此处为false，则下一个任务会等待上一个任务执行完后，再开始执行 
         */  
        jobDetail.setConcurrent(false);  
          
        jobDetail.setName("marketing_activity");// 设置任务的名字  
        jobDetail.setGroup("marketing_activity");// 设置任务的分组，这些属性都可以存储在数据库中，在多任务的时候使用  
        
        /* 
         * 为需要执行的实体类对应的对象 
         */  
        jobDetail.setTargetObject(task);  
          
        /* 
         * marketingActivity为需要执行的方法 
         * 通过这几个配置，告诉JobDetailFactoryBean我们需要执行定时执行ScheduleTask类中的marketingActivity方法 
         */  
        jobDetail.setTargetMethod("marketingActivity"); 
        return jobDetail;  
    } 
      
    /** 
     * Details：配置定时任务的触发器，也就是什么时候触发执行定时任务 
     */  
    @Bean(name = "marketingActivityJobTrigger")  
    public CronTriggerFactoryBean cronJobTrigger(MethodInvokingJobDetailFactoryBean jobDetail) {  
        CronTriggerFactoryBean tigger = new CronTriggerFactoryBean();  
        tigger.setJobDetail(jobDetail.getObject());  
        tigger.setCronExpression("0 0 1 * * ?");// 初始时的cron表达式 ,每天1点执行
        tigger.setName("marketing_activity");// trigger的name  
        return tigger;  
  
    }  
  
    /** 
     * Details：定义quartz调度工厂 
     */  
    @Bean(name = "marketingActivityScheduler")  
    public SchedulerFactoryBean schedulerFactory(Trigger cronJobTrigger) {  
        SchedulerFactoryBean bean = new SchedulerFactoryBean();  
        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job  
        bean.setOverwriteExistingJobs(true);  
        // 延时启动，应用启动1秒后  
        bean.setStartupDelay(1);  
        // 注册触发器  
        bean.setTriggers(cronJobTrigger);  
        return bean;  
    }  
}