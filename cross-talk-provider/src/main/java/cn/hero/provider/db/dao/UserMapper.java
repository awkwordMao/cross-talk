package cn.hero.provider.db.dao;

import cn.hero.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * user Dao层接口
 */
@Mapper
public interface UserMapper {

    int insertUser(User user);

    User getUserByName(String name);
}
