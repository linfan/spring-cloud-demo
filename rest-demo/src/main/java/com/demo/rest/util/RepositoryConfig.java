package com.demo.rest.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.demo.rest.entity.Department;
import com.demo.rest.entity.User;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {
	
	/**
	 * 返回主键ID
	 */
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(User.class);
		config.exposeIdsFor(Department.class);
	}
}
