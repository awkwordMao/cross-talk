package cn.hero.provider.db.dao;

import cn.hero.model.Cross;
import cn.hero.model.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

/**
 * cross-talk 数据接口
 * Author:lijie
 */
@Mapper
public interface CrossMapper {

    int insertCross(Cross cross);

    //更新点赞数
    int updateCross(Integer crossId);

    List<Cross> findAllCross();

    Cross findById(Integer crossId);

    List<Cross> findCrossOfPage(Page page);
}
