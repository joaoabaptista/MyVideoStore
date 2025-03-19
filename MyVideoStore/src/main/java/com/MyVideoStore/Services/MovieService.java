package com.MyVideoStore.Services;


import com.MyVideoStore.models.Movie;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class MovieService implements MovieServiceInterface {

    private EntityManagerFactory emFactory;

    public void setEmFactory(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }



    @Override
    public List<Movie> getAllMovies() {
        return List.of();
    }

    @Override
    public Movie get(int id) {
        return null;
    }

    @Override
    public Movie create(Movie movie) {
        return null;
    }

    @Override
    public Movie updatePrice(int id) {
        return null;
    }
}
