package com.hxe.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hxe.common.exception.RRException;
import com.hxe.common.utils.Results;

/**
 * 异常处理器
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午10:16:19
 */
@RestControllerAdvice
public class RRExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(RRException.class)
	public Results handleRRException(RRException e){
		Results r = new Results();
		r.put("code", e.getCode());
		r.put("msg", e.getMessage());

		return r;
	}

	@ExceptionHandler(DuplicateKeyException.class)
	public Results handleDuplicateKeyException(DuplicateKeyException e){
		logger.error(e.getMessage(), e);
		return Results.error("数据库中已存在该记录");
	}

	@ExceptionHandler(Exception.class)
	public Results handleException(Exception e){
		logger.error(e.getMessage(), e);
		return Results.error();
	}
}
