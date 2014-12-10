package org.upasx.lichee.server.strategy;

/**
 * 
 * @author Andy
 *
 */
public interface IStrategy {
	void process(String itemName, String subItemName, String value, String realValue);
}
