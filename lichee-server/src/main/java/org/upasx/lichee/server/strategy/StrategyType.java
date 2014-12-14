package org.upasx.lichee.server.strategy;

/**
 * 
 * @author Andy
 *
 */
public enum StrategyType {
	MIN_VALUE("min");
	
	private String type;
	
	StrategyType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
}
