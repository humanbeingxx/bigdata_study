package priv.cxs.data.hive.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xiaoshuang.cui
 * @date 2018/11/29 下午4:38
 **/
@Data
public class Job implements Serializable {
    private static final long serialVersionUID = 4508600780045372954L;

    private int code;

    private String name;

    private int salary;

    private String address;

    private int level;

    private int jobType;

}
