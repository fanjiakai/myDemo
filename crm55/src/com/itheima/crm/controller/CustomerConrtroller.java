package com.itheima.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.crm.pojo.Basedict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BasedictService;
import com.itheima.crm.service.CustomerService;

import cn.itcast.utils.Page;
/**
 * 客户管理控制层
 * @author 范佳凯
 *
 */
@Controller
public class CustomerConrtroller {

	@Autowired
	private BasedictService basedicrService;
	@Autowired
	private CustomerService	customerService;
	
	@RequestMapping(value={"/customer/list.action"})
	public String customerList(Model model,QueryVo queryVo){
		//客户来源
		List<Basedict> fromType = basedicrService.findDictByTypeCode("002");
		//所属行业
		List<Basedict> industryType = basedicrService.findDictByTypeCode("001");
		//客户级别
		List<Basedict> levelType = basedicrService.findDictByTypeCode("006");
		
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//调用获取当前页的条件查询
		Page<Customer> page = customerService.findPage(queryVo);
		model.addAttribute("page", page);
		
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustry());
		model.addAttribute("custLevel", queryVo.getCustLevel());
		return "customer";
	}
	
	/**
	 * 回显数据
	 * @param id
	 * @return
	 */
	@RequestMapping(value={"customer/edit.action"})
	public @ResponseBody 
	Customer edit(Integer id){
		Customer customer = customerService.findCustomerById(id);
		return customer;
	}
	
	/**
	 * 修改客户
	 * @param customer
	 * @return
	 */
	@RequestMapping(value={"customer/update.action"})
	public @ResponseBody String update(Customer customer){
		customerService.updateCustomerById(customer);
		return "ok";
	}
	
	/**
	 * 删除客户
	 * @param customer
	 * @return
	 */
	@RequestMapping(value={"customer/delete.action"})
	public @ResponseBody String delete(Integer id){
		customerService.deleteCustomerById(id);
		return "ok";
	}
	
	
	
	
}
