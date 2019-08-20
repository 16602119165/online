package com.sss.online.service;

import com.sss.online.dto.XZBBQueryDTO;
import com.sss.online.pojo.UIComboTree;
import com.sss.online.pojo.XZBB;
import com.sss.online.vo.XZBBQueryVO;
import com.sss.online.vo.XZBBVO;

import java.util.List;

/**
 * @author
 * @create 2019-07-29-9:31
 */
public interface ReportFormService {
    public List<XZBB> queryXZBB(XZBBQueryDTO queryDTO);
    public List<UIComboTree> queryName();
}
