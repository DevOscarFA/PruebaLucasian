package com.lucasian.dao.hibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import com.lucasian.dao.AdministradorDAO;
import com.lucasian.model.Administrador;
import com.lucasian.dao.HibernateHelper;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.lucasian.servicio.ArchivoPlanos;
import com.lucasian.servicio.ValidarAdministrador;

/**
 * Interfaz para implementar metodos del modelo de administración
 * 
 * @author Oscar Fernandez Alzate <oscarfdzalz@gmail.com>
 * @version 19/06/2017
 */
public class AdministradorDAOImpl implements AdministradorDAO {

	/**
	 * Crea un registro de administrador por medio de hibernate
	 * 
	 * @param administrador Se envia el objeto de administrador con los valores
	 */
	public void crearAdministrador(Administrador administrador) {
		SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
		Session session = factoriaSession.openSession();
		session.beginTransaction();
		session.save(administrador);
		session.getTransaction().commit();
	}

	/**
	 * Lista todos los administradores creados
	 * 
	 * @return Retorna un listado de los administradores creados
	 */
	
	public List<Administrador> obtenerTodos() {
		Session session = null;
		List<Administrador> listaAdministrador = null;
		try {
			SessionFactory factoriaSession=HibernateHelper.getSessionFactory();
			session = factoriaSession.openSession();
			listaAdministrador = session.createQuery(" from Administrador ADMINISTRADOR").list();
		}catch(HibernateException e) {
			System.out.println(e.getMessage());
		}finally {
			session.close();
		}
		return listaAdministrador;
	}
	
}