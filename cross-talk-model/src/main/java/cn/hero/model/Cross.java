package cn.hero.model;

import java.util.Date;

/**
 * cross 实体类
 * Author: lijie
 * CreatTime: 2018/9/5
 */
public class Cross {

    private Integer crossId;
    private String type; //类型
    private String content;  //内容
    private String creatBy;  //发表人
    private Date creatTime;  //发表时间

    public Cross() {
    }

    public Integer getId() {
        return crossId;
    }

    public void setId(Integer crossId) {
        this.crossId = crossId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
