package com.ouyang.entity;

import java.util.Date;

/**
 * @ClassName JobDetails
 * @Description 定义JobDetails实体
 * @Author OuYang
 * @Date 2024/1/15 16:04
 * @Version 1.0
 */
public class JobDetails {

  private String cronExpression;
  private String jobClassName;
  private String triggerGroupName;
  private String triggerName;
  private String jobGroupName;
  private String jobName;
  private Date nextFireTime;
  private Date previousFireTime;
  private Date startTime;
  private String timeZone;
  private String status;

  public String getCronExpression() {
    return cronExpression;
  }

  public void setCronExpression(String cronExpression) {
    this.cronExpression = cronExpression;
  }

  public String getJobClassName() {
    return jobClassName;
  }

  public void setJobClassName(String jobClassName) {
    this.jobClassName = jobClassName;
  }

  public String getTriggerGroupName() {
    return triggerGroupName;
  }

  public void setTriggerGroupName(String triggerGroupName) {
    this.triggerGroupName = triggerGroupName;
  }

  public String getTriggerName() {
    return triggerName;
  }

  public void setTriggerName(String triggerName) {
    this.triggerName = triggerName;
  }

  public String getJobGroupName() {
    return jobGroupName;
  }

  public void setJobGroupName(String jobGroupName) {
    this.jobGroupName = jobGroupName;
  }

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public Date getNextFireTime() {
    return nextFireTime;
  }

  public void setNextFireTime(Date nextFireTime) {
    this.nextFireTime = nextFireTime;
  }

  public Date getPreviousFireTime() {
    return previousFireTime;
  }

  public void setPreviousFireTime(Date previousFireTime) {
    this.previousFireTime = previousFireTime;
  }

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  public String getTimeZone() {
    return timeZone;
  }

  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
