package com.mine.simpler.generator;

import com.mine.simpler.generator.GeneratorUtils;

/**
 * model基类。继承该的model可直接调用generatorSimpleMapperXML
 * 在控制台生成mapper的xml
 * Description: 
 * All rights Reserved, Designed By BeLLE
 * Copyright:   Copyright(C) 2014-2015
 * Company:     Wonhigh.
 * author:      wugy
 * Createdate:  2015-3-31上午10:39:59
 */
public class BaseGenerator {

	/**
	 * 通过Model对象所有的属性生成VO查询的mapperxml（工具方法）
	 * 支持String Integer Date自动转换。其它类型请自行修改
	 * 表名默认取自bean名，联表查询请自行修改
	 * @param bean
     * @param selectName 不填默认生成baseSelectListByVo，baseSelectOneModelByVo,
	 * @param bean
	 * @return
	 */
    public static String generatorSimpleMapperXML(Object bean,String selectName) {
    	return GeneratorUtils.generatorSimpleMapperXML(bean, selectName);
    }
    
    
}
