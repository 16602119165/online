package com.sss.online.serviceimpl;

import com.sss.online.dao.ReportFormMapper;
import com.sss.online.dto.XZBBQueryDTO;
import com.sss.online.pojo.Organization;
import com.sss.online.pojo.UIComboTree;
import com.sss.online.pojo.XZBB;
import com.sss.online.service.ReportFormService;
import com.sss.online.vo.XZBBQueryVO;
import com.sss.online.vo.XZBBVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @create 2019-07-29-9:34
 */
@Service
public class ReportFormServiceImpl implements ReportFormService {
    @Autowired
    ReportFormMapper reportFormMapper;
    @Override
    public List<XZBB> queryXZBB(XZBBQueryDTO queryDTO) {
        List<XZBB> xzbbList = reportFormMapper.query(queryDTO);
        if (xzbbList != null){
            return xzbbList;
        }
        return null;
    }

    @Override
    public List<UIComboTree> queryName() {
        List<Organization> organizations = reportFormMapper.queryName();
        UIComboTree rootTree = new UIComboTree();
        rootTree.setId(0);
        recursive(rootTree,organizations);
        List<UIComboTree> uiComboTreeList = rootTree.getChildren();
        return uiComboTreeList;
    }
    public UIComboTree recursive(UIComboTree subTree,List<Organization> allList){
        List<Organization> templeList = new ArrayList<>();
        List<UIComboTree> subTreeList = new ArrayList<>();
        for(Organization organization : allList){
            if (organization.getOrgPId() == subTree.getId()){
                templeList.add(organization);
            }
        }
        allList.removeAll(templeList);
        for(Organization organization:templeList){
            UIComboTree uiComboTree = new UIComboTree();
            uiComboTree.setId(organization.getId());
            uiComboTree.setText(organization.getOrgName());
            recursive(uiComboTree,allList);
            subTreeList.add(uiComboTree);
        }
        subTree.setChildren(subTreeList);
        return subTree;
    }
    public Long getCount(XZBBQueryDTO queryDTO){
        Long count = reportFormMapper.getCount(queryDTO);
        return count;
    }
}
