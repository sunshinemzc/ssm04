package com.yztc.ssm.service;

import com.yztc.ssm.common.utils.Page;
import com.yztc.ssm.mapper.CustomerDao;
import com.yztc.ssm.pojo.Customer;
import com.yztc.ssm.pojo.QueryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
 * 客户管理
 * @author bindu
 * @date 2017-11-11 1:39
 */

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerDao customerDao;
    //通过四个条件查询分页对象

    @Override
    public Page<Customer> selectPageByQueryVo(QueryVo vo){

        Page<Customer> page = new Page<>();
        //每页的条数
        vo.setSize(5);
       page.setSize(5);
       //   vo要有值才能进行页面的查找
        if (null!=vo){
            //判断当前页
               if (null!=vo.getPage()){
                   page.setPage(vo.getPage());
                   vo.setStartRow((vo.getPage()-1)*vo.getSize());
               }
               if (null!=vo.getCustName()&&!"".equals(vo.getCustName().trim())){
                   vo.setCustName(vo.getCustName().trim());
               }
            if (null!=vo.getCustSource()&&!"".equals(vo.getCustSource().trim())){
                vo.setCustSource(vo.getCustSource().trim());
            }
            if (null!=vo.getCustIndustry()&&!"".equals(vo.getCustIndustry().trim())){
                vo.setCustIndustry(vo.getCustIndustry().trim());
            }
            if (null!=vo.getCustLevel()&&!"".equals(vo.getCustLevel().trim())){
                vo.setCustLevel(vo.getCustLevel().trim());
            }
            //总条数
            page.setTotal(customerDao.customerCountByQueryVo(vo));
            //结果集
            page.setRows(customerDao.selectCustomerListByQueryVo(vo));


        }
        return page;


    }

    @Override
    public Customer selectCustomerById(Integer id) {

        return customerDao.selectCustomerById(id);
    }

    @Override
    public void updateCustomerById(Customer customer) {
        customerDao.updateCustomerById(customer);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        customerDao.deleteCustomerById(id);
    }


}
