package com.mine.simpler.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.mine.simpler.generator.BaseGenerator;

public class GeneratorVO extends BaseGenerator{
	private Integer userId;
	private Integer userCode;
	private Integer userName;
	private Integer roleId;
	private Integer roleName;
	private Integer projectId;
	private Integer appId;
	private Integer moduleId;
	private String moduleCode;
	private String moduleName;
	private Integer moduleRight;
	private Integer userRight;
    
	public static void main(String[] args) {
		Object bean = new GeneratorVO();		//TODO 为需要生成xml的model
		//System.out.println(generatorSimpleMapperXML(bean, null));
		//自定义的vo查询
		System.out.println(generatorSimpleMapperXML(bean, null));
	}

}
