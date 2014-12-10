package org.upasx.lichee.server.strategy;

/**
 * 
 * @author Andy
 * 
 */
public class StrategyFactory {
	
	public static IStrategy createStrategy(StrategyType strategyType) {
		if (StrategyType.MIN_VALUE.getType().equals(strategyType.getType())) {
			return new MinValueStrategy();
		}
		return new EmptyStrategy();
	};
}
