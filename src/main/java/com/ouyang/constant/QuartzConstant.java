package com.ouyang.constant;

/**
 * @ClassName QuartzConstant
 * @Description quartz 常量
 * @Author OuYang
 * @Date 2024/1/16 14:03
 * @Version 1.0
 */
public class QuartzConstant {

  public static final String JOB_KEY = "heartJob";
  public static final String JOB_GROUP = "heartGroup";

  /**
   * 每20秒执行一次
   */
  public static final String HEARTBEAT_CORN_DEFAULT_VALUE = "*/20 * * * * ? *";


  public static final String QUARTZ_FILE_NAME = "quartz.properties";

  public static final String QUARTZ_PROPERTY_SCHEDULER_INSTANCE_NAME_KEY = "org.quartz.scheduler.instanceName";
  public static final String QUARTZ_PROPERTY_SCHEDULER_INSTANCE_NAME_VALUE = "quartz-scheduler";
}
