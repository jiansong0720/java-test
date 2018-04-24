package ltd;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import ltd.config.MailConfig;
import ltd.config.MessageConfig;
import org.simplejavamail.mailer.Mailer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;

@EnableScheduling
@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
public class WeatherApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WeatherApp.class, args);
    }

    //swagger-ui相关
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("swagger-ui")
                        .description("天气项目")
                        .version("1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage("ltd"))
                .paths(PathSelectors.any())
                .build();
    }

    @Resource
    private MessageConfig messageConfig;

    @Bean
    public IAcsClient getIAcsClient() throws ClientException {
        //可自助调整超时时间
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //初始化acsClient,暂不支持region化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", messageConfig.getAccessKeyId(), messageConfig.getAccessKeySecret());
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", messageConfig.getProduct(), messageConfig.getDomain());
        return new DefaultAcsClient(profile);
    }

    @Resource
    private MailConfig mailConfig;

    @Bean
    public Mailer createMailer() {
        return new Mailer(mailConfig.getHost(), mailConfig.getPort(), mailConfig.getUserName(), mailConfig.getPassWord());
    }

}