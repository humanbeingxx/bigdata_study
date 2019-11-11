package priv.cxs.data.hive.dao;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.testng.annotations.Test;
import priv.cxs.data.hive.SpringBaseTest;
import priv.cxs.data.hive.model.Job;

import java.util.List;
import java.util.Map;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/29 下午7:13
 **/
public class HiveDaoTest extends SpringBaseTest {

    @Autowired
    private JdbcTemplate hiveJdbcTemplate;

    @Autowired
    private HiveDao hiveDao;

    @Test
    public void test() {
        List<Map<String, Object>> result = hiveJdbcTemplate.queryForList("show tables");
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void testQueryAllJobs() {
        List<Job> jobs = hiveDao.queryAllJobs();
        System.out.println(JSON.toJSONString(jobs));
    }
}
