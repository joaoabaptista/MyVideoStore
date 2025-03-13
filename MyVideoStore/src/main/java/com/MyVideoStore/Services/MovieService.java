package com.MyVideoStore.Services;

import com.MyVideoStore.models.Movie;
import com.MyVideoStore.models.Repositorys.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//@Service
//public class MovieService {
//
//    @Autowired
//    private final MovieRepository movieRepository;
//
//    public MovieService(MovieRepository movieRepository) {
//        this.movieRepository = movieRepository;
//    }
//
//    public List<Movie> getAllMovies() {
//        return movieRepository.findAll();
//    }
//}

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
