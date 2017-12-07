package com.yztc.ssm.service;

import com.yztc.ssm.common.utils.Page;
import com.yztc.ssm.pojo.Customer;
import com.yztc.ssm.pojo.QueryVo;

public interface CustomerService {
    //通过四个条件查询分页对象

    public Page<Customer> selectPageByQueryVo(QueryVo vo);

    //通过id查询客户

    public Customer selectCustomerById(Integer id);


    //通过id更新数据

    public void updateCustomerById(Customer customer);

    //通过id删除客户

    public void deleteCustomerById(Integer id);


}
