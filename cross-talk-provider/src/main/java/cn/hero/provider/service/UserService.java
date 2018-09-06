package cn.hero.provider.service;

import cn.hero.model.User;
import cn.hero.provider.db.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * user 服务
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public int insertUser(User user){
        return userMapper.insertUser(user);
    }

    public User getUserByName(String name){
        return userMapper.getUserByName(name);
    }
}
