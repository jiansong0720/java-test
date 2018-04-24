package com.song.service;


import com.song.domain.Movies;
import com.song.repository.MoviesRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/*
 * 声音处理
 *
 * songshu 2017/12/1 17:02
 */
@Service
public class WechatVoiceService {

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
