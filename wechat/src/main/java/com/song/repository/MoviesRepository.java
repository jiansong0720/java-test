package com.song.repository;

import com.song.domain.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by song on 2017/11/30.
 */
@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long>, JpaSpecificationExecutor<Movies> {

    Movies getByName(String content);

}
