package com.ouyang.stater;

import com.ouyang.config.QuartzManager;
import com.ouyang.constant.QuartzConstant;
import com.ouyang.entity.JobDetails;
import com.ouyang.job.HelloJob;
import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @ClassName QuartzStater
 * @Description 启动加载类
 * @Author OuYang
 * @Date 2024/1/16 9:19
 * @Version 1.0
 */
@Component
public class QuartzStater implements ApplicationRunner {


  @Resource
  private QuartzManager quartzManager;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    List<JobDetails> jobDetails = quartzManager.queryAllJobBean();
    Optional<JobDetails> optional = jobDetails.stream().filter(jd -> jd.getJobName().equals(
            QuartzConstant.JOB_KEY))
        .findAny();
    if (!optional.isPresent()) {
      quartzManager.addJob(HelloJob.class, QuartzConstant.JOB_KEY, QuartzConstant.JOB_GROUP,
          QuartzConstant.HEARTBEAT_CORN_DEFAULT_VALUE);
    }
  }
}
