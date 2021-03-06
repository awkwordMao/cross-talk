package cn.hero.provider.controller;

import cn.hero.model.Cross;
import cn.hero.model.Page;
import cn.hero.provider.service.CrossService;
import cn.hero.provider.service.UserService;
import cn.hero.util.Result;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    //定义分页查询每页数据量
    static final Integer pageSize = 10;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCross(@PathParam("content") String content, @PathParam("userName") String userName,RedirectAttributes attributes){

        System.out.println("content: " + content + "-- userName: " + userName);
        Date creatTime1 = new Date();

        Cross cross1 = new Cross();
        cross1.setContent(content);
        cross1.setCreatBy(userName);
        cross1.setCreatTime(creatTime1);
        cross1.setGreatNumber(0);
        crossService.addCross(cross1);
        attributes.addFlashAttribute("userName", userName);
        return "redirect:/cross/list/";
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
    public String crossList(){

        return "index";
    }

    /**
     * 分页查询
     * @param pageNo 页面传来的参数第几页
     * @return
     */
    @RequestMapping(value = "/listofpage", method = RequestMethod.GET)
    @ResponseBody
    public Result<List<Cross>> corssListOfPage(@PathParam("pageNo") Integer pageNo){
        Result<List<Cross>> result = new Result<List<Cross>>();
        Page page = new Page();
        page.setPageNo(pageNo);
        page.setPageSize(pageSize);
        page.setPageStart(pageNo, pageSize);
        result = crossService.crossListOfPage(page);
        return result;
    }

}
//pageNo pageStart pageSize=10
//1 0
//2 10
//3 20
//        (pageNo - 1)*pageSize