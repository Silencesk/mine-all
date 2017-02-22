package com.mine.core.util;

import java.util.*; 

/** 
* 模糊搜索HashMap 
* @author JFly 
*/ 
public class LikeHashMap<K, V> extends HashMap<K, V> { 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<V> get(String key, boolean like) { 
        List<V> list = null; 
        if (like) { 
            list = new ArrayList<V>(); 
            K[] a = null; 
            Set<K> set = this.keySet(); 
            a = (K[])set.toArray(); 
            Arrays.sort(a, null); 

            for (int i = 0; i < a.length; i++) { 
                if (a[i].toString().indexOf(key) == -1) { 
                    continue; 
                } else { 
                    list.add(this.get(a[i])); 
                } 
            } 
        } 
        return list; 
    } 

    public static void main(String[] args) { 
        LikeHashMap<String, String> mh = new LikeHashMap<String, String>(); 
        for (int i = 0; i < 10000000; i++) { 
            mh.put("A_" + i, "AAAAAA" + i); 
        } 
        long time = System.currentTimeMillis(); 
        System.out.println(mh.get("A", true).size()); 
        System.out.println(System.currentTimeMillis() - time); 
    } 
} 