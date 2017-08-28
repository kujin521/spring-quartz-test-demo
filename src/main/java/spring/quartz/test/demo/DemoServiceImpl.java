package spring.quartz.test.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;
@Service
public class DemoServiceImpl implements DemoService {
    private long M_ID = System.currentTimeMillis();
    public DemoServiceImpl(){
        System.out.println("init");
    }

    public void printNowTime() {
        System.out.println("DemoServiceImpl.printNowTime:" +M_ID+": "+ new SimpleDateFormat("yyyy-MM-dd: HH:mm:ss").format(new Date()));
    }

}
