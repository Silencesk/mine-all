package com.mine.learn.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

/**
 * Description: lombok测试
 * author:      liutao
 * Createdate:  2016年9月17日上午10:26:21
 */
@ToString
@Log
public class LombokVO {
	@Getter @Setter String id;
	@Getter @Setter String name;
	@Getter @Setter String remarks;
	
	public static void main(String[] args){
		LombokVO v = new LombokVO();
		v.setId("1");
		v.setName("one");
		v.setRemarks("lt");
		
		System.out.println(v.toString());	//LombokVO(id=1, name=one, remarks=lt)
		log.info(">>>>>>info");
	}
}
