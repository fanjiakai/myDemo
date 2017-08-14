package com.itheima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.dao.CustomerDao;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.CustomerService;

import cn.itcast.utils.Page;

/**
 * 客户业务层实现类
 * @author 范佳凯
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	/**
	 * 条件查询
	 */
	public Page<Customer> findPage(QueryVo queryVo) {
		//判断条件是否为空
		if(queryVo.getPage() == null){
			queryVo.setPage(1);
		}
		queryVo.setRows(5);
		queryVo.setStart((queryVo.getPage() - 1) * queryVo.getRows());
		Integer total = customerDao.findAllNum(queryVo);
		List<Customer> list = customerDao.findListByBasedict(queryVo);
		
		Page<Customer> customerPage = new Page<Customer>();
		customerPage.setPage(queryVo.getPage());
		customerPage.setRows(list);
		customerPage.setTotal(total);
		customerPage.setSize(queryVo.getRows());
		
		return customerPage;
	}
	
	/**
	 * 根据id查询客户
	 */
	public Customer findCustomerById(Integer id) {
		return customerDao.findCustomerById(id);
	}

	/**
	 * 根据id修改客户
	 */
	public void updateCustomerById(Customer customer) {
		customerDao.updateCustomerById(customer);
	}

	/**
	 * 根据id删除客户
	 */
	public void deleteCustomerById(Integer id) {
		customerDao.deleteCustomerById(id);
	}

}
