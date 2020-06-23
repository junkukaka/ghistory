package com.user.service;

import com.entry.Member;
import com.user.repository.MemberRepository;
import com.utils.MyDateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;


    /**
     * 会员注册
     * @param member
     * @return
     */
    public Member register(Member member){
        //重复邮箱和昵称判断
        Member alias = this.getAlias(member.getAlias());
        Member mail = this.getMail(member.getMail());
        //如果有重复就返回null
        if(alias != null || mail != null){
            return null;
        }
        String date = MyDateUtils.getDateToString(new Date());
        member.setCreatTime(date);
        member.setUpdateTime(date);
        Member saved = memberRepository.save(member);
        return saved;
    }

    /**
     * 邮箱查询
     * @param mail
     * @return
     */
    public Member getMail(String mail){
        return memberRepository.findByMail(mail);
    }

    /**
     * 昵称查询
     * @param alias
     * @return
     */
    public Member getAlias(String alias){
        return memberRepository.findByAlias(alias);
    }
}
