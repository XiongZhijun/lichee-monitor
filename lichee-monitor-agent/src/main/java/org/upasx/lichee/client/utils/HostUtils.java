package org.upasx.lichee.client.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.upasx.lichee.client.LicheeException;

public class HostUtils {
	private static String hostName;
	private static String hostAddress;

	static {
		InetAddress addr;
		try {
			addr = InetAddress.getLocalHost();
			hostName = addr.getHostName();
			hostAddress = addr.getHostAddress();
		} catch (UnknownHostException e) {
			throw new LicheeException(
					"Get local host name and address failed.", e);
		}
	}

	public static String getHostName() {
		return hostName;
	}

	public static String getHostAddress() {
		return hostAddress;
	}
}
