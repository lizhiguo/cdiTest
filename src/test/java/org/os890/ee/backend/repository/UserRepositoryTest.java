package org.os890.ee.backend.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.cdi.Mapper;
import org.os890.ee.backend.mapper.UserMapper;
import org.os890.ee.backend.service.Greeting;
import org.os890.ee.domain.User;
import org.slf4j.Logger;

@RunWith(CdiTestRunner.class)
public class UserRepositoryTest {
	@Inject
	private UserRepository service;
	
	@Inject
	private Greeting greeting;
	
	@Inject
	@Mapper
	private UserMapper userMapper;
	
	@Inject
	private Logger logger;
	
	@Test
	public void getProjectList() throws Exception {
		logger.info("--------------------");
		service.count();
		List<User> us = userMapper.getUserAll();
		System.out.println(us.size());
		greeting.hello();
		logger.info(".....................");
	}
}
