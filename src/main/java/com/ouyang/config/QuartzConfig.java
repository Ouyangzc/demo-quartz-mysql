package com.ouyang.config;

import com.ouyang.constant.QuartzConstant;
import java.io.IOException;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * @ClassName QuartzConfig
 * @Description quartz配置类
 * @Author OuYang
 * @Date 2024/1/16 9:02
 * @Version 1.0
 */
@Configuration
public class QuartzConfig {

  @Value("${config.quartzId}")
  private String order;

  @Bean
  public SchedulerFactoryBean scheduler(DataSource dataSource) throws IOException {
    Properties quartzProperties = PropertiesLoaderUtils.loadProperties(new ClassPathResource(
        QuartzConstant.QUARTZ_FILE_NAME));
    quartzProperties.setProperty(QuartzConstant.QUARTZ_PROPERTY_SCHEDULER_INSTANCE_NAME_KEY, QuartzConstant.QUARTZ_PROPERTY_SCHEDULER_INSTANCE_NAME_VALUE+ order);
    SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean();
    schedulerFactory.setQuartzProperties(quartzProperties);
    schedulerFactory.setDataSource(dataSource);
    schedulerFactory.setJobFactory(new SpringBeanJobFactory());
    schedulerFactory.setApplicationContextSchedulerContextKey("applicationContext");
    return schedulerFactory;
  }
}
