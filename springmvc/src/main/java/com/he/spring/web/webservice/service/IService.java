package com.he.spring.web.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by heyanjing on 2017/12/4 16:45.
 */
@WebService
public interface IService {
    @WebMethod
    Person getPerson(String name);
}
