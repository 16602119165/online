package com.sss.online.service;

import com.sss.online.pojo.UICombobox;
import com.sss.online.vo.QJGLVO;

import java.util.List;

/**
 * @author
 * @create 2019-06-27-16:12
 */
public interface XZGLService {
    List<UICombobox> qjlxquery();
    List<UICombobox> csQuery();
    int qjglAdd(QJGLVO qjglvo);

}
