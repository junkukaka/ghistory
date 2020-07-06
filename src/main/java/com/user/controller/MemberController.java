package com.user.controller;


import com.entry.Member;
import com.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/member")
@CrossOrigin(origins="*",maxAge=3600)
public class MemberController {

    @Autowired
    MemberService memberService;

    /**
     * 会员注册
     * @param member
     * @return
     */
    @RequestMapping(value = "/members/register",method = RequestMethod.POST)
    public @ResponseBody Member register(@RequestBody Member member){
        return memberService.register(member);
    }

    /**
     * member login
     * @param member
     * @return
     */
    @RequestMapping(value = "/members/login",method = RequestMethod.POST)
    public @ResponseBody Member login(@RequestBody Member member){
       return memberService.login(member);
    }

    /**
     * 邮箱验证
     * @param mail
     * @return
     */
    @RequestMapping(value = "/members/mail/{mail}",method = RequestMethod.GET)
    public String getMail(@PathVariable String mail){
        return memberService.getMail(mail);
    }

    /**
     * 昵称验证
     * @param alias
     * @return
     */
    @RequestMapping(value = "/members/alias/{alias}",method = RequestMethod.GET)
    public String getAlias(@PathVariable String alias){
        return memberService.getAlias(alias);
    }
}
