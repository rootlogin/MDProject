/*
 * Copyright (c) 2016.3.$today.day-$today.hour24:3:38
 */

package com.gohon.material.http;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TransportParamsObject implements Serializable {
	
	private TransportParamsHead head;

	public TransportParamsBody getBody() {
		return body;
	}

	public void setBody(TransportParamsBody body) {
		this.body = body;
	}

	private TransportParamsBody body;

	public TransportParamsHead getHead() {
		return head;
	}

	public void setHead(TransportParamsHead head) {
		this.head = head;
	}



	
}
