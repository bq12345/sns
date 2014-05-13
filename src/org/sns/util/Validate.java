package org.sns.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author BaiQiang
 * @version 1.0
 */
public class Validate {
	public static boolean isEmail(String email) {
		if (null == email || "".equals(email))
			return false;
		Pattern p = Pattern.compile("\\w+@(\\w+.)+[a-z]{2,3}");
		Matcher m = p.matcher(email);
		return m.matches();
	}

	public static boolean isPhone(String phone) {
		Pattern p = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(phone);
		return m.matches();
	}

	public boolean isLogin() {
		return false;
	}
}
