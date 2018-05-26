package br.com.daniel.avaliacao.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
	
	
	public static String formataDataToString(Date data) {
		return dateFormat.format(data);
	}
	
	public static Date formataStringToData(String data) {
		try {
			return dateFormat.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
