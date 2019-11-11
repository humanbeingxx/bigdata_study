package priv.cxs.data.hive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.cxs.data.hive.controller.vo.WebRet;
import priv.cxs.data.hive.model.Job;
import priv.cxs.data.hive.service.JobService;

import java.util.List;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/29 下午4:34
 **/
@RestController
@RequestMapping("query")
public class DataQueryController {

    @Autowired
    private JobService jobService;

    @GetMapping(value = "allJob")
    public WebRet<List<Job>> queryAll() {
        List<Job> jobs = jobService.queryAllJobs();
        return WebRet.successWithData(jobs);
    }
}
