package com.he.spring.cache;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.Collection;

/**
 * Created by heyanjing on 2017/12/11 17:11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-base.xml"})
public class CachexTest {
    private static final Logger log = LoggerFactory.getLogger(CachexTest.class);
    @Autowired
    EhCacheCacheManager cacheManager;
    @Autowired
    Cachex cachex;
    @Autowired
    Ehcache userEhcache;

    @Test
    public void show() {
        Collection<String> cacheNames = cacheManager.getCacheNames();
        cacheNames.forEach(name -> {
            log.info(name);
            Cache cache = cacheManager.getCache(name);
            cache.clear();
        });
    }

    @Test
    public void save1() {
        for (int i = 0; i < 5; i++) {
            cachex.save1(new User("userId" + i, "heyanjing", i, LocalDate.now()));
            Cache cache = cacheManager.getCache("user");
            Cache.ValueWrapper wrapper = cache.get("userId" + i);
            if (wrapper != null) {
                Object o = wrapper.get();
                log.info("{}", o);
            }
        }
    }

    @Test
    public void save2() {
        cachex.save2(new User("userId1", "heyanjing", 28, LocalDate.now()));
        Cache cache = cacheManager.getCache("user");
        Cache.ValueWrapper wrapper = cache.get("save2");
        Object o = wrapper.get();
        log.info("{}", o);

    }

    @Test
    public void remove1() {
        for (int i = 0; i < 5; i++) {
            Cache cache = cacheManager.getCache("user");
            Cache.ValueWrapper wrapper = cache.get("userId" + i);
            if (wrapper != null) {
                Object o = wrapper.get();
                log.info("{}", o);
            }
        }
        cachex.remove1(new User("userId2", "heyanjing", 28, LocalDate.now()));
        for (int i = 0; i < 5; i++) {
            Cache cache = cacheManager.getCache("user");
            Cache.ValueWrapper wrapper = cache.get("userId" + i);
            if (wrapper != null) {
                Object o = wrapper.get();
                log.warn("{}", o);
            }
        }
    }

    @Test
    public void ehcache(){
//        userEhcache.put(new Element("我操","你妹"));
        Element element = userEhcache.get("我操");
        if(element!=null){
            log.info("{}", element.getObjectValue());
        }
    }

}