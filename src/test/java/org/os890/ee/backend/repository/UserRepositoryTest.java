package org.os890.ee.backend.repository;

import javax.inject.Inject;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.os890.ee.backend.service.Greeting;

@RunWith(CdiTestRunner.class)
public class UserRepositoryTest {
	@Inject
	private UserRepository service;
	
	@Inject
	private Greeting greeting;
	
	@Test
	public void getProjectList() throws Exception {
		service.count();
		greeting.hello();
	}
}
