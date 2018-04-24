package com.song;

import com.song.config.MailConfig;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import io.swagger.annotations.Api;
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
import java.io.Writer;

@EnableScheduling
@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
public class WechatApp {

    public static void main(String[] args) {
        SpringApplication.run(WechatApp.class, args);
    }

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("swagger-ui")
                        .description("")
                        .version("1.0")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    @Resource
    private MailConfig mailConfig;

    @Bean
    public Mailer createMailer() {
        return new Mailer(mailConfig.getHost(), mailConfig.getPort(), mailConfig.getUserName(), mailConfig.getPassWord());
    }

    public static String PREFIX_CDATA = "<![CDATA[";
    public static String SUFFIX_CDATA = "]]>";

    /**
     * 扩展xstream，使其支持CDATA块
     * 由于xstream框架本身并不支持CDATA块的生成，下面代码是对xtream做了扩展，
     * 使其支持在生成xml各元素值时添加CDATA块。
     */
    @Bean
    public XStream createXStream() {
        return new XStream(new XppDriver() {
            @Override
            public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out) {
                    // 对所有xml节点的转换都增加CDATA标记
                    boolean cdata = true;

                    @Override
                    public void startNode(String name, Class clazz) {
                        super.startNode(name, clazz);
                    }

                    @Override
                    protected void writeText(QuickWriter writer, String text) {
                        if (cdata) {
                            writer.write(PREFIX_CDATA);
                            writer.write(text);
                            writer.write(SUFFIX_CDATA);
                        } else {
                            super.writeText(writer, text);
                        }
                    }
                };
            }
        });
    }
}