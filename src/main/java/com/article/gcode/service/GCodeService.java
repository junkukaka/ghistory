package com.article.gcode.service;

import com.article.gcode.repository.GCodeRepository;
import com.entry.GCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GCodeService {

    @Autowired
    GCodeRepository gCodeRepository;

    /**
     * 添加
     * @param code
     * @return
     */
    public GCode save(GCode code){
        return gCodeRepository.save(code);
    }

    /**
     * 删除
     * @param id
     */
    public void delete(String id){
         gCodeRepository.deleteById(id);
    }

    /**
     * 按照大分类查询
     * @param ty
     * @return
     */
    public List<GCode> findByTy(String ty){
        return gCodeRepository.findByTy(ty);
    }

    /**
     * 大分类，小分类查询 作用:去重
     * @param ty
     * @param code
     * @return
     */
    public GCode findByTyAndCode(String ty,String code){
        return gCodeRepository.findByTyAndCode(ty,code);
    }

    /**
     * 查询所有
     * @return
     */
    public List<GCode> findAll(){
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.ASC, "ty"),new Sort.Order(Sort.Direction.ASC,"code"));
        return gCodeRepository.findAll(sort);
    }


}
