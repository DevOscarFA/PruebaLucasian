package com.lucasian;

import java.util.List;

import com.lucasian.dao.hibernate.AdministradorDAOImpl;
import com.lucasian.model.Administrador;
import com.lucasian.servicio.ArchivoPlanos;
import com.lucasian.servicio.ServicioAdministrador;

/**
 * @author Oscar Fernandez Alzate <oscarfdzalz@gmail.com>
 * @version 19/06/2017
 */
public class App {

	public static void main(String[] args) {
		//Nombre del archivo a cargar
		String archivoPlano = "archivo-correcto.txt";
		
		/* Cargamos el archivo plano desde servicios de administrados, en donde nos retorna lo siguiente
		 * true: El archivo se cargo correctamente
		 * flase: Se presento un error de validación
		 */
		ServicioAdministrador servicioAdministrador = new ServicioAdministrador();
		boolean crearPorArchivoPlano = servicioAdministrador.cargarPorArchivoPlano(archivoPlano);
		
		//Verificamos la respuesta
		if(crearPorArchivoPlano == true) {

			AdministradorDAOImpl administradorDAOImpl = new AdministradorDAOImpl();
			
			//Si se realizo la carga nos retorna variable de lista de administradores de los registros
			List<Administrador> listaAdministradores = servicioAdministrador.getListaAdministradores();
			
			//Realizamos el guardado por medio de la implementación del modelo de administrador
			for (int i = 0; i < listaAdministradores.size(); i++) {
				administradorDAOImpl.crearAdministrador(listaAdministradores.get(i));
			}
			System.out.println("Se almaceno la informacion correctamente");
		} else {
			
			//Si se presenta error al validar retorna un Hashtable con los errores
			ArchivoPlanos archivoPlanos = new ArchivoPlanos();
			//Creamos un archivo plano con la informacion para el usuario
			archivoPlanos.generarArchivo(servicioAdministrador.getErrorArchivo(),"log-"+archivoPlano);
			System.err.println("Error al cargar el archivo, se genero un log de los errores");
		}
	}  
}