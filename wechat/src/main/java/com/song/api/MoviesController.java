package com.song.api;

import com.song.common.requset.movies.MoviesAddRequest;
import com.song.common.requset.movies.MoviesListRequest;
import com.song.common.requset.movies.MoviesUpdateRequest;
import com.song.common.response.movies.MoviesListResponse;
import com.song.domain.Movies;
import com.song.service.MoviesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by song1993 on 2017/9/27.
 */
@RestController
@RequestMapping(value = "/message")
@Api(tags = "电影", produces = "application/json")
public class MoviesController {

    @Resource
    private MoviesService moviesService;

    @PostMapping("/movies")
    @ApiOperation("新增电影")
    public void addMovies(@RequestBody MoviesAddRequest bean) {
        moviesService.addMovies(bean);
    }

    @DeleteMapping("/movies/{id}")
    @ApiOperation("删除电影")
    public void deleteMovies(@PathVariable Long id) {
        moviesService.deleteMovies(id);
    }

    @PutMapping("/movies")
    public void updateMovies(@RequestBody MoviesUpdateRequest bean) {
        moviesService.updateMovies(bean);
    }

    @GetMapping("/movies/{id}")
    public Movies getMovies(@PathVariable Long id) {
        return moviesService.getMovies(id);
    }

    @PatchMapping("/movies")
    public Page<MoviesListResponse> getMoviesList(@RequestBody MoviesListRequest bean) {
        return moviesService.getMoviesList(bean);
    }

}
