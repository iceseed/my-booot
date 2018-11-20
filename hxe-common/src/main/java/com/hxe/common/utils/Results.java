package com.hxe.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月27日 下午9:59:27
 */
public class Results extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public Results() {
		put("code", 0);
		put("msg", "success");
	}
	
	public static Results error() {
		return error(500, "未知异常，请联系管理员");
	}
	
	public static Results error(String msg) {
		return error(500, msg);
	}
	
	public static Results error(int code, String msg) {
		Results r = new Results();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static Results ok(String msg) {
		Results r = new Results();
		r.put("msg", msg);
		return r;
	}
	
	public static Results ok(Map<String, Object> map) {
		Results r = new Results();
		r.putAll(map);
		return r;
	}
	
	public static Results ok() {
		return new Results();
	}

	@Override
	public Results put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
