package base.dto;

import java.util.Date;

/**
 * 用户登录标示
 * @author libra
 *
 */
public class UserIdentify {
	

	/**
	 * 用户ID
	 */
	private int userId;

	/**
	 * 用户类型
	 */
	private int userType;
	
	/**
	 * 用户账户
	 */
	private String userName;
	/**
	 * 登录时间
	 */
	private Date loginDate;
	
	/**
	 * 扩展ID
	 * 如果是商家 则存放商家ID
	 * 如果是运营商 则存放运营商ID
	 */
	private int extendId;

	/**
	 * 当前登录身份
	 */
	private int curUType;

	public int getCurUType() {
		return curUType;
	}

	public void setCurUType(int curUType) {
		this.curUType = curUType;
	}

	public int getUserType() {
		return userType;
	}
	public void setUserType(int userType) {
		this.userType = userType;
	}
	public int getExtendId() {
		return extendId;
	}
	public void setExtendId(int extendId) {
		this.extendId = extendId;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int id) {
		this.userId = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
