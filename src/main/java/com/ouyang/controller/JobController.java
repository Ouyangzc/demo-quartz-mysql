package com.ouyang.controller;

import com.ouyang.config.QuartzManager;
import com.ouyang.entity.JobDetails;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName JobController
 * @Description TODO
 * @Author OuYang
 * @Date 2024/1/15 16:22
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/job")
public class JobController {

  @Autowired
  private QuartzManager qtzManager;

  @SuppressWarnings("unchecked")
  private static Class<? extends QuartzJobBean> getClass(String classname) throws Exception {
    Class<?> class1 = Class.forName(classname);
    return (Class<? extends QuartzJobBean>) class1;
  }

  /**
   * @param jobClassName
   * @param jobGroupName
   * @param cronExpression
   * @throws Exception
   */
  @PostMapping(value = "/addjob")
  public void addjob(@RequestParam(value = "jobClassName") String jobClassName,
      @RequestParam(value = "jobGroupName") String jobGroupName,
      @RequestParam(value = "cronExpression") String cronExpression) throws Exception {
    qtzManager.addOrUpdateJob(getClass(jobClassName), jobClassName, jobGroupName, cronExpression);
  }

  /**
   * @param jobClassName
   * @param jobGroupName
   * @throws Exception
   */
  @PostMapping(value = "/pausejob")
  public void pausejob(@RequestParam(value = "jobClassName") String jobClassName,
      @RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
    qtzManager.pauseJob(jobClassName, jobGroupName);
  }

  /**
   * @param jobClassName
   * @param jobGroupName
   * @throws Exception
   */
  @PostMapping(value = "/resumejob")
  public void resumejob(@RequestParam(value = "jobClassName") String jobClassName,
      @RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
    qtzManager.resumeJob(jobClassName, jobGroupName);
  }

  /**
   * @param jobClassName
   * @param jobGroupName
   * @param cronExpression
   * @throws Exception
   */
  @PostMapping(value = "/reschedulejob")
  public void rescheduleJob(@RequestParam(value = "jobClassName") String jobClassName,
      @RequestParam(value = "jobGroupName") String jobGroupName,
      @RequestParam(value = "cronExpression") String cronExpression) throws Exception {
    qtzManager.addOrUpdateJob(getClass(jobClassName), jobClassName, jobGroupName, cronExpression);
  }

  /**
   * @param jobClassName
   * @param jobGroupName
   * @throws Exception
   */
  @PostMapping(value = "/deletejob")
  public void deletejob(@RequestParam(value = "jobClassName") String jobClassName,
      @RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
    qtzManager.deleteJob(jobClassName, jobGroupName);
  }

  /**
   * @param pageNum
   * @param pageSize
   * @return
   */
  @GetMapping(value = "/queryjob")
  public List<JobDetails> queryjob(@RequestParam(value = "pageNum") Integer pageNum,
      @RequestParam(value = "pageSize") Integer pageSize) {
    List<JobDetails> jobAndTriggers = qtzManager.queryAllJobBean();
    return jobAndTriggers;
  }
}

