package com.itheima.crm.service;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

import cn.itcast.utils.Page;

/**
 * 客户业务层接口
 * @author 范佳凯
 *
 */
public interface CustomerService {

	/**
	 * 条件查询
	 * @param queryVo
	 * @return
	 */
	public Page<Customer> findPage(QueryVo queryVo);

	/**
	 * 根据id查询客户
	 * @param id
	 * @return
	 */
	public Customer findCustomerById(Integer id);

	/**
	 * 根据id修改客户
	 * @param customer
	 */
	public void updateCustomerById(Customer customer);

	/**
	 * 根据id删除客户
	 * @param id
	 */
	public void deleteCustomerById(Integer id);

}
