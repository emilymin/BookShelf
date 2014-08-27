package com.thoughtworks.controller;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BookShelfContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {

        //start something
        System.out.println("start ...");
    }

    public void contextDestroyed(ServletContextEvent sce) {

        System.out.println("stop ...");
        //stop something

    }
}
