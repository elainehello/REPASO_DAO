package com.elainevalles.repasodao.persistence;

import com.elainevalles.repasodao.exceptions.PersistenceException;
import com.elainevalles.repasodao.model.Movie;

import java.util.List;

public interface IMovieDAO {
    public void create(Movie movie) throws PersistenceException;
    public Movie read(int id) throws PersistenceException;
    public List<Movie> readAll() throws PersistenceException;
    public void update(Movie movie) throws PersistenceException;
    public Movie delete(int id) throws PersistenceException;
}
