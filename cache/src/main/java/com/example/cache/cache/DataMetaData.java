package com.example.cache.cache;

import lombok.Data;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

//import javax.persistence.Id;


@RedisHash(value = "data")
@Data
public class DataMetaData implements Serializable {


    @Id
    @AccessType(AccessType.Type.PROPERTY)
    private String id;

    private String name;


    public DataMetaData(String id, String name) {
        this.id = id;
        this.name = name;

    }
}
