package com.song.service;


import com.song.domain.Movies;
import com.song.repository.MoviesRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by song on 2017/11/29.
 */
@Service
public class WechatTextService {

    @Resource
    private MoviesRepository moviesRepository;
    /**
     * 处理消息
     */
    public String handleMessage(String content) {
        Movies movies = moviesRepository.getByName(content);
        if(movies!=null){
            return movies.getUrl();
        }
        return "处理文本消息";
    }
}
