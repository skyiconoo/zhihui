package com.duihao.spring_boot_quartz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 定时任务
 * 
 * @version 1.0
 * @author lichenglin
 */
public class ScheduleJobEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -704631862984460032L;
	
	/** 任务ID */
    private String jobId;
    /** 任务名称 */
    private String jobName;
    /** 任务分组 */
    private String jobGroup;
    /** 任务运行时间表达式 */
    private String cronExpression;
    /** 任务类(必须是Spring中定义的Bean) */
    private String targetObject;
    /** 任务方法 */
    private String targetMethod;
    /** 是否并发 */
    private boolean concurrent;
    /** 触发器开始执行任务时间 */
    private Date startDate;
    /** 触发器结束执行任务时间 */
    private Date endDate;
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobGroup() {
		return jobGroup;
	}
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}
	public String getCronExpression() {
		return cronExpression;
	}
	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	public String getTargetObject() {
		return targetObject;
	}
	public void setTargetObject(String targetObject) {
		this.targetObject = targetObject;
	}
	public String getTargetMethod() {
		return targetMethod;
	}
	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}
	public boolean isConcurrent() {
		return concurrent;
	}
	public void setConcurrent(boolean concurrent) {
		this.concurrent = concurrent;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    
    

}
