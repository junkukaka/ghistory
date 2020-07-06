package com.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("gcode")
public class GCode {
    private static final long serialVersionUID = -8985545025018238754L;

    @Id
    private String id;

    //大分类
    private String ty;
    private String tyName;
    //小分类
    private String code;
    private String codeName;
}
