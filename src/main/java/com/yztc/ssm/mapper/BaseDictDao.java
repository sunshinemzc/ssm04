package com.yztc.ssm.mapper;

import com.yztc.ssm.pojo.BaseDict;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BaseDictDao {
    /**
     * 查询
     * @param code
     * @return
     */
    public List<BaseDict> selectBaseDictListByCode(String code);



}
