package com.myr.dao;

import com.myr.model.Movie;

import java.sql.*;

public class MovieEntity {

    private static final String POSTGRES_CONNECTION_URL="jdbc:postgresql://my-postgres:5432/postgres";
    private static final String POSTGRES_USER="postgres";
    private static final String POSTGRES_PASSWORD="mysecretpassword";

    public Movie fetchMovieById(Integer id){
        Connection connection = getConnection();
        Statement statement = createStatement(connection);
        ResultSet resultSet = runQuery(connection,statement, id);
        Movie movie = parseResultSet(resultSet);
        closeJdbcResource(connection,statement,resultSet);
        System.out.println(movie);
        return  movie;
    }

    private void closeJdbcResource(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (resultSet != null)
                resultSet.close();
            if (statement != null)
                statement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
           new RuntimeException(e);

        }
    }

    private Movie parseResultSet(ResultSet resultSet) {
        Movie movie=new Movie();
        try {
            resultSet.next();
            movie.setFilmID(resultSet.getInt("film_id"));
            movie.setTitle(resultSet.getString("title"));
            movie.setDescription(resultSet.getString("description"));
            movie.setReleaseYear(resultSet.getInt("release_year"));
            movie.setRentalDuration(resultSet.getInt("rental_duration"));
            movie.setRentalRate(resultSet.getDouble("rental_rate"));
            movie.setMovieLength(resultSet.getInt("length"));
            movie.setRating(resultSet.getString("rating"));
            movie.setSpecialFeature(resultSet.getString("special_features"));
        } catch (SQLException e) {
            new RuntimeException(e);
        }
        return movie;

    }

    private ResultSet runQuery(Connection connection,Statement statement,Integer id) {
        ResultSet resultSet= null;
        try {
            String sqlString="select * from film where film_id='"+id+"'";
            System.out.println("executing sql query: " +sqlString);
            resultSet = statement.executeQuery(sqlString);
        } catch (SQLException e) {
            System.out.println("error occured while running query : " + e.getMessage());
            closeJdbcResource(connection,statement,null);
            new RuntimeException(e);
        }
        return resultSet;
    }

    private Statement createStatement(Connection connection) {
        Statement statement=null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            closeJdbcResource(connection,null,null);
            System.out.println("error occured while creating statement: " + e.getMessage());
            throw new RuntimeException(e);
        }
        return statement;
    }

    private Connection getConnection(){
        Connection connection=null;
        try {
            Class<?> aClass = Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(POSTGRES_CONNECTION_URL,POSTGRES_USER , POSTGRES_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("error occurred while establishing connection: " + e.getMessage());
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
        return connection;
    }

    public static void main(String[] args) {
        new MovieEntity().fetchMovieById(23);
    }
}


