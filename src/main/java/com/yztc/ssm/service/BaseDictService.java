package com.yztc.ssm.service;


import com.yztc.ssm.pojo.BaseDict;

import java.util.List;

/**
 * Service层
 */
public interface BaseDictService {

    /**
     * 查询
     * @param code
     * @return
     */
    public List<BaseDict> selectBaseDictListByCode(String code);
}
