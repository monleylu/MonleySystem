package com.db.table;

public class GetAssociateResItem {
	
	public int getResId() {
		return resId;
	}
	public void setResId(int resId) {
		this.resId = resId;
	}
	public String getResIdName() {
		return resIdName;
	}
	public void setResIdName(String resIdName) {
		this.resIdName = resIdName;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getMachinetype() {
		return machinetype;
	}
	public void setMachinetype(String machinetype) {
		this.machinetype = machinetype;
	}
	private	int resId;
	private String resIdName;
	private String machinetype;
	private String ip;
}
