package spring.quartz.test.demo;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
/**
 * 使用spring.quartz.test.demo.AutowiredInternalBeanOfJobFactory+ApplicationContextAware
 * 在job初始化的时候，向job自动注入spring管理的bean
 * 
 * @author wangxiaohu
 * @version $Id: AutowiredInternalBeanJobFactory.java, v 0.1 2017年8月29日 上午11:00:47 wangxiaohu Exp $
 */
public class AutowiredInternalBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware{
    private transient AutowireCapableBeanFactory beanFactory;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        beanFactory = applicationContext.getAutowireCapableBeanFactory();
    }


    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception{
        Object job = super.createJobInstance(bundle);
        beanFactory.autowireBean(job);
        return job;
    }
}
