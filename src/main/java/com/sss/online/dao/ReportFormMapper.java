package com.sss.online.dao;

import com.sss.online.dto.XZBBQueryDTO;
import com.sss.online.pojo.Organization;
import com.sss.online.pojo.UIComboTree;
import com.sss.online.pojo.XZBB;
import com.sss.online.vo.XZBBQueryVO;
import com.sss.online.vo.XZBBVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author
 * @create 2019-07-29-13:09
 */
@Repository
public interface ReportFormMapper {

    List<XZBB> query(@Param(value = "queryDTO") XZBBQueryDTO queryDTO);
    List<Organization> queryName();

    Long getCount(@Param(value = "queryDTO") XZBBQueryDTO queryDTO);
}
