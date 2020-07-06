package com.user.repository;

import com.entry.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends MongoRepository<Member,String> {
    Member findByAlias(String alias);
    Member findByMail(String mail);
    Member findByMailAndPassword(String mail,String password);
}
