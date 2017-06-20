package com.lucasian.servicio;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
/**
 * La clase ArchivoPlanos permite lealizar la lectura y escritura de archivos planos
 * 
 * @author Oscar Fernandez Alzate <oscarfdzalz@gmail.com>
 * @version 19/06/2017
 */
public class ArchivoPlanos {

	/**
	 * El metodo leerArchivo permite leer un archivo plano desde la raiz y almacenar
	 * en un BufferedReader para ser retornado
	 * 
	 * @param nombreArchivo Nombre del archivo ubicado en la raiz del proyecto
	 * @return BufferedReader Archivo plano cargado
	 */
	public BufferedReader leerArchivo(String nombreArchivo) {
		List listaArchivo = new ArrayList();
		
		BufferedReader archivo = null;
		try {
			File file = new File(nombreArchivo);
			if(file.exists()){
				Reader reader = new FileReader(nombreArchivo);
				archivo = new BufferedReader(reader);
			}else{
				archivo = null;
				System.err.println("El archivo "+nombreArchivo+" no existe o no se encuentra en el directorio base");
			}
		} catch (FileNotFoundException e) {
			System.err.println(e);
		}
		return archivo;
	}
	
	/**
	 * El metodo generarArchivo permite generar un archivo a partir de un elemento Hashtable
	 * 
	 * @param lista 
	 * @param nombreArchivo Nombre del archivo que sera creado en la raiz del proyecto
	 */
	public void generarArchivo(Hashtable lista, String nombreArchivo) {
		String ruta = nombreArchivo;
        File archivo = new File(ruta);
        BufferedWriter bw = null;
        try {
			bw = new BufferedWriter(new FileWriter(archivo));
			Enumeration<String> llaves = lista.keys();
			while (llaves.hasMoreElements()) {
				bw.write(lista.get(llaves.nextElement()).toString()+"\n");
			}
		} catch (IOException e) {
			System.err.println(e);
		}finally {
			try {
				bw.close();
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}
}