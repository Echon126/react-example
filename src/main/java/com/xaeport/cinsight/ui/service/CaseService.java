package com.xaeport.cinsight.ui.service;

import com.xaeport.cinsight.ui.data.entity.CaseInfo;
import com.xaeport.cinsight.ui.data.mapper.CaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 案件 service
 * Created by xcp on 2017/5/25.
 */
@Service
public class CaseService {

    @Autowired
    CaseMapper caseMapper;

    public List<CaseInfo> selectCaseList() {
        return this.caseMapper.selectCaseList();
    }

    public void deleteCaseByCaseId(String caseId) {
        this.caseMapper.deleteCaseByCaseId(caseId);
    }

    public void createCase(CaseInfo caseInfo) {
        this.caseMapper.createCase(caseInfo);
    }

    public void updateCase(CaseInfo caseInfo) {
        this.caseMapper.updateCase(caseInfo);
    }

    public int checkCaseCodeCount(String caseCode) {
        return this.caseMapper.checkCaseCodeCount(caseCode);
    }

    public String selectMaxCaseCode() {
        return this.caseMapper.selectMaxCaseCode();
    }

}
