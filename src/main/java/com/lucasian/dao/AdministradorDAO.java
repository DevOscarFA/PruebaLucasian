package com.lucasian.dao;

import java.util.List;

import com.lucasian.model.Administrador;

/**
 * Interfaz para implementar metodos del modelo de administración
 * 
 * @author Oscar Fernandez Alzate <oscarfdzalz@gmail.com>
 * @version 19/06/2017
 */
public interface AdministradorDAO {

	/**
	 * Crea un registro de administrador por medio de hibernate
	 * 
	 * @param administrador Se envia el objeto de administrador con los valores
	 */
	public abstract void crearAdministrador(Administrador administrador);
	
	/**
	 * Lista todos los administradores creados
	 * 
	 * @return Retorna un listado de los administradores creados
	 */
	public abstract List<Administrador> obtenerTodos();

}