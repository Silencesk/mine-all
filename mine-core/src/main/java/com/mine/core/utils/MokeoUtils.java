package com.mine.core.utils;

import com.mine.core.vo.SystemUser;

/**
 * @ClassName: MokeoUtils<br>
 * @Description: mokeo工具类<br>
 * @author liutao<br>
 * @date 2016年9月20日下午2:34:58<br>
 *
 */
public class MokeoUtils {

	private MokeoUtils() {}
	
	public static SystemUser getDefaultUser(){
		SystemUser user = new SystemUser();
		user.setId(new Long(1));
		user.setUserCode("admin");
		user.setUserName("自动");
		user.setIsSuperAdmin(1);
		user.setDeptId(Long.valueOf(1));
		user.setDeptName("管理部-wonhigh");
		return user;
	}
}
