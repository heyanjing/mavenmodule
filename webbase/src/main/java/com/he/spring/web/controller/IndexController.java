package com.he.spring.web.controller;

import com.he.spring.bean.User1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Locale;

/**
 * Created by heyanjing on 2017/10/19 16:42.
 */
@Controller
public class IndexController {
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    CookieLocaleResolver localeResolver;
    @Autowired
    private ReloadableResourceBundleMessageSource messageSource;

    @RequestMapping("/")
    public String index(Locale locale) {
        String msg = messageSource.getMessage("welcome", null, locale);
        log.warn(msg);
        return "/index";
    }

    @RequestMapping("/user")
    @ResponseBody
    public Object user(@Valid User1 user, BindingResult result) {
        if (result.hasErrors()) {
            log.error("{}", result.getAllErrors());
            log.error("{}", result.getFieldErrors());
            return result.getAllErrors();
        }
        return user;
    }
//    http://localhost:8080/spring/changelanguage?
//    http://localhost:8080/spring/changelanguage?new_lang=en
    @RequestMapping(value = "/changelanguage")
    public void changeLanguage(String new_lang, HttpServletRequest request, HttpServletResponse response,Locale locale) {
        log.info(locale.getCountry());
        log.info(locale.getDisplayCountry());
        log.info(locale.getLanguage());
        log.info(locale.getDisplayLanguage());
        //region Description 方式二
        new_lang = new_lang == null ? "zh_cn" : new_lang;
        new_lang = new_lang.toLowerCase();
        if (new_lang.equals("zh_cn")) {
            localeResolver.setLocale(request, response, Locale.CHINA);
        }  else {
            localeResolver.setLocale(request, response, Locale.ENGLISH);
        }
        //endregion


        //region Description 方式一
//        String msg = "";
//        new_lang = new_lang == null ? "zh_cn" : new_lang;
//        try {
//            LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
//            if (localeResolver == null) {
//                throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
//            }
//
//            LocaleEditor localeEditor = new LocaleEditor();
//            localeEditor.setAsText(new_lang);
//            localeResolver.setLocale(request, response, (Locale) localeEditor.getValue());
//
//            msg = "Change Language Success!";
//        } catch (Exception ex) {
//            msg = "error";
//            ex.printStackTrace();
//        }
//
//        response.setCharacterEncoding(CharEncoding.UTF_8);
//
//        try {
//            response.getWriter().print(msg);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        //endregion
    }
}
