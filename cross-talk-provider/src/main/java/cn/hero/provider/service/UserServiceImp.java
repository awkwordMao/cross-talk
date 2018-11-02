package cn.hero.provider.service;

import cn.hero.model.User;
import cn.hero.provider.db.dao.UserMapper;
import cn.hero.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class UserServiceImp implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        return 0;
    }

    /**
     * 登录验证
     * @param name
     * @param password
     * @param request
     * @return
     */
    @Override
    public Result checkLogin(String name, String password, HttpServletRequest request) {
        Result result = new Result();
        User user = userMapper.getUserByName(name);
//        System.out.println(user.getUserName() + user.getPassword());
        if(user == null){
            result.setStatus(1);
            result.setMsg("用户不存在");
            return result;
        }
        if(!user.getPassword().equals(password)){
            result.setStatus(1);
            result.setMsg("密码错误");
            return result;
        }
        result.setStatus(0);
        result.setMsg("登录成功");
        //存入session，以供验证是否登录
        request.getSession().setAttribute("name", name);
        return result;
    }
}
