package com.itheima.crm.dao;

import java.util.List;

import com.itheima.crm.pojo.Basedict;

/**
 * 字典类持久层接口
 * @author 范佳凯
 *
 */
public interface BasedictDao {

	/**
	 * 查询所有菜单
	 * @param string
	 * @return
	 */
	List<Basedict> findDictByTypeCode(String string);

}
