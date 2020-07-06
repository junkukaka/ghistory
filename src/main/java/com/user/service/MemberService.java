package com.user.service;

import com.entry.Member;
import com.user.repository.MemberRepository;
import com.utils.MyDateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
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
        String alias = this.getAlias(member.getAlias());
        String mail = this.getMail(member.getMail());
        //如果有重复就返回null
        if("member".equals(alias) || "member".equals(mail)){
            return null;
        }
        String date = MyDateUtils.getDateToString(new Date());
        member.setCreatTime(date);
        member.setUpdateTime(date);
        Member saved = memberRepository.save(member);
        return saved;
    }

    /**
     * login
     * @param member
     * @return
     */
    public Member login(Member member){
        return memberRepository.findByMailAndPassword(member.getMail(),member.getPassword());
    }

    /**
     * 邮箱查询
     * @param mail
     * @return
     */
    public String getMail(String mail){
        if(memberRepository.findByMail(mail) == null){
            return "";
        }else{
            return "member";
        }
    }

    /**
     * 昵称查询
     * @param alias
     * @return
     */
    public String getAlias(String alias){
        if(memberRepository.findByAlias(alias) == null){
            return "";
        }else{
            return "member";
        }
    }
}
