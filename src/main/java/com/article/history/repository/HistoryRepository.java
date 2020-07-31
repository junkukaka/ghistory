package com.article.history.repository;


import com.entry.History;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 共同代码仓库
 */
@Repository
public interface HistoryRepository extends MongoRepository<History,String> {
    List<History> findByType(String type);
    List<History> findByArticleTitleLike(String str);
}
