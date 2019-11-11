package priv.cxs.data.hive.service;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.cxs.data.hive.dao.HiveDao;
import priv.cxs.data.hive.model.Job;

import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/29 下午4:41
 **/
@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private HiveDao hiveDao;

    @Override
    public List<Job> queryAllJobs() {
        return hiveDao.queryAllJobs();
    }
}
