package cn.hero.provider.service;

import cn.hero.model.User;
import cn.hero.provider.db.dao.UserMapper;
import cn.hero.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * user 服务
 */
public interface UserService {


    int insertUser(User user);

    Result<User> checkLogin(String name, String password, HttpServletRequest request);

}
