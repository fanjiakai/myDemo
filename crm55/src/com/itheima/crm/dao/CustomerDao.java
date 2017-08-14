package com.itheima.crm.dao;

import java.util.List;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

/**
 * 客户持久层接口
 * @author 范佳凯
 *
 */
public interface CustomerDao {

	/**
	 * 条件查询带分页
	 * @param queryVo
	 * @return
	 */
	List<Customer> findListByBasedict(QueryVo queryVo);

	/**
	 * 查询总记录数
	 * @return
	 */
	Integer findAllNum(QueryVo queryVo);

	/**
	 * 根据id查询客户
	 * @param id
	 * @return
	 */
	Customer findCustomerById(Integer id);

	/**
	 * 通过id修改客户
	 * @param customer
	 */
	void updateCustomerById(Customer customer);

	/**
	 * 通过id删除客户
	 * @param id
	 */
	void deleteCustomerById(Integer id);

}
