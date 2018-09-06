package cn.hero.provider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 入口处理
 */
@Controller
public class InitController {
    /**
     * 登录界面
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init(){
        return "login";
    }

    /**
     * 进入注册界面
     * @return
     */
    @GetMapping("/toregister")
    public String toRegister(){
        return "register";
    }
}
