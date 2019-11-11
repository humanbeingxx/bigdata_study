package priv.cxs.data.hive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import priv.cxs.data.hive.SpringBaseTest;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/29 下午5:25
 **/
public class JobServiceImplTest extends SpringBaseTest {

    @Autowired
    private JobService jobService;


    @Test
    public void testQueryAllJobs() {
    }
}