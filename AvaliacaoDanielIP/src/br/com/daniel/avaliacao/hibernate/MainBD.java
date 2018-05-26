package br.com.daniel.avaliacao.hibernate;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class MainBD {
	
	
	
	
	
	public static void main(String[] args) {
		org.apache.log4j.BasicConfigurator.configure();
		Configuration cfg = new AnnotationConfiguration().configure(MainBD.class.getResource("hibernate.cfg.xml"));
		new SchemaExport(cfg).create(true, true);
		
		
	}

}
