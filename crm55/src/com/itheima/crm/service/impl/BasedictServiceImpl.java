package com.itheima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.dao.BasedictDao;
import com.itheima.crm.pojo.Basedict;
import com.itheima.crm.service.BasedictService;
/**
 * 字典类业务层实现类
 * @author 范佳凯
 *
 */
@Service
public class BasedictServiceImpl implements BasedictService {

	@Autowired
	private BasedictDao basedictDao;
	/**
	 * 查询所有菜单
	 */
	public List<Basedict> findDictByTypeCode(String string) {
		return basedictDao.findDictByTypeCode(string);
	}

}
