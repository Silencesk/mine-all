package com.mine.simpler.generator;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;

import com.mine.simpler.generator.XmlConfigUtils;
import com.mine.core.utils.CommonUtil;

/**
 * Description: 通用VO查询代码生成辅助工具类
 * All rights Reserved, Designed By BeLLE
 * Copyright:   Copyright(C) 2014-2015
 * Company:     Wonhigh.
 * author:      wugy
 * Createdate:  2015-3-19下午1:51:12
 */
public class GeneratorUtils {
	
    /**
	 * 通过Model对象所有的属性生成VO查询的mapperxml（工具方法）
	 * 支持String Integer Date自动转换。其它类型请自行修改
	 * 表名默认取自bean名，联表查询请自行修改
	 * @param bean
     * @param selectVoName 不填默认生成baseSelectListByVo，baseSelectOneModelByVo；传值必须包含关键字[SelectOneModelByVo]或[SelectListByVo]
	 * @param bean
	 * @return
	 */
    public static String generatorSimpleMapperXML(Object bean,String selectVoName){
    	String modelName=bean.getClass().getSimpleName();
    	String modelWholeName = bean.getClass().getName();
    	if(StringUtils.isNotEmpty(selectVoName)&&!(selectVoName.contains("SelectOneModelByVo")||selectVoName.contains("SelectListByVo"))){
 			return getBlanks(1)+"!--Bean:"+modelName+"生成代码错误：参数selectVoName传值必须包含关键字[SelectOneModelByVo]或[SelectListByVo]。-->\n ";
 		}
    	
    	String tableName=CommonUtil.convertJaveBeanStrToUnderLine(CommonUtil.changeFirstCharUporLow(modelName.replace("Model", ""), 1));
    	modelName=modelName+"Map";
    	String col_list_name=modelName+"_Column_List";
    	String retmapperxml = "";
    	StringBuffer sbf_resultMap=new StringBuffer();
    	StringBuffer sbf_select=new StringBuffer();
    	StringBuffer sbf_vocondition=new StringBuffer();
    	StringBuffer sbf_fcol_list=new StringBuffer();
    	StringBuffer sbf_insert=new StringBuffer();
    	StringBuffer sbf_insert_cols = new StringBuffer();
    	StringBuffer sbf_insert_content = new StringBuffer();
		StringBuffer sbf_insertSelective = new StringBuffer();
		StringBuffer sbf_insertSelective_cols = new StringBuffer();
    	StringBuffer sbf_insertSelective_content = new StringBuffer();
		StringBuffer sbf_updateSelective = new StringBuffer();
		StringBuffer sbf_updateSelective_content = new StringBuffer();
		StringBuffer sbf_update = new StringBuffer();
		StringBuffer sbf_update_content = new StringBuffer();
		StringBuffer sbf_condition=new StringBuffer();
		StringBuffer  sbf_bscrw = new StringBuffer();
		StringBuffer  sbf_bscrw_select = new StringBuffer();
		StringBuffer  sbf_bscrw_collist = new StringBuffer();	//尺码横排列
		
    	sbf_resultMap.append(getBlanks(1)+"!-- Vo查询的Mapper xml自动生成，请自行调试修改使用。(特别注意resultMap的jdbcType及查询的表名，联表查询请添加表别名前缀)-->\n");
    	sbf_resultMap.append(getBlanks(1)+"<resultMap id=\""+modelName+"\" type=\""+modelWholeName+"\" >\n");
		
    	//初始化sbf
    	sbf_insert.append(getBlanks(1)+"<insert id=\"insert\" parameterType=\"" +modelWholeName+ "\" >\n")
    		.append(getBlanks(2)+"INSERT INTO "+tableName+"(");
    	sbf_insertSelective.append(getBlanks(1)+"<insert id=\"insertSelective\" parameterType=\"" +modelWholeName+ "\" >\n")
			.append(getBlanks(2) + "INSERT INTO "+tableName+"\n"+getBlanks(2)+"<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" >");
    	sbf_updateSelective.append(getBlanks(1)+"<update id=\"updateByPrimaryKeySelective\" parameterType=\"" +modelWholeName+ "\" >\n")
    		.append(getBlanks(2)+"UPDATE " + tableName + "\n"+getBlanks(2)+"<set >");
    	sbf_update.append(getBlanks(1)+"<update id=\"updateByPrimaryKey\" parameterType=\"" +modelWholeName+ "\" >\n")
    		.append(getBlanks(2)+"UPDATE " + tableName +"\n"+getBlanks(2)+"SET ");
    	sbf_bscrw.append(getBlanks(1)+"<!-- 尺码横排-BEGIN-->\n")
    		.append(getBlanks(1)+"<resultMap type=\""+ modelWholeName +"\" id=\""+ modelName +"\" extends=\"BaseResultMap\" >\n")
    		.append(getBlanks(2) + "<result column=\"size_name\" property=\"sizeName\" jdbcType=\"VARCHAR\" />\n")
    		.append(getBlanks(2) + "<result column=\"material_name\" property=\"materialName\" jdbcType=\"VARCHAR\" />\n")
    		.append(getBlanks(1)+"</resultMap>\n");
    	
        Class<?> cls = bean.getClass();
        Field[] fields = cls.getDeclaredFields();
        String jdbcType="",fieldName="",fieldName_ul="",fieldType;
        int flen=fields.length;
        
        StringBuffer curLine = new StringBuffer();
        sbf_bscrw_collist.append(getBlanks(3));
        for (int i=0;i<flen;i++) {
            try {
            	Field field=fields[i];
                fieldName =field.getName();
                fieldName_ul=CommonUtil.convertJaveBeanStrToUnderLine(fieldName);
                fieldType=field.getType().getName();
                //System.out.println(fieldType);
                if("java.util.List".equals(fieldType)){
                	continue;
                }
                jdbcType=XmlConfigUtils.getString(fieldType);
                
                //尺码横排-列组装
                if(!fieldName_ul.equals("bill_no") && !fieldName_ul.equals("material_no") && !fieldName_ul.equals("size_type_no")){
                	String curWord = "max(a."+fieldName_ul+") "+fieldName_ul+", ";
                    if(curLine.length()+curWord.length()>100){
                    	sbf_bscrw_collist.append("\n"+getBlanks(3));
                    	curLine = new StringBuffer();
                    }
                	sbf_bscrw_collist.append(curWord);
                	curLine.append(curWord);
                }
                
                sbf_resultMap.append(getBlanks(2)+"<result column=\""+fieldName_ul+"\" property=\""+fieldName+"\" jdbcType=\""+jdbcType+"\" />\n");
                if(jdbcType.equals("TIMESTAMP")){
                	sbf_vocondition.append(getBlanks(2)+"<if test=\""+fieldName+"1!=null and ''!=" + fieldName +"1\" >\n")
                		.append(getBlanks(3)+"and a."+fieldName_ul+" &gt;= #{"+fieldName+"1}\n")
                		.append(getBlanks(2)+"</if>\n")
                		.append(getBlanks(2)+"<if test=\""+fieldName+"2!=null and ''!=" + fieldName +"2\" >\n")
                		.append(getBlanks(3)+"and a."+fieldName_ul+" &lt; DATE_ADD(DATE_FORMAT(#{"+fieldName+"2}, '%Y-%m-%d'), INTERVAL 1 day)\n")
                		.append(getBlanks(2)+"</if>\n");
                	sbf_condition.append(getBlanks(3)+"<if test=\"params."+fieldName+"1!=null and ''!=params." + fieldName +"1\" >\n")
	            		.append(getBlanks(4)+"and a."+fieldName_ul+" &gt;= #{params."+fieldName+"1}\n")
	            		.append(getBlanks(3)+"</if>\n")
	            		.append(getBlanks(3)+"<if test=\"params."+fieldName+"2!=null and ''!=params." + fieldName +"2\" >\n")
	            		.append(getBlanks(4)+"and a."+fieldName_ul+" &lt; DATE_ADD(DATE_FORMAT(#{params."+fieldName+"2}, '%Y-%m-%d'), INTERVAL 1 day)\n")
	            		.append(getBlanks(3)+"</if>\n");
                	
                }else{
                	sbf_vocondition.append(getBlanks(2)+"<if test=\""+fieldName+"!=null and ''!=" + fieldName +"\" >\n")
                    	.append(getBlanks(3)+"and a."+fieldName_ul+" = #{"+fieldName+"}\n")
                    	.append(getBlanks(2)+"</if>\n");
                    sbf_condition.append(getBlanks(3)+"<if test=\"params."+fieldName+"!=null and ''!=params." + fieldName +"\" >\n")
                    	.append(getBlanks(4)+"and a."+fieldName_ul+" = #{params."+fieldName+"}\n")
                    	.append(getBlanks(3)+"</if>\n");
                }
                
                sbf_fcol_list.append(", a."+fieldName_ul);
                
                if(i==0){
                	sbf_insert_cols.append(fieldName_ul);
                	sbf_insert_content.append("#{" + fieldName +",jdbcType=" + jdbcType +"}");
                	sbf_update_content.append("\n"+getBlanks(3)+""+fieldName_ul + " = #{" + fieldName +",jdbcType=" + jdbcType +"},");
                }else if(i==flen-1){
                	sbf_insert_cols.append(", " + fieldName_ul);
                	sbf_insert_content.append(", #{" + fieldName +",jdbcType=" + jdbcType +"}");
                	sbf_update_content.append("\n"+getBlanks(3)+"" + fieldName_ul + " = #{" + fieldName +",jdbcType=" + jdbcType +"}");
                }else{
                	sbf_insert_cols.append(", " + fieldName);
                	sbf_insert_content.append(", #{" + fieldName +",jdbcType=" + jdbcType +"}");
                	sbf_update_content.append("\n"+getBlanks(3)+"" + fieldName_ul + " = #{" + fieldName +",jdbcType=" + jdbcType +"},");
                }
                sbf_insertSelective_cols.append("\n"+getBlanks(3)+"<if test=\""+ fieldName + " != null\" >")
        			.append("\n"+getBlanks(4)+"" + fieldName_ul + ",\n"+getBlanks(3)+"</if>");
	        	sbf_insertSelective_content.append("\n"+getBlanks(3)+"<if test=\""+ fieldName + " != null\" >")
	    			.append("\n"+getBlanks(4)+"#{" + fieldName +",jdbcType=" + jdbcType + "},\n"+getBlanks(3)+"</if>");
            	sbf_updateSelective_content.append("\n"+getBlanks(3)+"<if test=\""+ fieldName + " != null\" >\n")
            		.append(getBlanks(4)+ fieldName_ul + " = #{" + fieldName + ",jdbcType=" + jdbcType + "},\n")
            		.append(getBlanks(3)+"</if>");
            } catch (Exception e) {
                continue;
            }
        }
        
        /***
         * insert insertSelective updateByPrimaryKeySelective updateByPrimaryKey 处理
         */
        sbf_insert.append(sbf_insert_cols.toString()).append(")\n" + getBlanks(2) + "VALUES(")
        	.append(sbf_insert_content).append(")\n"+getBlanks(1)+"</insert>\n\n");
        sbf_insertSelective.append(sbf_insertSelective_cols.toString())
        	.append("\n"+getBlanks(2)+"</trim>\n"+getBlanks(2)+"<trim prefix=\"VALUES(\" suffix=\")\" suffixOverrides=\",\" >")
        	.append(sbf_insertSelective_content)
        	.append("\n"+getBlanks(2)+"</trim>\n"+getBlanks(1)+"</insert>\n\n");
        sbf_updateSelective.append(sbf_updateSelective_content.toString())
        	.append("\n"+getBlanks(2)+"</set>\n"+getBlanks(2)+"WHERE 1=2")
        	.append("\n"+getBlanks(1)+"</update>\n\n");
        sbf_update.append(sbf_update_content)
        	.append("\n"+getBlanks(2)+"WHERE 1=2")
        	.append("\n"+getBlanks(1)+"</update>\n\n");
        /*System.out.println(sbf_insert);
        System.out.println(sbf_insertSelective);
        System.out.println(sbf_updateSelective);
        System.out.println(sbf_update);*/
        
        sbf_resultMap.append(getBlanks(1) + "</resultMap>\n\n");
        
        sbf_resultMap.append(getBlanks(1)+"<sql id=\""+col_list_name+"\" >\n\n");
        sbf_resultMap.append(getBlanks(2)+sbf_fcol_list.toString().substring(1)+" \n");
        sbf_resultMap.append(getBlanks(1)+"</sql>\n");
        
        selectVoName = selectVoName==null?"baseSelectListByVo":selectVoName;
        //condition
    	sbf_select.append(getBlanks(1)+"<sql id=\"condition\" >\n")
    		.append(getBlanks(2)+"<if test=\"null!=params\" >\n")
    		.append(getBlanks(3)+"<if test=\"null!=params.queryCondition and ''!=params.queryCondition\" >\n")
    		.append(getBlanks(4)+"${params.queryCondition}\n")
    		.append(getBlanks(3)+"</if>\n");
    	sbf_select.append(sbf_condition.toString());
    	sbf_select.append(getBlanks(2)+"</if>\n");
    	sbf_select.append(getBlanks(1)+"</sql>\n\n");
    	//voCondition
    	sbf_select.append(getBlanks(1)+"<sql id=\"voCondition\" >\n");
    	sbf_select.append(sbf_vocondition.toString());
    	sbf_select.append(getBlanks(1)+"</sql>\n\n");
    	//baseSelectListByVo
		sbf_select.append(getBlanks(1)+"<select id=\""+selectVoName+"\" resultMap=\""+modelName+"\" parameterType=\"map\">\n");
		sbf_select.append(getBlanks(2)+"select <include refid=\""+col_list_name+"\" /> from "+tableName+" where 1=1\n");
		sbf_select.append(getBlanks(2)+"<include refid=\"voCondition\" /> \n");
		sbf_select.append(getBlanks(1)+"</select>\n\n");
		//尺码横排-baseSelectListByVo
		sbf_bscrw_collist.delete(sbf_bscrw_collist.length()-2, sbf_bscrw_collist.length()-1);
		sbf_bscrw_select.append(getBlanks(1)+"<select id=\""+selectVoName+"\" resultMap=\""+modelName+"\" parameterType=\"map\">\n");
		sbf_bscrw_select.append(getBlanks(2)+"select a.bill_no, a.material_no, a.size_type_no, max(b.material_name) material_name,\n"+sbf_bscrw_collist+"\n")
				.append(getBlanks(2)+"from "+tableName+" a \n")
				.append(getBlanks(2)+"inner join bas_material b on a.material_no=b.material_no\n")
				.append(getBlanks(2)+"where a.bill_no=#{billNo}\n")
				.append(getBlanks(2)+"group by a.bill_no, a.size_type_no, a.material_no\n");
		sbf_bscrw_select.append(getBlanks(1)+"</select>\n");
        //尺码横排-groupDtlSelectListByVo
		sbf_bscrw_select.append(getBlanks(1)+"<select id=\"groupDtlSelectListByVo\" resultMap=\""+modelName+"\" parameterType=\"map\">\n")
			.append(getBlanks(2)+"select <include refid=\"Base_Column_List\" />\n")
			.append(getBlanks(2)+"from "+tableName+" a\n")
			.append(getBlanks(2)+"where a.bill_no=#{billNo} and a.size_type_no=#{sizeTypeNo} and a.material_no=#{materialNo}\n")
			.append(getBlanks(1)+"</select>\n");
		sbf_bscrw.append(sbf_bscrw_select);
		sbf_bscrw.append(getBlanks(1)+"<!-- 尺码竖排-END-->\n\n");
		
        retmapperxml = sbf_resultMap.toString()+sbf_select.toString() 
        		+ sbf_bscrw.toString()
        		+ sbf_insert.toString() + sbf_insertSelective.toString() 
        		+ sbf_updateSelective.toString() + sbf_update.toString();
        return retmapperxml;
    }
    
    public static String getTabs(int size){
    	String tabStr = "";
    	for(int i=0; i<size; i++){
    		if(i==0){
    			tabStr += "  ";
    		}else{
    			tabStr += "\t";	//\t默认为8个空格
    		}
    	}
    	return tabStr;
    }
    public static String getBlanks(int size){
    	String blankStr = "";
    	for(int i=0; i<size; i++){
    		blankStr += "  ";	//换行空格为2
    	}
    	return blankStr;
    }

    /**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*System.out.println(generatorSimpleMapperXML(new ItgUserRoleModel(),null));
		System.out.println(generatorSimpleMapperXML(new ItgUserRoleModel(),"baseSelectListXXXXXXByVo"));*/
	
	}

}