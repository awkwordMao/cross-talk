package cn.hero.provider.service;

import cn.hero.model.Cross;
import cn.hero.model.Page;
import cn.hero.provider.db.dao.CrossMapper;
import cn.hero.util.Result;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Author:lijie
 * cross_talk 服务
 */
public interface CrossService {

    void addCross(Cross cross);

    //更新点赞数
    void updateCross(Integer crossId);

    Result<Cross> crossList();

    Result<Cross> findById(Integer crossId);

    Result<List<Cross>> crossListOfPage(Page page);
}
