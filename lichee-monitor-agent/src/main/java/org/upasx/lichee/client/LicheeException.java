/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.client;

/**
 * @author Xiong Zhijun
 * @date Nov 12, 2014
 */
public class LicheeException extends RuntimeException {

	public LicheeException() {
		super();
	}

	public LicheeException(String message, Throwable cause) {
		super(message, cause);
	}

	public LicheeException(String message) {
		super(message);
	}

	public LicheeException(Throwable cause) {
		super(cause);
	}

	private static final long serialVersionUID = 4126234837796451313L;

}
