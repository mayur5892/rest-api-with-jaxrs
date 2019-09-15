package com.myr.service;

import com.myr.dao.MovieEntity;
import com.myr.model.Movie;

public class MovieService {

    public Movie getMovieById(Integer id){
        MovieEntity movieEntity=new MovieEntity();
        Movie movie = movieEntity.fetchMovieById(id);
        return movie;
    }
}
