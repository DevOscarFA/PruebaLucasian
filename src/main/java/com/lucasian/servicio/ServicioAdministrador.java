package com.lucasian.servicio;

import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

import com.lucasian.model.Administrador;

/**
 * La clase ServicioAdministrador permite realizar funciones especificas de modulo administrador
 * 
 * @author Oscar Fernandez Alzate <oscarfdzalz@gmail.com>
 * @version 19/06/2017
 */
public class ServicioAdministrador {
	/**
	 * Lista de administradores cargados en el array
	 */
	private List<Administrador> listaAdministradores;
	
	/**
	 * Lista de error creado por la validacion
	 */
	private Hashtable<String, String> errorArchivo;
	
	/**
	 * El metodo cargarPorArchivoPlano carga el archivo plano que se especifique
	 * y almacena en la variable listaAdministradores, y retorna un true, si se 
	 * presenta un error al cargar el archivo caega la variable errorArchivo 
	 * y retorna false
	 * 
	 * @param nombreArchivoPlano Nombre del archivo plano
	 * @return true para correcto, false po si se presento un error de validacion
	 */
	public boolean cargarPorArchivoPlano(String nombreArchivoPlano) {
		
		ArchivoPlanos archivoPlanos = new ArchivoPlanos();
		ValidarAdministrador validarAdministrador = new ValidarAdministrador();
		
		//Iniciamos las variables
		Administrador administrador = null;
		errorArchivo = new Hashtable<String, String>();
		listaAdministradores = new ArrayList<Administrador>();
		Hashtable<String, String> errorFila;
		
		//Leemos el archivo plano para cargarlo en un bufferReader
		BufferedReader listaAdministrador = archivoPlanos.leerArchivo(nombreArchivoPlano);
		
		if(listaAdministrador != null){
			try {
				String columna = "";
				int i = 0;
				while ((columna = listaAdministrador.readLine())!=null ){
					String[] fila = columna.split(";");
					
					//Realizamos las validaciones correspondientes
					errorFila = new Hashtable<String, String>();
					//codigo
					if(validarAdministrador.validarStringSinCaracteres(fila[0].toString()) == false){
						errorFila.put("CodigoAdministrador", fila[0].toString()+" Formato incorrecto");
					}
					//nombre
					if(validarAdministrador.validarStringSinCaracteres(fila[1].toString()) == false){
						errorFila.put("Nombre", fila[1].toString()+" Formato incorrecto");
					}
					//tipo identificcion
					if(validarAdministrador.ValidarTipoIdentificacion(fila[2].toString()) == false){
						errorFila.put("CodigoIdentificacion", fila[2].toString()+" Formato incorrecto, debe ser NI,CC, PA, RC");
					}
					//numero
					if(validarAdministrador.validarNumeros(fila[3].toString()) == false){
						errorFila.put("Numero", fila[3].toString()+" Formato incorrecto");
					}
					//naturaleza
					if(validarAdministrador.validarNaturaleza(fila[4].toString()) == false){
						errorFila.put("Naturaleza", fila[4].toString()+" Formato incorrecto");
					}
					if(validarAdministrador.validarBoolean(fila[5].toString()) == false){
						errorFila.put("ARP", fila[5].toString()+" Formato incorrecto");
					}
					if(validarAdministrador.validarBoolean(fila[6].toString()) == false){
						errorFila.put("FSP", fila[6].toString()+" Formato incorrecto");
					}
					if(validarAdministrador.validarBoolean(fila[7].toString()) == false){
						errorFila.put("Fusionada", fila[7].toString()+" Formato incorrecto");
					}
					if(validarAdministrador.validarfechaFusion(fila[8].toString()) == false){
						errorFila.put("FechaFusion", fila[8].toString()+" Fecha incorrecta (DDMMYYYY)");
					}
					
					//Verificamos si se produjo error de validacion para cargar la valiable de error
					if(!errorFila.isEmpty()){
						errorArchivo.put("linea"+i, columna.toString()+" "+errorFila.toString());
					}else{
						//Creamos un nuevo registro de administrador con los valores del archivo plano
						administrador = new Administrador();
						administrador.setCodigo(fila[0].toString());
						administrador.setNombre(fila[1].toString());
						administrador.setCod_tp_id(fila[2].toString());
						administrador.setNro_id(fila[3].toString());
						administrador.setNaturaleza(fila[4].toString());
						administrador.setMultiple_arp(this.convertirBooleanos(fila[5]));
						administrador.setFsp(this.convertirBooleanos(fila[6]));
						administrador.setFusionada(this.convertirBooleanos(fila[7]));
						administrador.setFecha_fusion(this.convertirFormatoFecha(fila[8]));
						administrador.setId(i);
						
						listaAdministradores.add(administrador);
					}
					i++;
					
				}
			} catch (IOException e) {
				System.err.println(e);
			}
		} else {
			errorArchivo.put("linea0", "Se produjo un error al cargar el archivo plano.");
		}
		
		//Verificamos si hay errores 
		if(errorArchivo.isEmpty()) {	
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Permite realizar la conversion de registros especificos en el archivo
	 * 
	 * @param cadena Cadena con los valotes X o NULL
	 * @return Retorna 1 para X, 0 para null
	 */
	public int convertirBooleanos(String cadena){
		int resultado = 0;
		if (cadena.equals("X") | cadena.equals("x")) {
	    	resultado = 1;
	    } else if (cadena.equals("NULL")) {
	    	resultado = 0;
	    } else {
	    	resultado = 0;
	    }
		return resultado;
	}
	
	/**
	 * Permite converit el formato de fecha a tipo date
	 * 
	 * @param cadena Formato de fecja
	 * @return objeto tipo date
	 */
	public Date convertirFormatoFecha(String cadena){
		int anio = Integer.parseInt(cadena.substring(4,8));
		int mes = Integer.parseInt(cadena.substring(2,4))-1;
		int dia = Integer.parseInt(cadena.substring(0,2));
		Date fecha = new Date(anio,mes,dia);
		return fecha;
	}

	/**
	 * Creamos getters
	 */
	
	public List<Administrador> getListaAdministradores() {
		return listaAdministradores;
	}

	public Hashtable<String, String> getErrorArchivo() {
		return errorArchivo;
	}

}