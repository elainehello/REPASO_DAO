package com.elainevalles.repasodao.persistence.hibernate;

import com.elainevalles.repasodao.exceptions.PersistenceException;
import com.elainevalles.repasodao.model.Movie;
import com.elainevalles.repasodao.persistence.IMovieDAO;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;

import java.util.List;

public class MovieDAOImplHibernate implements IMovieDAO {
    @Override
    public void create(Movie movie) throws PersistenceException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(movie);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Movie read(int id) throws PersistenceException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Movie movie = session.get(Movie.class, id);
        session.close();
        return movie;
    }

    @Override
    public List<Movie> readAll() throws PersistenceException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        TypedQuery<Movie> query = session.createQuery("FROM Movie", Movie.class);
        List<Movie> movies = query.getResultList();
        session.close();
        return movies;
    }

    @Override
    public void update(Movie movie) throws PersistenceException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(movie);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Movie delete(int id) throws PersistenceException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Movie movie = session.get(Movie.class, id);
        session.remove(movie);
        session.getTransaction().commit();
        session.close();
        return movie;
    }
}
