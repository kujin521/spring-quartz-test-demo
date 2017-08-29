package spring.quartz.test.demo;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
/**
 * demo job
 * 
 * @author wangxiaohu
 * @version $Id: DemoJobDetail.java, v 0.1 2017年8月29日 下午1:50:54 wangxiaohu Exp $
 */
public class DemoJobDetail extends QuartzJobBean{
    //这里就是因为有上文中的AutowiredInternalBeanOfJobFactory才可以使用@Autowired注解
    @Autowired
    private DemoService demoService;
    
    //可以通过配置文件的中JobDetailFactoryBean里面的jobDataAsMap注入，但是需要提供set方法
    private String userName;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("DemoJobDetail.run..");
        demoService.printNowTime();
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
