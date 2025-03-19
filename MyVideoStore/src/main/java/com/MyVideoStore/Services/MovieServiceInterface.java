package com.MyVideoStore.Services;

import com.MyVideoStore.models.Movie;

import java.util.List;

public interface MovieServiceInterface {

    List<Movie> getAllMovies();

    Movie get(int id);

    Movie create(Movie movie);

    Movie updatePrice(int id);
}
