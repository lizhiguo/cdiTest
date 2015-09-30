/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
*/
package org.os890.ee.backend.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@ApplicationScoped
public class EntityManagerProducer {
	@PersistenceUnit(unitName = "demoPU")
	private EntityManagerFactory entityManagerFactory;

	@Produces
	@Default
	@RequestScoped
	public EntityManager create() {
		return this.entityManagerFactory.createEntityManager();
	}

	public void dispose(@Disposes @Default EntityManager entityManager) {
		if (entityManager.isOpen()) {
			entityManager.close();
		}
	}
	
	@Produces
	public Logger produceLog(InjectionPoint injectionPoint) {
		return LogManager.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
}