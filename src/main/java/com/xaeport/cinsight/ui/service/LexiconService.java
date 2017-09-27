package com.xaeport.cinsight.ui.service;

import com.xaeport.cinsight.ui.data.entity.Lexicon;
import com.xaeport.cinsight.ui.data.mapper.LexiconMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 词库 service
 * Created by xcp on 2017/5/27.
 */
@Service
public class LexiconService {

    @Autowired
    LexiconMapper lexiconMapper;

    /**
     * 查询词库配置列表
     *
     * @return
     */
    public List<Lexicon> selectLexiconList() {
        return this.lexiconMapper.selectLexiconList();
    }

    /**
     * 修改词库配置 选中/不选
     *
     * @param lexiconList
     */
    public void updateLexiconEnabled(List<Lexicon> lexiconList) {
        for (int i = 0; i < lexiconList.size(); i++) {
            this.lexiconMapper.updateLexiconEnabled(lexiconList.get(i).getLexiconId(), lexiconList.get(i).getLexiconEnabled() == true ? 1 : 0);
        }
    }


}
