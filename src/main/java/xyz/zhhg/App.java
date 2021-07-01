package xyz.zhhg;

import com.aliyuncs.alidns.model.v20150109.UpdateDomainRecordRequest;
import org.apache.http.client.utils.DateUtils;
import xyz.zhhg.mydomain.Config;
import xyz.zhhg.mydomain.service.UpdateDomainRecordService;
import xyz.zhhg.mydomain.util.DoMainUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println(Config.getAccessKeyId()+"\n"+Config.getAccessKeySecret());
        timer1();
    }
    public static void timer1() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, 12); // 控制时
                calendar.set(Calendar.MINUTE, 0);       // 控制分
                calendar.set(Calendar.SECOND, 0);       // 控制秒
                Date time = calendar.getTime();
                System.out.println("定时任务开始执行"+ DateUtils.formatDate(time,"YYYYMMDDhhmmSS"));
                try {
                    UpdateDomainRecordService.updateForHostIp();
                } catch (Exception e) {
                    System.out.println("ip修改失败【"+e.getMessage()+"】");
                }

            }
        }, 0, Config.TASK_CYCLE_TIME);// 设定指定的时间time,此处为2000毫秒
    }
}
