package com.article.gcode.repository;

import com.entry.GCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 共同代码仓库
 */
@Repository
public interface GCodeRepository extends MongoRepository<GCode,String> {
    List<GCode> findByTy(String ty);
    GCode findByTyAndCode(String ty,String code);
}

