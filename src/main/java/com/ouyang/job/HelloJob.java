package com.ouyang.job;

import java.util.Date;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @ClassName HelloJob
 * @Description 自定义Job实体
 * @Author OuYang
 * @Date 2024/1/15 16:56
 * @Version 1.0
 */
public class HelloJob extends QuartzJobBean {

  private static final Logger logger = LoggerFactory.getLogger(HelloJob.class);

  @Override
  protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    // get parameters
//        context.getJobDetail().getJobDataMap().forEach(
//                (k, v) -> log.info("param, key:{}, value:{}", k, v)
//        );
    // write logics
    logger.info("Hello Job执行时间: " + new Date());
  }
}