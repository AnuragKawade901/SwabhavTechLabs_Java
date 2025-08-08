package com.aurionpro.StudentPortal.model;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.setAttribute("portalMotto", "Learning is the key to success!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {}
}