package com.capella.searchapp.controller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component("sessionService")
public class SessionServiceImp implements SessionService {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;

	public Long getPageViews() {
		return redisTemplate.boundValueOps("pageViews").increment(1l);
	}

}
