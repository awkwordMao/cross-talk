package cn.hero.model;

import java.util.Date;

/**
 * cross 实体类,数据库中id自增
 * Author: lijie
 * CreatTime: 2018/9/5
 */
public class Cross {

    private Integer crossId;
    private String content;  //内容
    private Integer greatNumber;  //点赞数
    private String creatBy;  //发表人
    private Date creatTime;  //发表时间

    public Cross() {
    }

    public Integer getCrossId() {
        return crossId;
    }

    public void setCrossId(Integer crossId) {
        this.crossId = crossId;
    }

    public Integer getGreatNumber() {
        return greatNumber;
    }

    public void setGreatNumber(Integer greatNumber) {
        this.greatNumber = greatNumber;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatBy() {
        return creatBy;
    }

    public void setCreatBy(String creatBy) {
        this.creatBy = creatBy;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}
