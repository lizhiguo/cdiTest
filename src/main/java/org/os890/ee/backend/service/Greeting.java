package org.os890.ee.backend.service;

import javax.inject.Inject;

import org.slf4j.Logger;


public class Greeting {
	@Inject
	private Logger logger;
	
	public String hello(){
		
        logger.error("Did it again!");   //error级别的信息，参数就是你输出的信息
        logger.info("我是info信息");    //info级别的信息
        logger.debug("我是debug信息");
        logger.warn("我是warn信息");
		return "hello king";
	}
}
