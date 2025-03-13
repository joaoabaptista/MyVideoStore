package com.MyVideoStore.models.Repositorys;

import com.MyVideoStore.models.Movie;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//public class MovieRepository {
//
//    @Autowired
//    private EntityManagerFactory entityManagerFactory;
//
//
//    public List<Movie> findAll() {
//        return List.of();
//    }
//}
//

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
