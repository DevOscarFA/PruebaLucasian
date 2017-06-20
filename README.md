# Ejercicio para prueba conocimientos

## Ejercicio para prueba laboral

Version: 19.06.2017

Autor: Oscar Fernandez Alzate <oscarfdzalz@gmail.com>

## Pasos para el despliegue

1. Se descarga la fuente del siguiente link

clone https://github.com/DevOscarFA/PruebaLucasian.git

2. Se ejecutan la siguiente instruccion de maven para descargar las líbrerias

```
mvn install
```

3.  Se creara el archivo de texto y dejar en la raiz de proyecto para cargar los registos de prueba

Archivo: EjercicioLucasian/aechivo-correcto.txt

4. Se colocara el nombre del archivo plano en el código para poder ejecutarlo

Ruta: EjercicioLucasian/src/com/lucasian/Principal.java

Linea: 18

Codigo: String archivoPlano = "archivo-correcto.txt";

5. Se realiza el cargue de la tabla de base de datos oracle 11g

Ruta: EjercicioLucasian/BaseDatos/1-Creacion-Tabla-Secuencia.sql

6. Se configura el acceso a base de datos donde se realizan los siguientes cambios

Ruta: EjercicioLucasian/src/hibernate.cfg.xml

* Configurar conexión del servidor
```
<property name="connection.url">jdbc:oracle:thin:@{IP_DEL_SERVIDOR}:{PUETO_DE_BASE_DATOS}:{SID}</property>
```

* configuración de usuario y contraseña
```
<property name="connection.username">{USUARIO_BASE_DATOS}</property>

<property name="connection.password">{CONTRASEÑA_BASE_DATOS}</property>
```
7. Ejecutar la clase App.java en la siguiente ubicacion para correr el proyecto

Ruta: EjercicioLucasian/src/main/java/com/lucasian/App.java
