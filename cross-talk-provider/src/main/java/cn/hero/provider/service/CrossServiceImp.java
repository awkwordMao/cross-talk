package cn.hero.provider.service;

import cn.hero.model.Cross;
import cn.hero.model.Page;
import cn.hero.provider.db.dao.CrossMapper;
import cn.hero.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CrossServiceImp implements CrossService {

    @Resource
    CrossMapper crossMapper;

    @Override
    public void addCross(Cross cross) {

    }

    @Override
    public void updateCross(Integer crossId) {

    }

    @Override
    public Result<Cross> crossList() {
        return null;
    }

    @Override
    public Result<Cross> findById(Integer crossId) {
        return null;
    }

    @Override
    public Result<List<Cross>> crossListOfPage(Page page) {
        Result<List<Cross>> result = new Result<>();
        List<Cross> list = crossMapper.findCrossOfPage(page);
        result.setStatus(0);
        result.setMsg("yes");
        result.setData(list);
        return result;
    }
}
