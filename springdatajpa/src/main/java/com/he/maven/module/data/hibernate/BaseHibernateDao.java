package com.he.maven.module.data.hibernate;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.he.maven.module.data.util.Querys;
import com.he.maven.module.utils.Constants;
import com.he.maven.module.utils.Reflections;
import com.he.maven.module.utils.Strings;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * dao的实现类可以继承该类从而使实现类拥有更多的方法
 */
@Transactional
public class BaseHibernateDao<T> {
    private static final Logger log = LoggerFactory.getLogger(BaseHibernateDao.class);

    @PersistenceContext
    protected EntityManager entityManager;

    protected JpaEntityInformation<T, ?> entityInformation;
    // Entity Info
    protected Class<T> entityClass;
    protected String entityName;
    protected String entityIdName;
    // Data Info
    protected DataSource dataSource;
    protected Session session;

    @PostConstruct
    public void init() {
        // Entity Info
        this.entityClass = Reflections.getClassGenricType(this.getClass());
        this.entityInformation = JpaEntityInformationSupport.getEntityInformation(entityClass, entityManager);
        this.entityName = this.entityInformation.getEntityName();
        this.entityIdName = this.entityInformation.getIdAttributeNames().iterator().next();
        // Data Info
        this.session = ((Session) getEntityManager().getDelegate()).getSessionFactory().openSession();
        this.dataSource = getEntityManagerFactoryInfo().getDataSource();

    }

    // ----------------------------------------------------------------
    // -----------------获取其他属性---------------------------------
    // ----------------------------------------------------------------
    protected EntityManager getEntityManager() {
        return this.entityManager;
    }

    protected EntityManagerFactoryInfo getEntityManagerFactoryInfo() {
        return (EntityManagerFactoryInfo) this.entityManager.getEntityManagerFactory();
    }

    protected Session getSession() {
        return this.session;
    }

    // ----------------------------------------------------------------
    // -----------------创建Query ---------------------------------
    // ----------------------------------------------------------------

    private Query createQuery(String sql, Object params, Querys.Type queryType) {
        return Querys.createQuery(getSession(), sql, params, queryType);
    }

    private Query createHqlQuery(String hql, Object params) {
        return this.createQuery(hql, params, Querys.Type.HQL);
    }

    private Query createSqlQuery(String sql, Object params) {
        return this.createQuery(sql, params, Querys.Type.SQL);
    }

    private Map<String, Query> createPageQuery(String sql, Map<String, String> sort, Object params, Querys.Type queryType, Integer pageNumber, Integer pageSize) {
        Map<String, Query> queryMap = Maps.newHashMap();
        String count_hql = "SELECT COUNT(*) " + StringUtils.substring(sql, StringUtils.indexOfIgnoreCase(sql, "from", 0));
        Sort sorts = Querys.createSortFilter(sort);
        if (sorts != null) {
            StringBuffer order_hql = new StringBuffer(" ORDER BY ");
            order_hql.append(Strings.remove(sorts.toString(), ":"));
            sql += order_hql.toString();
        }
        Query count_query = null;
        Query data_query = null;
        if (Querys.Type.SQL.equals(queryType)) {
            count_query = this.createSqlQuery(count_hql, params);
            data_query = this.createSqlQuery(sql, params);
        } else {
            count_query = this.createHqlQuery(count_hql, params);
            data_query = this.createHqlQuery(sql, params);
        }
        // XXX 看前端框架的分页第一页传入的pageNumber是0还是1(假设为1)
        if (pageNumber < 1) {//如果为0，将该参数改为0 ，Constants.PageInfo.PAGE_NUMBER=0
            pageNumber = Constants.PageInfo.PAGE_NUMBER;
        }
        if (pageSize < 1) {
            pageSize = Constants.PageInfo.PAGE_SIZE;
        }
        Integer offset = (pageNumber - 1) * pageSize;
        data_query = data_query.setFirstResult(offset).setMaxResults(pageSize);
        queryMap.put("count_query", count_query);
        queryMap.put("data_query", data_query);
        return queryMap;
    }

    private Map<String, Query> createPageQueryBySql(String sql, Map<String, String> sort, Object params, Integer pageNumber, Integer pageSize) {
        return this.createPageQuery(sql, sort, params, Querys.Type.SQL, pageNumber, pageSize);
    }

    private Map<String, Query> createPageQueryByHql(String sql, Map<String, String> sort, Object params, Integer pageNumber, Integer pageSize) {
        return this.createPageQuery(sql, sort, params, Querys.Type.HQL, pageNumber, pageSize);
    }

