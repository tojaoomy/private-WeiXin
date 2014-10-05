package com.tojaoomy.jupiter.service.authorization;

import org.junit.Test;

import com.tojaoomy.jupiter.service.authorization.AuthorizationService.Scope;

public class AuthorizationServiceTest {
	
	@Test
	public void buildAuthorizationLinkTest(){
		System.out.println(AuthorizationService.buildAuthorizationLink("1323","www.baidu.com/oauth",Scope.snsapi_base));
	}
}
