package org.semana01;

import org.semana01.modelos.ColeccionLibros;
import org.semana01.modelos.Libro;

public class App {
    public static void main(String[] args) {
        ColeccionLibros coleccion = new ColeccionLibros();
        // Cargar los libros desde un archivo
        try {
            java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader("Semana01-ColeccionesYRelaciones/src/main/resources/libros.csv"));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                coleccion.addLibro(new Libro(datos[0], datos[1], datos[2], Integer.parseInt(datos[3])));
            }
            reader.close();
        } catch (java.io.IOException e) {
            System.out.println("Error al cargar el archivo de libros");
            e.printStackTrace();
        }
        coleccion.ordenarLibrosPorTitulo();
        System.out.println("1) Cantidad de libros con más de 500 páginas: " + coleccion.cantidadLibrosMas500Paginas());
        System.out.println("2) Cantidad de libros con menos de 300 páginas: " + coleccion.cantidadLibrosMenos300Paginas());
        System.out.println("3) Títulos de libros con más de 500 páginas: " + coleccion.listarLibrosMas500Paginas());
        System.out.println("4) Títulos de los 3 libros con más páginas: " + coleccion.listarTresLibrosMasPaginas());
        System.out.println("5) Suma de páginas de todos los libros: " + coleccion.sumaTotalPaginas());
        System.out.println("6) Libros que superan el promedio de páginas : " + coleccion.listarLibrosMasPaginasPromedio());
        System.out.println("7) Autores sin repetir : " + coleccion.listarAutores());
        System.out.println("8) Obtener los autores que tengan más de 1 libro listado: " + coleccion.autoresConVariosLibros());
        System.out.println("9) Libro con mas páginas: " + coleccion.libroMasPaginas());
        System.out.println("10)Todos los títulos de los libros: " + coleccion.todosLosLibros());


    }
}