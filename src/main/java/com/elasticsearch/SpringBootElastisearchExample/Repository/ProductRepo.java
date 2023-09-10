package com.elasticsearch.SpringBootElastisearchExample.Repository;

import com.elasticsearch.SpringBootElastisearchExample.Entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductRepo extends ElasticsearchRepository<Product,Integer> {
}
