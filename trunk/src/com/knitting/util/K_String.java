package com.knitting.util;

public class  K_String {
public static String     get_file_name_short(final String s){
	   return s.substring( s.lastIndexOf('/')
			             + 1
			             );
}
}
