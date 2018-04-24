package com.song.repository.query;

import com.song.common.requset.movies.MoviesListRequest;
import com.song.domain.Movies;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by song on 2017/11/30.
 */
public class MoviesQuery {

    /**
     * 动态生成where语句
     */
    public static Specification<Movies> list(final MoviesListRequest bean) {
        return (root, query, builder) -> {
            List<Predicate> list = new ArrayList<Predicate>();
            if (!ObjectUtils.isEmpty(bean.getName())) {
                list.add(builder.equal(root.get("name"), bean.getName()));
            }
            if (!ObjectUtils.isEmpty(bean.getTime())) {
                list.add(builder.equal(root.get("createTime"), bean.getTime()));
            }
            Predicate[] predicate = new Predicate[list.size()];
            return query.where(list.toArray(predicate)).getRestriction();
        };
    }

}
