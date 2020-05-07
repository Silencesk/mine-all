package com.mine.learn.pattern.singleton;

public enum PizzaDeliverySystemConfiguration {
    INSTANCE;
    PizzaDeliverySystemConfiguration() {
        // Initialization configuration which involves
        // overriding defaults like delivery strategy
    }
 
    private PizzaDeliveryStrategy deliveryStrategy = PizzaDeliveryStrategy.NORMAL;
 
    public static PizzaDeliverySystemConfiguration getInstance() {
        return INSTANCE;
    }
 
    public PizzaDeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }
}

