package priv.cxs.data.hive.service;

import priv.cxs.data.hive.model.Job;

import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/29 下午4:42
 **/
public interface JobService {

    List<Job> queryAllJobs();
}
