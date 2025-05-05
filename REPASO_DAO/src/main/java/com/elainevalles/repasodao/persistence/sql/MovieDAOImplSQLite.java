package com.elainevalles.repasodao.persistence.sql;

public class MovieDAOImplSQLite extends MovieDAOImplSQL {
    public MovieDAOImplSQLite() {
        dbURL = "jdbc:sqlite:/home/eparra-v/java_repo_april_28th/eclipse_ide/REPASO_DAO/movies.db";
        dbUser = "";
        dbPassword = "";
    }
}
