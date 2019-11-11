package priv.cxs.data.hive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@ServletComponentScan
@PropertySource(value = {"classpath:hive.properties"})
public class HiveApplication extends SpringBootServletInitializer {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "hello hive";
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HiveApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(HiveApplication.class, args);
    }
}
