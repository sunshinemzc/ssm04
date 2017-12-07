package com.yztc.ssm.mapper;

import com.yztc.ssm.pojo.Customer;
import com.yztc.ssm.pojo.QueryVo;

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
 * @date 2017-11-11 8:52
 */


public interface CustomerDao {
    //总条数
    public Integer customerCountByQueryVo(QueryVo vo);
    //结果集
    public List<Customer> selectCustomerListByQueryVo(QueryVo vo);
    //通过id查询客户
    public Customer selectCustomerById(Integer id);
    //通过id修改客户
    public void updateCustomerById(Customer customer);
    //通过id删除客户
    public void deleteCustomerById(Integer id);

}
