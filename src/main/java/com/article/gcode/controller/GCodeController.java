package com.article.gcode.controller;

import com.article.gcode.service.GCodeService;
import com.entry.GCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/gcode")
@RestController
@CrossOrigin(origins="*",maxAge=3600)
public class GCodeController {

    @Autowired
    GCodeService gCodeService;

    /**
     * 保存共同代码
     * @param gCode
     * @return
     */
    @RequestMapping(value = "/codes/save",method = RequestMethod.POST)
    public @ResponseBody GCode save(@RequestBody GCode gCode){
        return gCodeService.save(gCode);
    }

    /**
     * 查询所有
     * @return
     */
    @RequestMapping(value = "/codes/findAll",method = RequestMethod.GET)
    public @ResponseBody List<GCode> findAll(){
        return gCodeService.findAll();
    }

    /**
     * 大分类查询
     * @param ty
     * @return
     */
    @RequestMapping(value = "/codes/{ty}",method = RequestMethod.GET)
    public @ResponseBody List<GCode> findByTy(@PathVariable String ty){
        return gCodeService.findByTy(ty);
    }

    /**
     * 检查唯一值，按照大分类和小分类查询
     * @param code
     * @return
     */
    @RequestMapping(value = "/codes/findByTyAndCode",method = RequestMethod.GET)
    public @ResponseBody GCode findByTyAndCode(@RequestBody GCode code){
        return gCodeService.findByTyAndCode(code.getTy(),code.getCode());
    }

    /**
     * @Author nanguangjun
     * @Description //TODO
     * @Date 오후 6:32 2020-07-16
     * @Param [id]
     * @return int
     **/
    @RequestMapping(value = "/codes/delete/{id}",method = RequestMethod.DELETE)
    public int deleteById(@PathVariable String id){
        //成功
        int flag = 1;
        try {
            gCodeService.delete(id);
        } catch (Exception e) {
            flag = 0;
        } finally {
            return flag;
        }
    }
}
