package com.he.spring.web.service;

import com.he.spring.entity.Dog;
import com.he.spring.entity.Person;
import com.he.spring.web.dao.DogDao;
import com.he.spring.web.dao.PersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    private static final Logger log = LoggerFactory.getLogger(PersonService.class);

    @Autowired
    private PersonDao personDao;
    @Autowired
    private DogDao dogDao;

    public Object test() {

////        测试事务
//        this.personDao.save(new Person("测试",1,new Date(),1));
//        if(true){
//            throw new RuntimeException("测试异常");
//        }
//        this.dogDao.save(new Dog("测试",1,new Date()));


//        Person p = this.personDao.getByIdx3("a2b7850d-4177-44cf-9139-04979969f84a");
//        log.warn("{}", p);
//        return  p;

//        Sort sort = new Sort(Sort.Direction.DESC, "age");
//        Pageable pageable = new PageRequest(1, 2, sort);
//        Page<Person> page = this.personDao.findAll(pageable);
//        return  page;

//        final String tname, final String sex, final String degree, final String orgname
//        Sort sort = new Sort(Sort.Direction.DESC, "age");
//        sort = sort.and(new Sort(Sort.Direction.ASC, "birthday"));
//        Pageable pageable = new PageRequest(0, 2, sort);
//        this.personDao.findAll(new Specification<Person>() {
//            @Override
//            public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
//
//                Path<String> namepath = root.get("name");
//                Path<String> sexpath = root.get("sex");
//                Path<String> degreepath = root.get("degree");
//                List<Predicate> list = new ArrayList<Predicate>();
//                if (tname != null && !"".equals(tname)) {
//                    list.add(cb.like(namepath, "%" + tname + "%"));
//                }
//                if (sex != null && !"".equals(sex)) {
//                    list.add(cb.like(sexpath, "%" + sex + "%"));
//                }
//                if (degree != null && !"".equals(degree)) {
//                    list.add(cb.like(degreepath, "%" + degree + "%"));
//                }
//                if (orgname != null && !"".equals(orgname)) {
//                    Path<String> orgnamepath = root.get("org").get("orgname");
//                    list.add(cb.like(orgnamepath, "%" + orgname + "%"));
//                }
//                Predicate[] p = new Predicate[list.size()];
//                return cb.and(list.toArray(p));
//            }
//        }, pageable);
//        return null;

//        Sort sort = new Sort(Sort.Direction.DESC, "age");
//        sort=sort.and(new Sort(Sort.Direction.ASC, "birthday"));
//        Pageable pageable = new PageRequest(0, 2, sort);
//        Page<Person> page = this.personDao.pageByAge(1, pageable);
//        return  page;


        return null;
    }

    /*
    *  person相关
    */
    public Person save(Person person) {
        Person p2 = this.personDao.save(person);

//        person.setName("我操1");
//        Person p1 = personDao.save(person);//保存
//        p1.setName("我操2");
//        Person p2 = personDao.save(p1);//更新

//        Person p1 = this.personDao.get("adc68578-12ab-4e65-b918-0b16fc803606");//获取
//        p1.setName("我操5");
//        Person p2 = this.personDao.save(p1);//更新


        return p2;
    }

    public List<Person> findAll() {
        return this.personDao.findAll();
    }

    public Person getByIdSql(String id) {
        return this.personDao.getByIdSql(id);
    }

    /*
    * T
    * */
    public List<Person> findAllxSql(Integer age) {
        return this.personDao.findAllxSql(age);
    }

    public Page<Person> pageByNamexSql(String name, Integer pageNumber, Integer pageSize) {
        return this.personDao.pageByNamexSql(name, pageNumber, pageSize);
    }

    public List<Person> findAllxHql(Integer age) {
        return this.personDao.findAllxHql(age);
    }

    public List<Person> findAllxHqlName(String name) {
        return this.personDao.findAllxHqlName(name);
    }

    public Page<Person> pageByNamexHql(String name, Integer pageNumber, Integer pageSize) {
        return this.personDao.pageByNamexHql(name, pageNumber, pageSize);
    }

    /*
    * custom
    * */
    public List<Dog> findAllxSqlCustom(Integer age) {
        return this.personDao.findAllxSqlCustom(age);
    }

    public Page<Dog> pageByNamexSqlCustom(String name, Integer pageNumber, Integer pageSize) {
        return this.personDao.pageByNamexSqlCustom(name, pageNumber, pageSize);
    }

    public List<Dog> findAllxHqlCustom(Integer age) {
        return this.personDao.findAllxHqlCustom(age);
    }

    public Page<Dog> pageByNamexHqlCustom(String name, Integer pageNumber, Integer pageSize) {
        return this.personDao.pageByNamexHqlCustom(name, pageNumber, pageSize);
    }

    /*
    * execute
    * */
    public int executeByAgexSql(Integer age) {
        return this.personDao.executeByAgexSql(age);
    }

    public int executeByAgexHql(Integer age) {
        return this.personDao.executeByAgexHql(age);
    }

    /*
    * map
    * */
    public Page<Map<String, Object>> pageByNamexSqlCustomMap(String name, Integer pageNumber, Integer pageSize) {
        return this.personDao.pageByNamexSqlCustomMap(name, pageNumber, pageSize);
    }


    public List<Map<String, Object>> findAllxSqlCustomMap(Integer age) {
        return this.personDao.findAllxSqlCustomMap(age);
    }

}
