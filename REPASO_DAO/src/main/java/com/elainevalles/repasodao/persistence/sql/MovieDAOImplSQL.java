package com.elainevalles.repasodao.persistence.sql;

import com.elainevalles.repasodao.exceptions.PersistenceException;
import com.elainevalles.repasodao.model.Movie;
import com.elainevalles.repasodao.persistence.IMovieDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAOImplSQL implements IMovieDAO {
    protected static String dbURL = "";
    protected static String dbUser = "";
    protected static String dbPassword = "";

    @Override
    public void create(Movie movie) throws PersistenceException {
        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
            String sql = "INSERT INTO movie(title, director) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getDirector());
            pstmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new PersistenceException(sqle.getMessage());
        }
    }

    @Override
    public Movie read(int id) throws PersistenceException {
        Movie movie = null;
        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
            String sql = "SELECT * FROM movie WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                movie = new Movie(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("director")
                );
            }
        } catch (SQLException sqle) {
            throw new PersistenceException(sqle.getMessage());
        }
        return movie;
    }

    @Override
    public List<Movie> readAll() throws PersistenceException {
        List<Movie> movies = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(dbURL,dbUser,dbPassword)) {
            String sql = "SELECT * FROM movie";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Movie movie = new Movie(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("director")
                );
                movies.add(movie);
            }
        } catch (SQLException sqle) {
            throw new PersistenceException(sqle.getMessage());
        }
        return movies;
    }

    @Override
    public void update(Movie movie) throws PersistenceException {
        try (Connection conn = DriverManager.getConnection(dbURL,dbUser,dbPassword)) {
            String sql = "UPDATE movie SET title = ?, director = ? WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, movie.getTitle());
            pstmt.setString(2, movie.getDirector());
            pstmt.setInt(3, movie.getId());
            pstmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new PersistenceException(sqle.getMessage());
        }
    }

    @Override
    public Movie delete(int id) throws PersistenceException{
        try (Connection conn = DriverManager.getConnection(dbURL, dbUser, dbPassword)) {
            String sql = "DELETE FROM movie WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException sqle) {
            throw new PersistenceException(sqle.getMessage());
        }
        return null;
    }
}