    // ----------------------------------------------------------------
    // -----------------execute ---------------------------------
    // ----------------------------------------------------------------

    ///////////////////////// sql////////////////////////////////////
    @Transactional
    public int executeUpdateBySql(String sql) {
        return this.createSqlQuery(sql, null).executeUpdate();
    }

    @Transactional
    public int executeUpdateBySql(String sql, Object... params) {
        return this.createSqlQuery(sql, params).executeUpdate();
    }

    @Transactional
    public int executeUpdateBySql(String sql, Map<String, ?> params) {
        return this.createSqlQuery(sql, params).executeUpdate();
    }

    ///////////////////////// hql////////////////////////////////////
    @Transactional
    public int executeUpdateByHql(String hql) {
        return this.createHqlQuery(hql, null).executeUpdate();
    }

    @Transactional
    public int executeUpdateByHql(String hql, Object... params) {
        return this.createHqlQuery(hql, params).executeUpdate();
    }

    @Transactional
    public int executeUpdateByHql(String hql, Map<String, ?> params) {
        return this.createHqlQuery(hql, params).executeUpdate();
    }

    // ----------------------------------------------------------------
    // -----------------find ---------------------------------
    // ----------------------------------------------------------------

    ///////////////////////// sql////////////////////////////////////
    @SuppressWarnings("unchecked")
    public List<T> findBySql(String sql) {
        return this.createSqlQuery(sql, null).setResultTransformer(Transformers.aliasToBean(this.entityClass)).list();
    }

    public List<T> findBySql(String sql, Object... params) {
        return this.createSqlQuery(sql, params).setResultTransformer(Transformers.aliasToBean(this.entityClass)).list();
    }

    @SuppressWarnings("unchecked")
    public List<T> findBySql(String sql, Map<String, ?> params) {
        return this.createSqlQuery(sql, params).setResultTransformer(Transformers.aliasToBean(this.entityClass)).list();
    }

    ///////////////////////// hql////////////////////////////////////
    @SuppressWarnings("unchecked")
    public List<T> findByHql(String hql) {
        return this.createHqlQuery(hql, null).list();
    }

    @SuppressWarnings("unchecked")
    public List<T> findByHql(String hql, Object... params) {
        return this.createHqlQuery(hql, params).list();
    }

    @SuppressWarnings("unchecked")
    public List<T> findByHql(String hql, Map<String, ?> params) {
        return this.createHqlQuery(hql, params).list();
    }

    // ----------------------------------------------------------------
    // -----------------page ---------------------------------
    // ----------------------------------------------------------------

    ///////////////////////// sql////////////////////////////////////
    @SuppressWarnings("unchecked")
    public Page<T> pageBySql(String sql, Map<String, String> sort, Object params, Integer pageNumber, Integer pageSize) {
        Map<String, Query> queryMap = this.createPageQueryBySql(sql, sort, params, pageNumber, pageSize);
        Query count_query = queryMap.get("count_query");
        Query data_query = queryMap.get("data_query");
        // 看前端框架的分页第一页传入的pageNumber是0还是1(假设为1)
        if (pageNumber < 1) {//如果为0，将该参数改为0 ，Constants.PageInfo.PAGE_NUMBER=0
            pageNumber = Constants.PageInfo.PAGE_NUMBER;
        }
        if (pageSize < 1) {
            pageSize = Constants.PageInfo.PAGE_SIZE;
        }
        Long count = Long.valueOf(count_query.uniqueResult().toString());
        List<T> data = data_query.setResultTransformer(Transformers.aliasToBean(this.entityClass)).list();
        return new PageImpl<T>(data, new PageRequest(pageNumber - 1, pageSize), count);
    }

    public Page<T> pageBySql(String sql, Map<String, ?> params, Integer pageNumber, Integer pageSize) {// 没有排序参数
        return this.pageBySql(sql, null, params, pageNumber, pageSize);
    }

    public Page<T> pageBySql(String sql, Integer pageNumber, Integer pageSize, Object... params) {// 没有排序参数
        return this.pageBySql(sql, null, params, pageNumber, pageSize);
    }

