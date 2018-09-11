package cn.hero.provider.controller;

import cn.hero.model.Cross;
import cn.hero.provider.service.CrossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public int addCross(Cross cross){
        String content1 = "你要知道，虽然你是个大傻.子，但是并不是一个对社会毫无用处的人，因为傻不垃圾。";
        String creatBy1 = "gg";
        Date creatTime1 = new Date();

        Cross cross1 = new Cross();
        cross1.setContent(content1);
        cross1.setCreatBy(creatBy1);
        cross1.setCreatTime(creatTime1);
        cross1.setGreatNumber(0);
        crossService.addCross(cross1);
        return 1;
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
    public List<Cross> crossList(){

        return null;
    }
}
