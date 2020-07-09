package com.sss.online.dao;

import com.sss.online.pojo.OverTime;
import org.springframework.stereotype.Repository;

/**
 * @author
 * @create 2019-06-04-16:12
 */
@Repository
public interface OverTimeMapper {
    int insertOverTime(OverTime overTime);
}
