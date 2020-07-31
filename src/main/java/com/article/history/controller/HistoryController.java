package com.article.history.controller;

import com.article.history.service.HistoryService;
import com.entry.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/history")
@RestController
@CrossOrigin(origins="*",maxAge=3600)
public class HistoryController {

    @Autowired
    HistoryService historyService;


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public @ResponseBody History save(@RequestBody History history){
        return historyService.save(history);
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public @ResponseBody List<History> findAll(){
        return historyService.findAll();
    }

    /**
     * 大分类查询
     * @param ty
     * @return
     */
    @RequestMapping(value = "/findByType/{ty}",method = RequestMethod.GET)
    public @ResponseBody List<History> findByType(@PathVariable String ty){
        return historyService.findByType(ty);
    }

    /**
     * @Author nanguangjun
     * @Description // search title with like
     * @Date 오전 10:44 2020-07-20
     * @Param
     * @return
     **/
    public @ResponseBody List<History> findByArticleTitleLike(@PathVariable String title){
        return historyService.findByArticleTitleLike(title);
    }

    /**
     * @Author nanguangjun
     * @Description //TODO
     * @Date 오후 6:32 2020-07-16
     * @Param [id]
     * @return int
     **/
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    public int deleteById(@PathVariable String id){
        //成功
        int flag = 1;
        try {
            historyService.deleteById(id);
        } catch (Exception e) {
            flag = 0;
        } finally {
            return flag;
        }
    }

    /**
     * @Author nanguangjun
     * @Description //article 详细页面
     * @Date 17:39 2020/7/28
     * @Param [id]
     * @return java.util.Map<java.lang.String,java.lang.Object>
     **/
    @RequestMapping(value = "/findHistoryDetail/{id}",method = RequestMethod.GET)
    public Map<String,Object> findHistoryDetail(@PathVariable String id){
        if(id == "" || id == null){
            return null;
        }
        return historyService.findById(id);
    }
}
