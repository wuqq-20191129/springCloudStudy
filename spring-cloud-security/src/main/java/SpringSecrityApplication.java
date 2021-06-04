import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @Classname SpringSecrityApplication
 * @Description TODO
 * @Date 2021/5/28 17:27
 * @Created by mh
 */
@SpringCloudApplication
public class SpringSecrityApplication {

    private static Logger logger = LoggerFactory.getLogger(SpringSecrityApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(SpringSecrityApplication.class,args);
        logger.info("程序启动中......");
    }
}
