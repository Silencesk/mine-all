package com.mine.learn.thread;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;

import com.mine.learn.spring.MapAndListTestBean;

public class MapAndListDITestThread extends Thread {
	private BeanFactory factory;
	
	public BeanFactory getFactory() {
		return factory;
	}

	public void setFactory(BeanFactory factory) {
		this.factory = factory;
	}

	@Override
	public void run() {
       super.run();
		try {
			MapAndListTestBean bean = (MapAndListTestBean) factory.getBean("mapAndListTestBean");
			System.out.println("bean is singleton? " + bean);
			Map<String, String> mapValues =  bean.getMapValues();
			List<String> listValues = bean.getListValues();
			for(Map.Entry<String, String> entry : mapValues.entrySet()){
				System.out.println("mapValues: {key: " + entry.getKey() +", value: " + entry.getValue() + "}");
			}
			System.out.print("listValues:" );
			for(String str : listValues){
				System.out.print(" " + str);
			}
		} finally {
		}
    }
	
	
}
