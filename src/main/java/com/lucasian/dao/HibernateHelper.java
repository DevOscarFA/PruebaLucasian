package com.lucasian.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * El metodo HibernateHelper permite llegar directamente al objeto session factory para cargar 
 * la configuración
 * 
 * @param lista 
 * @param nombreArchivo Nombre del archivo que sera creado en la raiz del proyecto
 */
public class HibernateHelper {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
	
	/**
	 * El metodo buildSessionFactory crea una sesion de persistencia de datos 
	 * con la configuracion de hibernate.cfg
	 */
	private static SessionFactory buildSessionFactory() {
	
		try {
			return new Configuration().configure().buildSessionFactory();
		}
		catch (Throwable ex) {
			System.err.println("Error creando una factoria de session." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	/**
	 * El metodo getSessionFactory retorna la sesion creada en el buildSessionFactory
	 * 
	 * @return objeto de sesion para persistencia de datos
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
