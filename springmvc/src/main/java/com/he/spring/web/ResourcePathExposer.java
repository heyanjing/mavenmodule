package com.he.spring.web;

import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * Created by heyanjing on 2017/11/30 9:25.
 */
public class ResourcePathExposer implements ServletContextAware {
    private ServletContext servletContext;
    private String resourceRoot;

    public void init() {
        String version = "1.2.1";// 实际应用中，可以在外部属性文件或数据库保存应用发布版本号，在此获取之。此处仅仅提供一个模拟值
        resourceRoot = "/resources-" + version;// 资源逻辑路径带上应用发布版本号
        getServletContext().setAttribute("resourceRoot", getServletContext().getContextPath() + resourceRoot);// 将资源逻辑路径暴露到ServletContext的属性列表中
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public String getResourceRoot() {
        return resourceRoot;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }
}
