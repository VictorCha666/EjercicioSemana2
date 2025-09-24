package org.semana01.modelos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ColeccionLibros {
    // ¿Qué tipo de colección es la más adecuada para almacenar los libros?
    ArrayList<Libro> coleccion;

    public ColeccionLibros() {
        this.coleccion = new ArrayList<>();
    }

    public void addLibro(Libro libro) {
        coleccion.add(libro);
    }

//    public int cantidadLibrosMas500Paginas() {
//        int cont =0;
//        for (int i = 0; i < coleccion.size(); i++) {
//            if (coleccion.get(i).paginas>500)
//                cont++;
//        }
//        return cont;
//    }
    public int cantidadLibrosMas500Paginas() {
        return (int) coleccion.stream().filter(l -> l.paginas>500).count();
    }

//    public int cantidadLibrosMenos300Paginas() {
//        int cont =0;
//        for (int i = 0; i < coleccion.size(); i++) {
//            if (coleccion.get(i).paginas<300)
//                cont++;
//        }
//        return cont;
//    }
    public int cantidadLibrosMenos300Paginas() {
        return (int) coleccion.stream().filter(libro -> libro.paginas<300).count();
    }

//    public String listarLibrosMas500Paginas() {
//        String listado = "";
//        for (int i = 0; i < coleccion.size(); i++) {
//            if (coleccion.get(i).paginas>500)
//                listado += (coleccion.get(i).titulo+ ", ");
//        }
//        return listado;
//    }
    public String listarLibrosMas500Paginas() {
        return coleccion.stream().filter(libro -> libro.paginas>500).map(libro -> libro.titulo).collect(Collectors.joining(", ","","."));
    }

//    public String listarTresLibrosMasPaginas() {
//        if (coleccion.size() < 3) return "";
//
//        Libro top1 = coleccion.getFirst();
//        Libro top2 = coleccion.getFirst();
//        Libro top3 = coleccion.getFirst();
//
//        for (int i = 0; i < coleccion.size(); i++) {
//            if (coleccion.get(i).paginas > top1.paginas) {
//                top3 = top2;
//                top2 = top1;
//                top1 = coleccion.get(i);
//            } else if (coleccion.get(i).paginas > top2.paginas && coleccion.get(i) != top1) {
//                top3 = top2;
//                top2 = coleccion.get(i);
//            } else if (coleccion.get(i).paginas > top3.paginas && coleccion.get(i) != top1 && coleccion.get(i) != top2) {
//                top3 = coleccion.get(i);
//            }
//        }
//
//        return top1.titulo + ", " + top2.titulo + ", " + top3.titulo;
//    }
    public String listarTresLibrosMasPaginas() {
        return coleccion.stream().sorted((l1, l2) -> l2.paginas-l1.paginas).limit(3).map(l -> l.titulo).collect(Collectors.joining(", ","","."));
    }

//    public int sumaTotalPaginas() {
//        int total=0;
//        for (int i = 0; i < coleccion.size(); i++) {
//            total += coleccion.get(i).paginas;
//        }
//        return total;
//    }
    public int sumaTotalPaginas() {
        return coleccion.stream().mapToInt(l -> l.paginas).sum();
    }

//    public String listarLibrosMasPaginasPromedio() {
//        String eu= "";
//        int media = sumaTotalPaginas()/coleccion.size();
//        for (int i = 0; i < coleccion.size(); i++) {
//            if (coleccion.get(i).paginas>media)
//                eu += coleccion.get(i).titulo + ", ";
//        }
//        return eu;
//    }
    public String listarLibrosMasPaginasPromedio() {
        return coleccion.stream().filter(l -> l.paginas>sumaTotalPaginas()/coleccion.size())
                .map(l -> l.titulo).collect(Collectors.joining(", ","","."));
    }

//    public ArrayList<String> evilListarAutores() {
//
//        ArrayList<String> autores = new ArrayList<>();
//        for (int i = 0; i < coleccion.size(); i++) {
//            if (!autores.contains(coleccion.get(i).autor))
//                autores.add(coleccion.get(i).autor);
//        }
//        return autores;
//    }
    private ArrayList<String> evilListarAutores() {
        return coleccion.stream().map(l -> l.autor).distinct().collect(Collectors.toCollection(ArrayList::new));
    }

//    public String listarAutores() {
//        String eu="";
//        ArrayList<String> autores = evilListarAutores();
//        for (int i = 0; i < autores.size(); i++) {
//            eu += autores.get(i) + ", ";
//        }
//        return eu;
//        }
    public String listarAutores() {
        return coleccion.stream().map(l -> l.autor).distinct()
                .collect(Collectors.joining(", ","","."));
    }

//    public String libroMasPaginas() {
//        Libro libro = coleccion.getFirst();
//        for (int i = 1; i < coleccion.size(); i++) {
//            if (coleccion.get(i).paginas>libro.paginas)
//                libro = coleccion.get(i);
//        }
//        return libro.titulo;
//    }
    public String libroMasPaginas() {
        return coleccion.stream().sorted((l1,l2) -> l2.paginas-l1.paginas).limit(1)
                .map(l -> l.titulo).collect(Collectors.joining());
    }

//    public String listarTitulos() {
//        String dcxz="";
//        for (int i = 0; i < coleccion.size(); i++) {
//            dcxz += coleccion.get(i).titulo +", ";
//        }
//        return dcxz;
//    }
    public String listarTitulos() {
        return coleccion.stream().map(l -> l.titulo).collect(Collectors.joining(", ","","."));
    }


public void ordenarLibrosPorTitulo() {
    Collections.sort(coleccion);
}

    public String todosLosLibros() {
         return coleccion.stream().map(l -> l.titulo).collect(Collectors.joining(", ", "","."));
    }

    public String autoresConVariosLibros() {
        return coleccion.stream()                                                  // Pasar a stream
            .collect(Collectors.groupingBy(l -> l.autor, Collectors.counting()))// Crear un mapa con autores como clave y cantidad de libros como valor
            .entrySet().stream()                                              // El mapa pasa a stream
            .filter(e -> e.getValue() > 1)  // Filtrar aquellos autores cuya cantidad de libros (Valor en el mapa) sea mayor a 1
            .map(Map.Entry::getKey)                                          // Se queda solo con el nombre de los autores
            .collect(Collectors.joining(", ", "", ".")); // Los autores se unen con comas y se agrega un punto al final
}


    // Crea los métodos solicitados en el enunciado del ejercicio
}
