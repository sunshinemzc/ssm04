package com.yztc.ssm.controller;

import com.yztc.ssm.common.utils.Page;
import com.yztc.ssm.pojo.BaseDict;
import com.yztc.ssm.pojo.Customer;
import com.yztc.ssm.pojo.QueryVo;
import com.yztc.ssm.service.BaseDictService;
import com.yztc.ssm.service.BaseDictServiceImpl;
import com.yztc.ssm.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
 * @date 2017-11-10 15:32
 */

@Controller
public class CustomerController {

    @Value("${fromType.code}")
    private String fromTypeCode;
    /**
     *
     */
    @Resource
    private BaseDictService baseDictService;
    @Resource
    private CustomerService customerService;
    //入口
//    @RequestMapping(value ="/customer/list")
//    public String list(Model model){
//
//        List<BaseDict> fromType = baseDictService.selectBaseDictListByCode("002");
//        List<BaseDict>industryType = baseDictService.selectBaseDictListByCode(fromTypeCode);
//        List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");
//        model.addAttribute("fromType",fromType);
//        model.addAttribute("industryType",industryType);
//        model.addAttribute(";eveType",levelType);
//
//        return "customer";//返回的是jsp文件的名字
//    }



    @RequestMapping(value ="/customer/list")
    public String list(QueryVo vo, Model model){

        List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
        List<BaseDict>industryType = baseDictService.selectBaseDictListByCode("001");
        List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");
        model.addAttribute("fromType",fromType);
        model.addAttribute("industryType",industryType);
        model.addAttribute("levelType",levelType);

        //通过四个条件查询分页对象
//        private String custName;
//        private String custSource;
//        private String custIndustry;
//        private String custLevel;
        Page<Customer> page = customerService.selectPageByQueryVo(vo);

        model.addAttribute("page",page);
        model.addAttribute("custName",vo.getCustName());
        model.addAttribute("custSource",vo.getCustSource());
        model.addAttribute("custIndustry",vo.getCustIndustry());
        model.addAttribute("custLevel",vo.getCustLevel());
        return "customer";
    }
    //去修改页面
    @RequestMapping(value = "/customer/edit.action")
    public @ResponseBody
    Customer edit(Integer id){
      return customerService.selectCustomerById(id);

    }


    //修改保存
    @RequestMapping(value = "/customer/update.action")
    public @ResponseBody
    String update(Customer customer){
        //修改
        customerService.updateCustomerById(customer);
        return "OK";
    }

    //删除
    @RequestMapping(value = "customer/delete.action")
    public @ResponseBody
    String delete(Integer id){
        //删除
        customerService.deleteCustomerById(id);
        return "OK";
    }



}
