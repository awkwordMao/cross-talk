package cn.hero.provider.controller;

import cn.hero.model.User;
import cn.hero.provider.service.UserService;
import cn.hero.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

/**
 * user处理
 */
@Controller
@RequestMapping("/user")
public class UserController {

    Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    /**
     * 用户登录验证
     * @param userName
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result<User> login(@PathParam("userName") String userName, @PathParam("password") String password, HttpServletRequest request){
        Result result = new Result();
        result = userService.checkLogin(userName, password, request);
        return result;
    }

    /**
     * user注册
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@PathParam("userName") String userName, @PathParam("password") String password, @PathParam("password2") String password2){
        LOGGER.info("1: " + userName + "2: " + password + "3: " + password2);
        if(password.equals(password2)){
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            userService.insertUser(user);
        }
        return "login";
    }


}
