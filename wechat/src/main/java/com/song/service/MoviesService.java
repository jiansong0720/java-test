package com.song.service;

import com.song.common.requset.movies.MoviesAddRequest;
import com.song.common.requset.movies.MoviesListRequest;
import com.song.common.requset.movies.MoviesUpdateRequest;
import com.song.common.response.movies.MoviesListResponse;
import com.song.domain.Movies;
import com.song.repository.MoviesRepository;
import com.song.repository.query.MoviesQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by song on 2017/11/30.
 */
@Service
public class MoviesService {

    @Resource
    private MoviesRepository moviesRepository;

    public void addMovies(MoviesAddRequest bean) {
        Movies movies = new Movies();
        BeanUtils.copyProperties(bean, movies);
        moviesRepository.save(movies);
    }

    public void deleteMovies(Long id) {
        moviesRepository.delete(id);
    }

    public void updateMovies(MoviesUpdateRequest bean) {
        Movies movies = new Movies();
        BeanUtils.copyProperties(bean, movies);
        moviesRepository.save(movies);
    }

    public Movies getMovies(Long id) {
        return moviesRepository.findOne(id);
    }

    public Page<MoviesListResponse> getMoviesList(MoviesListRequest bean) {
        Pageable pageable = new PageRequest(bean.getPage(), bean.getPageSize(), Sort.Direction.DESC, "createTime");
        Page<Movies> page = moviesRepository.findAll(MoviesQuery.list(bean), pageable);
//        return MoviesQuery.copy(page.getContent());
        return null;
    }

}
