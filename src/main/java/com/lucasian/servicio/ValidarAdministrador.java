package com.lucasian.servicio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * La clase ValidarAdministrador realiza las distintas validaciones de administrador
 * 
 * @author Oscar Fernandez Alzate <oscarfdzalz@gmail.com>
 * @version 19/06/2017
 */
public class ValidarAdministrador {
	
	/**
	 * El metodo validarStringSinCaracteres realiza la validación que la cadena sea alfanumerica
	 * sin caracteres especiales
	 * 
	 * @param cadena Cadena de texto
	 * @return true correcto, false para erroneo
	 */
	public boolean validarStringSinCaracteres(String cadena){
		boolean resultado;
		Pattern pat = Pattern.compile("^[a-zA-Z0-9 ]*");
	    Matcher mat = pat.matcher(cadena);
	    if (mat.matches()) {
	    	resultado = true;
	    } else {
	    	resultado = false;
	    }
		return resultado;
	}
	
	/**
	 * Valida que la cadena de texto contenga solo números
	 * 
	 * @param cadena Cadena de texto
	 * @return true correcto, false para erroneo
	 */
	public boolean validarNumeros(String cadena){
		boolean resultado;
		Pattern pat = Pattern.compile("[0-9]+");
	    Matcher mat = pat.matcher(cadena);
	    if (mat.matches()) {
	    	resultado = true;
	    } else {
	    	resultado = false;
	    }
		return resultado;
	}
	
	/**
	 * Valida que el tipo de documento sea NI, CC, PA, RC
	 * 
	 * @param cadena Cadena de texto
	 * @return true correcto, false para erroneo
	 */
	public boolean ValidarTipoIdentificacion(String cadena){
		boolean resultado;
		cadena = cadena.toUpperCase();
	    if (cadena.equals("NI")) {
	    	resultado = true;
	    } else if(cadena.equals("CC")) {
	    	resultado = true;
	    } else if(cadena.equals("PA")) {
	    	resultado = true;
	    } else if(cadena.equals("RC")) {
	    	resultado = true;
	    }else{
	    	resultado = false;
	    }
		return resultado;
	}
	
	/**
	 * Valida que la naturaleza del administrador sea PR, PU, MI
	 * 
	 * @param cadena Cadena de texto
	 * @return true correcto, false para erroneo
	 */
	public boolean validarNaturaleza(String cadena){
		boolean resultado;
		cadena = cadena.toUpperCase();
	    if (cadena.equals("PR")) {
	    	resultado = true;
	    } else if(cadena.equals("PU")) {
	    	resultado = true;
	    } else if(cadena.equals("MI")) {
	    	resultado = true;
	    }else{
	    	resultado = false;
	    }
		return resultado;
	}
	
	/**
	 * Valida que el campo sea x o null
	 * 
	 * @param cadena Cadena de texto
	 * @return true correcto, false para erroneo
	 */
	public boolean validarBoolean(String cadena){
		boolean resultado;
		cadena = cadena.toUpperCase();
	    if (cadena.equals("X") | cadena.equals("NULL")) {
	    	resultado = true;
	    } else {
	    	resultado = false;
	    }
		return resultado;
	}
	
	/**
	 * Valida que la fecha sea de tipo DDMMYYYY
	 * 
	 * @param cadena Cadena de texto
	 * @return true correcto, false para erroneo
	 */
	public boolean validarfechaFusion(String cadena){
		boolean resultado = true;
		Pattern pat = Pattern.compile("[0-9]{8}+");
	    Matcher mat = pat.matcher(cadena);
	    if (mat.matches()) {
	    	resultado = true;
	    } else {
	    	resultado = false;
	    }
		return resultado;
	}
}
