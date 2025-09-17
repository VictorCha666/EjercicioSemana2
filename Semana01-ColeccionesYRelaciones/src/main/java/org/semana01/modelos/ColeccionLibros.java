package org.semana01.modelos;

import java.util.ArrayList;
import java.util.Objects;

public class ColeccionLibros {
    // ¿Qué tipo de colección es la más adecuada para almacenar los libros?
    ArrayList<Libro> coleccion;

    public ColeccionLibros() {
        this.coleccion = new ArrayList<>();
    }

    public void addLibro(Libro libro) {
        coleccion.add(libro);
    }

    public int cantidadLibrosMas500Paginas() {
        int cont =0;
        for (int i = 0; i < coleccion.size(); i++) {
            if (coleccion.get(i).paginas>500)
                cont++;
        }
        return cont;
    }

    public int cantidadLibrosMenos300Paginas() {
        int cont =0;
        for (int i = 0; i < coleccion.size(); i++) {
            if (coleccion.get(i).paginas<300)
                cont++;
        }
        return cont;
    }

    public String listarLibrosMas500Paginas() {
        String listado = "";
        for (int i = 0; i < coleccion.size(); i++) {
            if (coleccion.get(i).paginas>500)
                listado += (coleccion.get(i).titulo+ ", ");
        }
        return listado;
    }

    public String listarTresLibrosMasPaginas() {
        if (coleccion.size() < 3) return "";

        Libro top1 = coleccion.getFirst();
        Libro top2 = coleccion.getFirst();
        Libro top3 = coleccion.getFirst();

        for (int i = 0; i < coleccion.size(); i++) {
            if (coleccion.get(i).paginas > top1.paginas) {
                top3 = top2;
                top2 = top1;
                top1 = coleccion.get(i);
            } else if (coleccion.get(i).paginas > top2.paginas && coleccion.get(i) != top1) {
                top3 = top2;
                top2 = coleccion.get(i);
            } else if (coleccion.get(i).paginas > top3.paginas && coleccion.get(i) != top1 && coleccion.get(i) != top2) {
                top3 = coleccion.get(i);
            }
        }

        return top1.titulo + ", " + top2.titulo + ", " + top3.titulo;
    }

    public int sumaTotalPaginas() {
        int total=0;
        for (int i = 0; i < coleccion.size(); i++) {
            total += coleccion.get(i).paginas;
        }
        return total;
    }

    public String listarLibrosMasPaginasPromedio() {
        String eu= "";
        int media = sumaTotalPaginas()/coleccion.size();
        for (int i = 0; i < coleccion.size(); i++) {
            if (coleccion.get(i).paginas>media)
                eu += coleccion.get(i).titulo + ", ";
        }
        return eu;
    }

    public ArrayList<String> evilListarAutores() {

        ArrayList<String> autores = new ArrayList<>();
        for (int i = 0; i < coleccion.size(); i++) {
            if (!autores.contains(coleccion.get(i).autor))
                autores.add(coleccion.get(i).autor);
        }
        return autores;
    }

    public String listarAutores() {
        String eu="";
        ArrayList<String> autores = evilListarAutores();
        for (int i = 0; i < autores.size(); i++) {
            eu += autores.get(i) + ", ";
        }
        return eu;
        }

    public String libroMasPaginas() {
        Libro libro = coleccion.getFirst();
        for (int i = 1; i < coleccion.size(); i++) {
            if (coleccion.get(i).paginas>libro.paginas)
                libro = coleccion.get(i);
        }
        return libro.titulo;
    }

    public String listarTitulos() {
        String dcxz="";
        for (int i = 0; i < coleccion.size(); i++) {
            dcxz += coleccion.get(i).titulo +", ";
        }
        return dcxz;
    }

    public String listarAutoresConMasDeUnLibro() {
        String string="";
        ArrayList<String> autores = evilListarAutores();
        for (int i = 0; i < autores.size(); i++) {
            string += "Autor: " + autores.get(i)+ "; ";
            for (int j = 0; j < coleccion.size(); j++) {
                if (Objects.equals(autores.get(i), coleccion.get(j).autor))
                    string += coleccion.get(j).titulo +", ";
            }
            string += "\n";
        }
        return string;
    }
}


    // Crea los métodos solicitados en el enunciado del ejercicio

