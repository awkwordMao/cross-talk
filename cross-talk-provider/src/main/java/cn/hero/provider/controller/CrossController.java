package cn.hero.provider.controller;

import cn.hero.model.Cross;
import cn.hero.provider.service.CrossService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return "redirect:/";
    }

    /**
     * 根据 cross_id 让点赞数自增1
     * @param crossId
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public int updateGreatNumber(Integer crossId){
        crossService.updateCross(2);
        return 1;
    }

    /**
     * 查询所有 cross_talk
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
//    @ResponseBody
    public String crossList(Model model,@PathParam("userName") String userName){
        List<Cross> crossList = crossService.crossList();
//        JSONArray jsonArray = new JSONArray();
//        JSONObject jsonObject = null;
//        for (Cross cross : crossList) {
//            System.out.println(cross.getContent() + "---" + cross.getGreatNumber());
//            jsonObject = new JSONObject();
//            jsonObject.put("crossId", cross.getCrossId());
//            jsonObject.put("content", cross.getContent());
//            jsonObject.put("greatNumber", cross.getGreatNumber());
//            jsonArray.add(jsonObject);
//        }
//        String str = JSON.toJSON(crossList).toString();
        System.out.println(userName);
        model.addAttribute("crossList", crossList);
        model.addAttribute("userName", userName);
        return "index";
    }
}
