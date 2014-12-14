/*
 *  Copyright@2014 GageIn Inc. All rights reserved.
 *  Email : hust.xzj@gmail.com 
 */
package org.upasx.lichee.command;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Xiong Zhijun
 * @date Dec 13, 2014
 *
 */
@Component
public class CommandBuilder {
	@Value("${scripts.home.dir}")
	private String scriptHomeDir;
	@Autowired
	private Environment environment;

	public String buildCommand(String script) {
		String commandExecutor = getCommandExecutor(script);

		StringBuilder cmd = new StringBuilder(commandExecutor);
		cmd.append(" ").append(scriptHomeDir);
		if (!cmd.toString().endsWith("/")) {
			cmd.append("/");
		}
		cmd.append(script);
		return cmd.toString();
	}

	private String getCommandExecutor(String script) {
		int index = script.lastIndexOf(".");
		String commandExecutor = null;
		if (index > 0) {
			String suffix = script.substring(index + 1);
			commandExecutor = environment.getProperty("command.executor."
					+ suffix);
		}
		if (commandExecutor == null) {
			commandExecutor = StringUtils.EMPTY;
		}
		return commandExecutor;
	}
}
