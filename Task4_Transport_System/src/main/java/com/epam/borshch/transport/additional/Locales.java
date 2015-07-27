package com.epam.borshch.transport.additional;

import java.util.Locale;
import java.util.ResourceBundle;

public class Locales {
	final public static Locale LOC_EN = new Locale("en","US");
	final public static Locale LOC_UA = new Locale("ua","UA");
	public static ResourceBundle bundle_en = ResourceBundle.getBundle("menu", LOC_EN);
	public static ResourceBundle bundle_ua = ResourceBundle.getBundle("menu", LOC_UA);
}
