package com.elainevalles.repasodao.persistence.file;

import com.elainevalles.repasodao.model.Movie;
import com.elainevalles.repasodao.persistence.IMovieDAO;

import java.util.List;
import java.util.ArrayList;

public class MovieDAOImplFake implements IMovieDAO {
    private List<Movie> movies = new ArrayList<Movie>();
    @Override
    public void create(Movie movie) {
        this.movies.add(movie);
    }

    @Override
    public Movie read(int id) {

        return this.movies.stream().filter(movie -> movie.getId()==id).findFirst().get();
    }

    @Override
    public List<Movie> readAll() {
        return this.movies;
    }

    @Override
    public void update(Movie movie) {
        //TODO - Pendiente
    }

    @Override
    public Movie delete(int id) {
        //TODO - Pendiente
        return null;
    }
}
