package com.tojaoomy.jupiter.web.controller.authrization;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tojaoomy.jupiter.common.entity.authentication.Oauth2Token;
import com.tojaoomy.jupiter.service.authorization.AuthorizationService;

@Controller
public class AuthrizationController {

	@ResponseBody
	@RequestMapping("/oauth")
	public String oauthHandling(@RequestParam(value="code",required=true) String code,HttpServletRequest request){
		if(!"authdeny".equals(code)){
			//获取网页授权
			Oauth2Token oauth2Token = AuthorizationService.getOauth2Token("", "", code);
			//TBD backurl等等
			request.setAttribute("oauth2Token", oauth2Token);
		}
		return "xxx";
	}
}
