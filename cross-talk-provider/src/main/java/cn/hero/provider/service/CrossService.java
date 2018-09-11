package cn.hero.provider.service;

import cn.hero.model.Cross;
import cn.hero.provider.db.dao.CrossMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Author:lijie
 * cross_talk 服务
 */
@Service
public class CrossService {

    @Autowired
    CrossMapper crossMapper;

    public int addCross(Cross cross){
        return crossMapper.insertCross(cross);
    }

    //更新点赞数
    public int updateCross(Integer crossId){
        return crossMapper.updateCross(crossId);
    }

    public List<Cross> crossList(){
        return crossMapper.findAllCross();
    }
}