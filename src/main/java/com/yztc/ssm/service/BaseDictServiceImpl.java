package com.yztc.ssm.service;

import com.yztc.ssm.mapper.BaseDictDao;
import com.yztc.ssm.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * _ooOoo_
 * o8888888o
 * 88" . "88
 * (| -_- |)
 * O\ = /O
 * ___/`---'\____
 * .   ' \\| |// `.
 * / \\||| : |||// \
 * / _||||| -:- |||||- \
 * | | \\\ - /// | |
 * | \_| ''\---/'' | |
 * \ .-\__ `-` ___/-. /
 * ___`. .' /--.--\ `. . __
 * ."" '< `.___\_<|>_/___.' >'"".
 * | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * \ \ `-. \_ __\ /__ _/ .-` / /
 * ======`-.____`-.___\_____/___.-`____.-'======
 * `=---='
 * .............................................
 *
 * @author bindu
 * @date 2017-11-10 17:10
 */

@Service
public class BaseDictServiceImpl implements BaseDictService {

    @Resource
    private BaseDictDao baseDictDao;


    @Override
    public List<BaseDict> selectBaseDictListByCode(String code) {

        return baseDictDao.selectBaseDictListByCode(code);
    }
}
