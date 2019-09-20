package com.jk.dao;


import com.jk.model.Zwjl;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface JworkRepository extends ElasticsearchCrudRepository<Zwjl,Integer> {
}
