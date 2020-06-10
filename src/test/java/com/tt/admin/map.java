package com.tt.admin;

import java.util.HashMap;
import java.util.Map;

public class map
{
public static void main(String[] args) 
{
	Map<String, String> map1 = new HashMap<String, String>();
    map1.put("tue", "200");
    map1.put("wed", "200");
    map1.put("mon", "200");
System.out.println("");
System.out.println("");
    Map<String, String> map2 = new HashMap<String, String>();
    map2.put("tue", "400");
    map2.put("wed", "200");
    map2.put("mon", "200");
    
   System.out.println(compareMap(map1,map2));

  
}	public  static boolean compareMap(Map<String, String> map1, Map<String, String> map2)
	{

	    if (map1 == null || map2 == null)
	        return false;

	    for (String ch1 : map1.keySet()) 
	    {
	        if (map1.get(ch1).equalsIgnoreCase(map2.get(ch1)))
	        {
	        	System.out.println(ch1);
	        }
	           

	    }
	    for (String ch2 : map2.keySet()) 
	    {
	        if (!map2.get(ch2).equalsIgnoreCase(map1.get(ch2)))
	            return false;

	    }

	    return true;
}
}
