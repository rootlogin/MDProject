/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:3:38
 */

package com.gohon.material.http;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TransportParamsHead implements Serializable {
	
	private String partner;

	private String sign;
	
	private String platform;
	
	private String net;
	
	private String oemid;
	
	private String version;
	
	private String phone_code;
	
	private String token;
	

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getNet() {
		return net;
	}

	public void setNet(String net) {
		this.net = net;
	}

	public String getOemid() {
		return oemid;
	}

	public void setOemid(String oemid) {
		this.oemid = oemid;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPhone_code() {
		return phone_code;
	}

	public void setPhone_code(String phone_code) {
		this.phone_code = phone_code;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
