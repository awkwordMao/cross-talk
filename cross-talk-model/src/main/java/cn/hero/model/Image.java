package cn.hero.model;

import java.util.Date;

/**
 * image实体类
 * Author: lijie
 * CreatTime: 2018/9/7
 */
public class Image {

    private Integer id;
    private String image;
    private Integer greatNumber;
    private String creatBy;
    private Date creatTime;

    public Image() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getGreatNumber() {
        return greatNumber;
    }

    public void setGreatNumber(Integer greatNumber) {
        this.greatNumber = greatNumber;
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
