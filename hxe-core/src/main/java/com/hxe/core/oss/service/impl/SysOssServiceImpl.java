package com.hxe.core.oss.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hxe.common.utils.PageUtils;
import com.hxe.common.utils.Query;
import com.hxe.core.oss.dao.SysOssDao;
import com.hxe.core.oss.entity.SysOssEntity;
import com.hxe.core.oss.service.SysOssService;

import org.springframework.stereotype.Service;

import java.util.Map;


@Service("sysOssService")
public class SysOssServiceImpl extends ServiceImpl<SysOssDao, SysOssEntity> implements SysOssService {

	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<SysOssEntity> page = this.selectPage(
				new Query<SysOssEntity>(params).getPage()
		);

		return new PageUtils(page);
	}
	
}
