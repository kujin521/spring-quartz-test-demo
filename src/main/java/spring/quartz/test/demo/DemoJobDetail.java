package spring.quartz.test.demo;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class DemoJobDetail extends QuartzJobBean{
    //这里就是因为有上文中的AutowiringSpringBeanJobFactory才可以使用@Autowired注解，否则只能在配置文件中设置这属性的值
    @Autowired
    private DemoService demoService;

    @Override
    protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
        demoService.printNowTime();
    }

}
