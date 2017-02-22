package com.mine.learn.generics;

public class GenericMethod {
	
	public static <E> void printArray(E[] arr){
		if(arr!=null && arr.length>0){
			System.out.println(arr[0].getClass().getName() + "类型数组信息开始----");
			for(E element : arr){
				System.out.printf("%s ", element);
			}
			System.out.println();
		}
	}
	
	public static <E> void printArray(E[] arr, Class<?> type){
		if(arr!=null && arr.length>0){
			if(!type.isInstance(arr[0])){
				System.out.println("需要的参数类型["+type.getName()+"]" + "数组元素类型["+arr[0].getClass().getName()+"]不一致----");
				return;
			}
			System.out.println(arr[0].getClass().getName() + "类型数组信息开始----");
			for(E element : arr){
				System.out.printf("%s ", element);
			}
			System.out.println();
		}
	}
	
	public static void main1(String[] args) {
		Integer[] intArr = {1, 2, 3, 4};	//泛型类型不支持基本数据类型，需将其转为包装类型 error:int[] intArr printArray(intArr);
		String[] strArr = {"h", "e", "l", "l", "o"};
		Double[] dbArr = {1.1, 2.2, 3.3};
		
		printArray(intArr);
		printArray(strArr);
		printArray(dbArr);
		
		printArray(intArr, String.class);
		printArray(strArr, Integer.class);
		printArray(dbArr, Double.class);
		
	}

}
