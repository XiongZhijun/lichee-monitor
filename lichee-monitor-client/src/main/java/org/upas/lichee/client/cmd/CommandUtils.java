/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upas.lichee.client.cmd;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.upas.lichee.client.LicheeException;

/**
 * @author Xiong Zhijun
 * @date Nov 20, 2014
 */
public class CommandUtils {

	public static String execute(String cmd) {
		Process process = null;
		InputStream errorInStream = null;
		InputStream processInStream = null;
		ByteArrayOutputStream resultOutStream = null;
		try {
			process = Runtime.getRuntime().exec(cmd);
			resultOutStream = new ByteArrayOutputStream();
			errorInStream = new BufferedInputStream(process.getErrorStream());
			processInStream = new BufferedInputStream(process.getInputStream());
			int num = 0;
			byte[] bs = new byte[1024];
			while ((num = errorInStream.read(bs)) != -1) {
				resultOutStream.write(bs, 0, num);
			}
			while ((num = processInStream.read(bs)) != -1) {
				resultOutStream.write(bs, 0, num);
			}
			return new String(resultOutStream.toByteArray());
		} catch (IOException e) {
			throw new LicheeException(e.getMessage(), e);
		} finally {
			if (process != null)
				process.destroy();
			IOUtils.closeQuietly(errorInStream);
			IOUtils.closeQuietly(processInStream);
			IOUtils.closeQuietly(resultOutStream);

		}
	}
}
