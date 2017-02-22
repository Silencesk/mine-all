package com.mine.core.vo;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.Map;

/**
 * 系统统一用户
 */
public class SystemUser implements Serializable {
	private static final long serialVersionUID = -8094604492554763459L;
    
	private Long id;	//用户ID
	
	/**
     * 用户编码
     */
    private String userCode;

    /**
     * 用户名称
     */
    private String userName;
    
    /**
     * 用户密码
     */
    private String password;

    /**
     * 手机号码(如不为_，则必须唯一，以支持可以用手机登录)
     */
    private String mobileNo;

    /**
     * 邮箱(如不为_，则必须唯一，以支持可以用邮箱登录)
     */
    private String email;
    
    /**
     * 是否为超级管理员
     * 1是，0否
     */
    private Integer isSuperAdmin;	//为超级管理员角色
    
    /**
	 * 用户权限菜单 key=Url val=RightValue 格式：key:/blf1-mdm-web/basbrandrelation
	 * val:127
	 */
	private Map<String, String> userMenuMap;
	
	/**
	 * 账户是否锁定
	 */
	private Integer isLock = 0;
	
	private Integer enableFlag;
	
	private String salt;
	
	private Long deptId;	//一级部门
	private String deptName;	//一级部门名称
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(Integer enableFlag) {
		this.enableFlag = enableFlag;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsSuperAdmin() {
		return isSuperAdmin;
	}

	public void setIsSuperAdmin(Integer isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}

	public Map<String, String> getUserMenuMap() {
		return userMenuMap;
	}

	public void setUserMenuMap(Map<String, String> userMenuMap) {
		this.userMenuMap = userMenuMap;
	}

	public Integer getIsLock() {
		return isLock;
	}

	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}