    ///////////////////////// hql////////////////////////////////////
    @SuppressWarnings("unchecked")
    public Page<T> pageByHql(String sql, Map<String, String> sort, Object params, Integer pageNumber, Integer pageSize) {
        Map<String, Query> queryMap = this.createPageQueryByHql(sql, sort, params, pageNumber, pageSize);
        Query count_query = queryMap.get("count_query");
        Query data_query = queryMap.get("data_query");
        // XXX 看前端框架的分页第一页传入的pageNumber是0还是1(假设为1)
        if (pageNumber < 1) {//如果为0，将该参数改为0 ，Constants.PageInfo.PAGE_NUMBER=0
            pageNumber = Constants.PageInfo.PAGE_NUMBER;
        }
        if (pageSize < 1) {
            pageSize = Constants.PageInfo.PAGE_SIZE;
        }
        Long count = Long.valueOf(count_query.uniqueResult().toString());
        List<T> data = data_query.list();
        return new PageImpl<T>(data, new PageRequest(pageNumber - 1, pageSize), count);
    }

    public Page<T> pageByHql(String sql, Map<String, ?> params, Integer pageNumber, Integer pageSize) {// 没有排序参数
        return this.pageByHql(sql, null, params, pageNumber, pageSize);
    }

    public Page<T> pageByHql(String sql, Integer pageNumber, Integer pageSize, Object... params) {// 没有排序参数
        return this.pageByHql(sql, null, params, pageNumber, pageSize);
    }

    // ----------------------------------------------------------------
    // -----------------find by entityClass ---------------------------------
    // ----------------------------------------------------------------

    ///////////////////////// sql////////////////////////////////////
    @SuppressWarnings("unchecked")
    public <E> List<E> findEntityClassBySql(String sql, Class<E> entityClass) {
        return this.createSqlQuery(sql, null).setResultTransformer(Transformers.aliasToBean(entityClass)).list();
    }

    @SuppressWarnings("unchecked")
    public <E> List<E> findEntityClassBySql(String sql, Class<E> entityClass, Object... params) {
        return this.createSqlQuery(sql, params).setResultTransformer(Transformers.aliasToBean(entityClass)).list();
    }

    @SuppressWarnings("unchecked")
    public <E> List<E> findEntityClassBySql(String sql, Class<E> entityClass, Map<String, ?> params) {
        return this.createSqlQuery(sql, params).setResultTransformer(Transformers.aliasToBean(entityClass)).list();
    }


    ///////////////////////// hql////////////////////////////////////
    @SuppressWarnings("unchecked")
    public <E> List<E> findEntityClassByHql(String hql, Class<E> clazz) {
        List list = this.createHqlQuery(hql, null).list();
        return this.copyProp(list, clazz);
    }

    @SuppressWarnings("unchecked")
    public <E> List<E> findEntityClassByHql(String hql, Class<E> clazz, Object... params) {
        List list = this.createHqlQuery(hql, params).list();
        return this.copyProp(list, clazz);
    }

    @SuppressWarnings("unchecked")
    public <E> List<E> findEntityClassByHql(String hql, Class<E> clazz, Map<String, ?> params) {
        List list = this.createHqlQuery(hql, params).list();
        return this.copyProp(list, clazz);
    }

