package com.he.spring.web.controller;

import com.he.spring.bean.User;
import com.he.spring.bean.User1;
import org.apache.commons.codec.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Locale;

/**
 * Created by heyanjing on 2017/10/19 16:42.
 */
@Controller
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping("/")
    public String index() {
        return "/index";
    }

    @RequestMapping("/user")
    @ResponseBody
    public Object user(@Valid User1 user, BindingResult result) {

        if (result.hasErrors()) {
            log.error("{}", result.getAllErrors());
            log.error("{}", result.getFieldErrors());
            return null;
        }
        return new User();
    }

    @RequestMapping(value = "/changelanguage")
    public void changeLanguage(String new_lang, HttpServletRequest request, HttpServletResponse response) {
        String msg = "";
        new_lang="zh_CN";
        try {
            LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
            if (localeResolver == null) {
                throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
            }

            LocaleEditor localeEditor = new LocaleEditor();
            localeEditor.setAsText(new_lang);
            localeResolver.setLocale(request, response, (Locale) localeEditor.getValue());

            msg = "Change Language Success!";
        } catch (Exception ex) {
            msg = "error";
            ex.printStackTrace();
        }

        response.setCharacterEncoding(CharEncoding.UTF_8);

        try {
            response.getWriter().print(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
