package cn.hero.provider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.websocket.server.PathParam;

/**
 * 入口处理
 */
@Controller
public class InitController {
    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String init(){
        return "index";
    }

    /**
     * 登录界面
     * @return
     */
    @GetMapping("/tologin")
    public String tologin(){
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

    /**
     * 进入添加 cross 界面
     * @return
     */
    @GetMapping("/toaddcross")
    public String toAddCross(@PathParam("userName") String userName, Model model){
        System.out.println("-----------------" + userName);
        if(("").equals(userName)){
            return "login";
        }else{
            model.addAttribute("userName", userName);
            return "addcross";
        }
    }
}