    private <E> List<E> copyProp(List<Object> list, Class<E> clazz) {
        List<E> result = Lists.newArrayList();
        for (Object obj : list) {
            try {
                E e = clazz.newInstance();
                BeanUtils.copyProperties(obj,e);
                result.add(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }
    // ----------------------------------------------------------------
    // -----------------page by entityClass ---------------------------------
    // ----------------------------------------------------------------

    ///////////////////////// sql////////////////////////////////////
    @SuppressWarnings("unchecked")
    public <E> Page<E> pageEntityClassBySql(String sql, Map<String, String> sort, Object params, Class<E> entityClass, Integer pageNumber, Integer pageSize) {
        Map<String, Query> queryMap = this.createPageQueryBySql(sql, sort, params, pageNumber, pageSize);
        Query count_query = queryMap.get("count_query");
        Query data_query = queryMap.get("data_query");
        // XXX 看前端框架的分页第一页传入的pageNumber是0还是1(假设为1)
        if (pageNumber < 1) {//如果为0，将该参数改为0 ，Constants.PageInfo.PAGE_NUMBER=0
            pageNumber = Constants.PageInfo.PAGE_NUMBER;
        }
        if (pageSize < 1) {
            pageSize = Constants.PageInfo.PAGE_SIZE;
        }
        Long count = Long.valueOf(count_query.uniqueResult().toString());

//        Query query = data_query;
//        List<E> data = query.list();

        List<E> data = data_query.setResultTransformer(Transformers.aliasToBean(entityClass)).list();

        // List<E> data1 = data_query.setResultTransformer(new AliasToBeanResultTransformer(entityClass)).list();
        // List<E> data2 = data_query.setResultTransformer(new AliasToBeanResultTransformer(entityClass)).list();
        //
        // Page<E> page1 = new PageImpl<E>(data, new PageRequest(pageNumber, pageSize), count);
        return new PageImpl<E>(data, new PageRequest(pageNumber - 1, pageSize), count);
    }

    public <E> Page<E> pageEntityClassBySql(String sql, Map<String, ?> params, Class<E> entityClass, Integer pageNumber, Integer pageSize) {
        return this.pageEntityClassBySql(sql, null, params, entityClass, pageNumber, pageSize);
    }

    public <E> Page<E> pageEntityClassBySql(String sql, Class<E> entityClass, Integer pageNumber, Integer pageSize, Object... params) {
        return this.pageEntityClassBySql(sql, null, params, entityClass, pageNumber, pageSize);
    }


    ///////////////////////// hql////////////////////////////////////
    @SuppressWarnings("unchecked")
    public <E> Page<E> pageEntityClassByHql(String sql, Map<String, String> sort, Class<E> clazz, Object params, Integer pageNumber, Integer pageSize) {
        Map<String, Query> queryMap = this.createPageQueryByHql(sql, sort, params, pageNumber, pageSize);
        Query count_query = queryMap.get("count_query");
        Query data_query = queryMap.get("data_query");
        // XXX 看前端框架的分页第一页传入的pageNumber是0还是1(假设为1)
        if (pageNumber < 1) {//如果为0，将该参数改为0 ，Constants.PageInfo.PAGE_NUMBER=0
            pageNumber = Constants.PageInfo.PAGE_NUMBER;
        }
        if (pageSize < 1) {
            pageSize = Constants.PageInfo.PAGE_SIZE;
        }
        Long count = Long.valueOf(count_query.uniqueResult().toString());
        List data = data_query.list();
        List<E> list = this.copyProp(data, clazz);
        return new PageImpl<E>(list, new PageRequest(pageNumber - 1, pageSize), count);
    }

    public <E> Page<E> pageEntityClassByHql(String sql, Class<E> clazz, Map<String, ?> params, Integer pageNumber, Integer pageSize) {
        return this.pageEntityClassByHql(sql, null,clazz, params, pageNumber, pageSize);
    }

    public <E> Page<E> pageEntityClassByHql(String sql, Class<E> clazz, Integer pageNumber, Integer pageSize, Object... params) {
        return this.pageEntityClassByHql(sql, null,clazz, params, pageNumber, pageSize);
    }

    // ----------------------------------------------------------------
    // -----------------page by map ---------------------------------
    // ----------------------------------------------------------------
    ///////////////////////// sql////////////////////////////////////
    public Page<Map<String, Object>> pageListMapBySql(String sql, Map<String, String> sort, Object params, Integer pageNumber, Integer pageSize) {
        Map<String, Query> queryMap = this.createPageQueryBySql(sql, sort, params, pageNumber, pageSize);
        Query count_query = queryMap.get("count_query");
        Query data_query = queryMap.get("data_query");
        // XXX 看前端框架的分页第一页传入的pageNumber是0还是1(假设为1)
        if (pageNumber < 1) {//如果为0，将该参数改为0 ，Constants.PageInfo.PAGE_NUMBER=0
            pageNumber = Constants.PageInfo.PAGE_NUMBER;
        }
        if (pageSize < 1) {
            pageSize = Constants.PageInfo.PAGE_SIZE;
        }
        Long count = Long.valueOf(count_query.uniqueResult().toString());
        List<Map<String, Object>> data = data_query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
        return new PageImpl<Map<String, Object>>(data, new PageRequest(pageNumber - 1, pageSize), count);
    }

    // ----------------------------------------------------------------
    // -----------------find by map ---------------------------------
    // ----------------------------------------------------------------
    ///////////////////////// sql////////////////////////////////////
    public Page<Map<String, Object>> pageListMapBySql(String sql, Map<String, ?> params, Integer pageNumber, Integer pageSize) {
        return this.pageListMapBySql(sql, null, params, pageNumber, pageSize);
    }

    public Page<Map<String, Object>> pageListMapBySql(String sql, Integer pageNumber, Integer pageSize, Object... params) {
        return this.pageListMapBySql(sql, null, params, pageNumber, pageSize);
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findListMapBySql(String sql) {
        return this.createSqlQuery(sql, null).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findListMapBySql(String sql, Object... params) {
        return this.createSqlQuery(sql, params).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }

    @SuppressWarnings("unchecked")
    public List<Map<String, Object>> findListMapBySql(String sql, Map<String, ?> params) {
        return this.createSqlQuery(sql, params).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
    }
}
