package com.entry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("history")
public class History {
    private static final long serialVersionUID = -8985545025018238754L;
    @Id
    private String id;

    //用户ID
    private String userId;
    //标题
    private String articleTitle;
    //原文链接
    private String origArticleLink;
    //主图片
    private String mainImage;
    //文章内容
    private String content;
    //文章类型
    private String type;
    //视频作者主页
    private String videoOwnerPage;
    //视频作者名称
    private String videoOwnerName;
    //视频嵌入代码
    private String videoOwnerLink;

    private String creatTime;
    private String updateTime;

}
