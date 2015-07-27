package com.epam.borshch.transport.additional;

import java.io.UnsupportedEncodingException;

/**
 * UtfConverter.
 * 
 * + contains method, responsible for encoding output strings to UTF-8.
 *
 * @author Slavko
 *
 */

public class UtfConverter {

	public static String convert(String in){
		try {
			return new String(in.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
