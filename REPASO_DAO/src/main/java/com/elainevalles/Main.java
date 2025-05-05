package com.elainevalles;

import com.elainevalles.repasodao.exceptions.PersistenceException;
import com.elainevalles.repasodao.model.Movie;
import com.elainevalles.repasodao.persistence.IMovieDAO;
import com.elainevalles.repasodao.persistence.MovieDAOFactory;
import com.elainevalles.repasodao.persistence.hibernate.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        IMovieDAO movieDAO = MovieDAOFactory.getMovieDAO();


//        //find
//        try {
//            Movie peliculaLeida = movieDAO.read(5);
//            System.out.println(peliculaLeida);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // create
//        Movie elconclave = new Movie("Posesion Infernal", "Desconocido");
//        try {
//            movieDAO.create(elconclave);
//            System.out.println(("Registro creado"));
//        } catch (PersistenceException sqle) {
//            System.err.println(sqle.getMessage());
//        }


        // read
        /*
        try {
            Movie peliculaLeida = movieDAO.read(1);
            System.out.println(peliculaLeida);
        } catch (PersistenceException sqle) {
            System.err.println(sqle.getMessage());
        }
        */

//         // Read all
//        try {
//            List<Movie> movies  = movieDAO.readAll();
//            //Opción 1
//            movies.forEach(System.out::println);
//            //Opción 2
//            /*
//            movies.forEach((pelicula)-> {
//                System.out.println(pelicula);
//            });
//            */
//        } catch (PersistenceException sqle) {
//            System.err.println(sqle.getMessage());
//        }

        //Update
//        try {
//            Movie movie = movieDAO.read(5);
//            movie.setDirector(movie.getDirector() + "*");
//            movieDAO.update(movie);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //Delete
//        try {
//            Movie movie = movieDAO.delete(5);
//            movieDAO.update(movie);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }
}