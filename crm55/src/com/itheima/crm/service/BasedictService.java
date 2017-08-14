package com.itheima.crm.service;

import java.util.List;

import com.itheima.crm.pojo.Basedict;

/**
 * 字典类业务层接口
 * @author 范佳凯
 *
 */
public interface BasedictService {

	/**
	 * 查询所有条件
	 * @param string
	 * @return
	 */
	List<Basedict> findDictByTypeCode(String string);

	
}
