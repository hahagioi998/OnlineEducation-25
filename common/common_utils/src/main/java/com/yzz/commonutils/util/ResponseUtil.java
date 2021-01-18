package com.yzz.commonutils.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yzz.commonutils.vo.ResultData;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ResponseUtils
 * @Author yky
 * @Date 2021/1/18
 * @Version 1.0
 */
public class ResponseUtil {
	
	public static void out(HttpServletResponse response, ResultData r) {
		ObjectMapper mapper = new ObjectMapper();
		response.setStatus(HttpStatus.OK.value());
		response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
		try {
			mapper.writeValue(response.getWriter(), r);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
