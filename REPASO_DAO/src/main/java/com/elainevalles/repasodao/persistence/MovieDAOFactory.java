package com.elainevalles.repasodao.persistence;

import com.elainevalles.repasodao.persistence.util.PropertiesReader;

public class MovieDAOFactory {
    public static IMovieDAO getMovieDAO() {
        Object persistenceImplObj = null;
        try {
            String tipoPersistencia = PropertiesReader.getProperty("persistence.type");
            Class<?> persistenceImplCls = Class.forName(tipoPersistencia);
            persistenceImplObj = persistenceImplCls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (IMovieDAO)persistenceImplObj;
    }
}
