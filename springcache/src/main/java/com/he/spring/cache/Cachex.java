package com.he.spring.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * Created by heyanjing on 2017/12/11 17:10.
 */
@Component
public class Cachex {


    @Cacheable(value = {"user"}, key = "#user.id",condition = "#user.age%2==0")
    public User save1(User user) {
        return user;
    }
    @Cacheable(value = {"user"}, key = "methodName")//caches[0].name
    public User save2(User user) {
        return user;
    }

    @CacheEvict(value = "user", key = "#user.id")
    public User remove1(User user) {
        return user;
    }
}
