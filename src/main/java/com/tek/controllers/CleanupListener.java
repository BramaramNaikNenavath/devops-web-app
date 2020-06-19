package com.tek.controllers;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.tek.utils.HibernateUtil;

public class CleanupListener implements ServletContextListener {

	private static Logger log = Logger.getLogger(CleanupListener.class);

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		log.info(">> CleanupListener contextInitialized() >>");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		log.info(">> CleanupListener contextDestroyed() Destroying Hibernate Session Factory Object >>");
		ServletContextListener.super.contextDestroyed(sce);
		HibernateUtil.shutDown();
	}

}
