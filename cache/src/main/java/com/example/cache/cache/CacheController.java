package com.example.cache.cache;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class CacheController {

    @Autowired
    CacheService cacheService;

    @GetMapping(value = {"/get/{id}"})
    public ResponseEntity<DataMetaData> getData(@PathVariable String id ){
        return new ResponseEntity<>(cacheService.getData(id), HttpStatus.OK);
    }
}
