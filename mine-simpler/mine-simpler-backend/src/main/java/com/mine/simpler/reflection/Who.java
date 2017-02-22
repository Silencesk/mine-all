package com.mine.simpler.reflection;

public class Who {
	private String id;
	private String name;
	
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public void setId(String id){
		this.id = id;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public void printStr(){
		System.out.println("id: " + this.id +", name: " + name);
	}
}
