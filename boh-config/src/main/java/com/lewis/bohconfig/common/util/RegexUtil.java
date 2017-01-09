package com.lewis.bohconfig.common.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class RegexUtil {
	
	/**
	 * 校验ip
	 * 
	 * @param Ip
	 * @return
	 */
	public static boolean checkIp(String Ip) {
		String regEx = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
				+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
				+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
				+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
		if (StringUtils.isEmpty(Ip)) {
			return false;
		}
		if (!Pattern.matches(regEx, Ip)) {
			return false;
		}
		return true;
	}

}
