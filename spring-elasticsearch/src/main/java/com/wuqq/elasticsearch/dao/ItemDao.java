package com.wuqq.elasticsearch.dao;

import com.wuqq.elasticsearch.entry.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Classname ItemDao
 * @Description TODO
 * @Date 2021/5/12 11:03
 * @Created by mh
 */
public interface ItemDao extends ElasticsearchRepository <Item,Long>{

        Item  queryItemById(String id);
}
