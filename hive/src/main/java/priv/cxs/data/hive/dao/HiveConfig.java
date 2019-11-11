package priv.cxs.data.hive.dao;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.sql.DataSource;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/29 下午6:15
 **/
@Component
@ConfigurationProperties("hive")
@Data
@Configuration
@Slf4j
public class HiveConfig {

    private String driver;
    private String url;
    private String userName;
    private String password;

    @Bean(name = "hiveJdbcDataSource")
    public DataSource dataSource() {
        Assert.notNull(url, "hive url cannot be null");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        log.info("Hive DataSource Inject Successfully...");
        return dataSource;
    }

    @Bean(name = "hiveJdbcTemplate")
    public JdbcTemplate hiveJdbcTemplate(@Qualifier("hiveJdbcDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
