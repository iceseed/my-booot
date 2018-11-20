package com.hxe.common.exception;

import org.apache.shiro.authz.AuthorizationException;
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
 * @author Mark sunlightcs@gmail.com
 * @since 1.0.0 2016-10-27
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

	@ExceptionHandler(AuthorizationException.class)
	public Results handleAuthorizationException(AuthorizationException e){
		logger.error(e.getMessage(), e);
		return Results.error("没有权限，请联系管理员授权");
	}

	@ExceptionHandler(Exception.class)
	public Results handleException(Exception e){
		logger.error(e.getMessage(), e);
		return Results.error();
	}
}
