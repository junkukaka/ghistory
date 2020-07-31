package com.article.history.service;

import com.article.history.repository.HistoryRepository;
import com.entry.History;
import com.entry.Member;
import com.user.repository.MemberRepository;
import com.utils.MyDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @Author nanguangjun
 * @Description //历史模块
 * @Date 오후 5:32 2020-07-17
 * @Param
 * @return
 **/
@Service
public class HistoryService {

    @Autowired
    HistoryRepository historyRepository;

    @Autowired
    MemberRepository memberRepository;

    public History save(History history){
        String date = MyDateUtils.getDateToString(new Date());
        history.setCreatTime(date);
        history.setUpdateTime(date);
        return historyRepository.save(history);
    }

    public List<History> findAll(){
        return historyRepository.findAll();
    }

    public List<History> findByType(String type){
        List<History> byType = historyRepository.findByType(type);
        History history = null;
        //剪切内容
        for (int i = 0; i < byType.size(); i++) {
            history = byType.get(i);
            if(history.getContent().length()>50){
                String substring = history.getContent().substring(0, 50);
                history.setContent(substring + "。。。");
            }
        }
        return byType;
    }

    /**
     * @Author nanguangjun
     * @Description //TODO
     * @Date 17:35 2020/7/28
     * @Param [id]
     * @return com.entry.History
     **/
    public Map<String,Object> findById(String id){
        Optional<History> his = historyRepository.findById(id);
        Optional<Member> member = memberRepository.findById(his.get().getUserId());
        HashMap<String, Object> map = new HashMap<>();
        map.put("history",his.get());
        map.put("member",member.get());
        return map;
    }

    public void deleteById(String id){
         historyRepository.deleteById(id);
    }

    public List<History> findByArticleTitleLike(String str){
        return historyRepository.findByArticleTitleLike(str);
    }
}
