package spring.quartz.test.demo;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
/**
 * 在job初始化的时候，向job自动注入spring管理的bean
 * 
 * @author wangxiaohu
 * @version $Id: AutowiredInternalBeanJobFactory2.java, v 0.1 2017年8月29日 下午2:12:01 wangxiaohu Exp $
 */
public class AutowiredInternalBeanJobFactory2 extends AdaptableJobFactory{
    //spring自动注入
    @Autowired
    private AutowireCapableBeanFactory beanFactory;
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object job = super.createJobInstance(bundle);
        //调用spring方法为job注入bean
        beanFactory.autowireBean(job);
        return job;
    }
}
