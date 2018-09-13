package cn.hero.provider.controller;

import cn.hero.model.User;
import cn.hero.provider.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
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
     * user登录
     * @param userName
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@PathParam("userName") String userName, @PathParam("password") String password, Model model){
        LOGGER.info("----------------" + "userName: " + userName + "password: " + password);
        User user = userService.getUserByName(userName);
        if(userName.equals(user.getUserName()) && password.equals(user.getPassword())){
            model.addAttribute("userName", userName);
            return "redirect:/?userName=" + userName;
        }
        return "login";
    }

    /**
     * user注册
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
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
