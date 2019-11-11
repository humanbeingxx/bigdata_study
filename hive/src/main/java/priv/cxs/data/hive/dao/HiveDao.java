package priv.cxs.data.hive.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import priv.cxs.data.hive.model.Job;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/29 下午7:16
 **/
@Component
public class HiveDao {

    @Autowired
    private JdbcTemplate hiveJdbcTemplate;

    public List<Job> queryAllJobs() {
        List<Map<String, Object>> result = hiveJdbcTemplate.queryForList("select * from tb_job");
        return parse(result);
    }

    private List<Job> parse(List<Map<String, Object>> result) {
        return result.stream().map(one -> {
            Job job = new Job();
            job.setCode(Integer.parseInt(String.valueOf(one.get("tb_job.code"))));
            job.setName(String.valueOf(one.get("tb_job.name")));
            job.setSalary(Integer.parseInt(String.valueOf(one.get("tb_job.salary"))));
            job.setAddress(String.valueOf(one.get("tb_job.address")));
            job.setLevel(Integer.parseInt(String.valueOf(one.get("tb_job.level"))));
            job.setJobType(Integer.parseInt(String.valueOf(one.get("tb_job.job_type"))));
            return job;
        }).collect(Collectors.toList());
    }
}
