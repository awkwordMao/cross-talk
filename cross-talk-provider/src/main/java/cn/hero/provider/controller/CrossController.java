package cn.hero.provider.controller;

import cn.hero.model.Cross;
import cn.hero.provider.service.CrossService;
import cn.hero.provider.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;

/**
 * cross_talk 处理
 */
@Controller
@RequestMapping("/cross")
public class CrossController {

    @Autowired
    CrossService crossService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCross(@PathParam("content") String content, @PathParam("userName") String userName, Model model){

        System.out.println("content: " + content + "-- userName: " + userName);
        Date creatTime1 = new Date();

        Cross cross1 = new Cross();
        cross1.setContent(content);
        cross1.setCreatBy(userName);
        cross1.setCreatTime(creatTime1);
        cross1.setGreatNumber(0);
        crossService.addCross(cross1);
        model.addAttribute("userName", userName);
        return "redirect:/?userName=" + userName;
    }

    /**
     * 根据 cross_id 让点赞数自增1
     * @param crossId
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateGreatNumber(@PathParam("crossId") Integer crossId, @PathParam("userName") String userName, RedirectAttributes attributes){
        crossService.updateCross(crossId);
//        model.addAttribute("userName", userName);
        attributes.addFlashAttribute("userName", userName);
        return "redirect:/cross/list/";
//        JSONObject jsonObject = null;
//        crossService.updateCross(crossId);
//        Cross cross = crossService.findById(crossId);
//        String greatNumber = String.valueOf(cross.getGreatNumber());
//        jsonObject = new JSONObject();
//        jsonObject.put("greatNumber", greatNumber);
//        return jsonObject.toJSONString();
    }

    /**
     * 查询所有 cross_talk
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @ResponseBody
    public String crossList(Model model,@ModelAttribute(value = "userName") String userName){
        List<Cross> crossList = crossService.crossList();
        System.out.println("list:--" + userName);
        if(userName == null){
            userName = "";
        }
        System.out.println(userName);
        model.addAttribute("crossList", crossList);
        model.addAttribute("userName", userName);
        return "index";
    }
}
