package org.upasx.lichee.server.strategy;

import org.upasx.lichee.server.util.DataUtil;

/**
 * 
 * @author Andy
 *
 */
public class MinValueStrategy implements IStrategy {

	@Override
	public void process(String itemName, String subItemName, String value,
			String realValue) {
		if (DataUtil.stringToDouble(realValue) < DataUtil.stringToDouble(value)) {
			System.out.println("Alarm");
		} else {
			System.out.println("Normal");
		}
	}
}
