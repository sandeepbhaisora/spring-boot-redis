package com.example.cache.cache;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Map;

@Service
public class CacheService {

    @Autowired
    CacheRepository cacheRepository;

    // Existing caching with only spring
//    private Map<String,String> map;
//
//    @CachePut
//    public Map<String,String> putData(String id1,String id2){
//        map = Map.of(id1,id2);
//        return map;
//    }
//
//    @Cacheable
//    public String getData(String id1){
//        return map.get(id1);
//    }


//    @Caching(evict = { @CacheEvict(value = "dataList", allEntries = true), }, put = {
//            @CachePut(value = "data", key = "#data.getId()") })
    public DataMetaData saveData(DataMetaData metaData) {
        return cacheRepository.save(metaData);
    }

    @Cacheable(value = "data")
    public DataMetaData getData(String id1){
        System.out.println("calllllinnggggggg_____________________");
        return cacheRepository.findById(id1).orElseThrow();
    }

    @CacheEvict(value = "data")
    public void deleteData(String id) {
        cacheRepository.deleteById(id);
    }
}
