package com.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("member")
public class Member implements Serializable {

    private static final long serialVersionUID = -8985545025018238754L;

    @Id
    private String id;
    @Indexed
    private String alias;
    @Indexed
    private String mail;
    private String password;

    private String creatTime;
    private String updateTime;
}
