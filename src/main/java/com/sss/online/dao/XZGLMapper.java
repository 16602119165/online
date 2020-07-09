package com.sss.online.dao;

import com.sss.online.pojo.XZGL;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author
 * @create 2019-07-04-15:05
 */
@Repository
public interface XZGLMapper {
    //请假插入

    int QJGLAdd(@Param("xzgl") XZGL xzgl);
}
