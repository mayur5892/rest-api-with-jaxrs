package com.myr.resources;

import com.myr.model.Movie;
import com.myr.service.MovieService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/movie")
public class MovieResource {

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Movie  getFilmById( @PathParam("id") Integer id){
        MovieService movieService=new MovieService();
        final Movie movie = movieService.getMovieById(id);
        return movie;
    }
}
