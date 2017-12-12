package com.he.spring.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by heyanjing on 2017/12/11 17:11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-base.xml"})
public class CachexTest {
    private static final Logger log = LoggerFactory.getLogger(CachexTest.class);
    @Autowired
    EhCacheCacheManager cacheManager;

    @Test
    public void test() {
        Cache cache = cacheManager.getCache("userCheatCache");
//        cache.put("he1", "何1");

        Cache.ValueWrapper wrapper = cache.get("he1");
        Object o = wrapper.get();
        log.info("{}", o);
    }

}