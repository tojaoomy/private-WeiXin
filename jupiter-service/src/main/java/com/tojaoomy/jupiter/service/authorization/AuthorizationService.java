package com.tojaoomy.jupiter.service.authorization;

import java.awt.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tojaoomy.jupiter.common.entity.authentication.Oauth2Token;
import com.tojaoomy.jupiter.common.entity.authentication.SNSUserInfo;
import com.tojaoomy.jupiter.common.util.CommonUtil;
import com.tojaoomy.jupiter.common.util.PropertiesUtil;

/**
 * 参考
 * http://mp.weixin.qq.com/wiki/index.php?title=%E7%BD%91%E9%A1%B5%E6%8E%88%E6%9D%83%E8%8E%B7%E5%8F%96%E7%94%A8%E6%88%B7%E5%9F%BA%E6%9C%AC%E4%BF%A1%E6%81%AF
 * 
 * @author hejian
 *
 */
@Service
public class AuthorizationService {
	
	private static Logger logger = LoggerFactory.getLogger(AuthorizationService.class); 

	/** 授权链接url */
	private static String authorization_url = PropertiesUtil.getKey("https.authorize.url");
	private static String access_token_url = PropertiesUtil.getKey("https.access_token.url");
	private static String refresh_token_url = PropertiesUtil.getKey("https.refresh_token.url");
	private static String userinfo_url = PropertiesUtil.getKey("https.userinfo.url");

	/**
	 * 构建授权链接url
	 * @param appId
	 * @param redirect_uri
	 * @param scope @see {@link Scope}
	 * @return
	 */
	public static String buildAuthorizationLink(String appId, String redirect_uri, Scope scope) {
		logger.info("buildAuthorizationLink => appId : {} , redirect_uri : {} , scope : {} ", appId, redirect_uri, scope);
		String result = authorization_url.replace("APPID", appId).replace("REDIRECT_URI", CommonUtil.encodeURL(redirect_uri))
						.replace("SCOPE", scope.name());
		logger.info("buildAuthorizationLink => 返回 ：" + result); 
		return result;
	}
	
	/**
	 * 获取网页授权凭证
	 * @param appId
	 * @param appSecret
	 * @param code
	 * @return
	 */
	public static Oauth2Token getOauth2Token(String appId,String appSecret,String code){
		logger.info("getOauth2Token appId : {} , appSecret : {} , code : {} ", appId, appSecret, code);
		Oauth2Token oauth2Token = null;
		String requestUrl = access_token_url.replace("APPID", appId).replace("SECRET", appSecret).replace("CODE", code);
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		if(null != jsonObject){
			try{
				oauth2Token = new Oauth2Token();
				oauth2Token.setAccessToken(jsonObject.getString("access_token"));
				oauth2Token.setExpiresIn(jsonObject.getInt("expires_in"));
				oauth2Token.setRefreshToken(jsonObject.getString("refresh_token"));
				oauth2Token.setOpenId(jsonObject.getString("openid"));
				oauth2Token.setScope(jsonObject.getString("scope"));
			}catch(Exception e){
				oauth2Token = null;
				int errCode = jsonObject.getInt("errcode");
				String errMsg = jsonObject.getString("errmsg");
				logger.error("获取网页授权凭证失败 errCode : {} , errmsg : {} ", errCode,errMsg);
			}
		}
		logger.info("getOauth2Token => 返回 ：" + com.meidusa.fastjson.JSONObject.toJSONString(oauth2Token)); 
		return oauth2Token;
	}
	
	/**
	 * 刷新网页授权凭证
	 * @param appId
	 * @param appSecret
	 * @param code
	 * @return
	 */
	public static Oauth2Token refreshOauth2Token(String appId,String refreshToken){
		logger.info("refreshOauth2Token appId : {} , refreshToken : {} ", appId, refreshToken);
		Oauth2Token oauth2Token = null;
		String requestUrl = refresh_token_url.replace("APPID", appId).replace("REFRESH_TOKEN", refreshToken);
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		if(null != jsonObject){
			try{
				oauth2Token = new Oauth2Token();
				oauth2Token.setAccessToken(jsonObject.getString("access_token"));
				oauth2Token.setExpiresIn(jsonObject.getInt("expires_in"));
				oauth2Token.setRefreshToken(jsonObject.getString("refresh_token"));
				oauth2Token.setOpenId(jsonObject.getString("openid"));
				oauth2Token.setScope(jsonObject.getString("scope"));
			}catch(Exception e){
				oauth2Token = null;
				int errCode = jsonObject.getInt("errcode");
				String errMsg = jsonObject.getString("errmsg");
				logger.error("刷新网页授权凭证失败 errCode : {} , errmsg : {} ", errCode,errMsg);
			}
		}
		logger.info("refreshOauth2Token => 返回 ：" + com.meidusa.fastjson.JSONObject.toJSONString(oauth2Token)); 
		return oauth2Token;
	}

	/**
	 * 通过网页授权获取用户信息
	 * @param accessToken 授权凭证
	 * @param openId 用户唯一标识
	 * @see SNSUserInfo
	 * @return
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static SNSUserInfo getUserInfo(String accessToken,String openId){
		logger.info("getUserInfo accessToken : {} , openId : {} ", accessToken, openId);
		SNSUserInfo user = null;
		String requestUrl = userinfo_url.replace("OPENID", openId).replace("ACCESS_TOKEN", accessToken);
		JSONObject jsonObject = CommonUtil.httpsRequest(requestUrl, "GET", null);
		if(null != jsonObject){
			try{
				user = new SNSUserInfo();
				user.setOpenId(jsonObject.getString("openid"));
				user.setNickname(jsonObject.getString("nickname"));
				user.setSex(jsonObject.getInt("sex"));
				user.setProvince(jsonObject.getString("province"));
				user.setCity(jsonObject.getString("city"));
				user.setCountry(jsonObject.getString("country"));
				user.setHeadimgurl(jsonObject.getString("headimgurl"));
				user.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class));
			}catch(Exception e){
				user = null;
				int errCode = jsonObject.getInt("errcode");
				String errMsg = jsonObject.getString("errmsg");
				logger.error("网页授权获取用户信息失败 errCode : {} , errmsg : {} ", errCode,errMsg);
			}
		}
		logger.info("getUserInfo => 返回  : " + com.meidusa.fastjson.JSONObject.toJSONString(user));
		return user;		
	}
	/**
	 * 应用授权作用域，snsapi_base （不弹出授权页面，直接跳转，只能获取用户openid），snsapi_userinfo
	 * （弹出授权页面，可通过openid拿到昵称、性别、所在地。并且，即使在未关注的情况下，只要用户授权，也能获取其信息）
	 * */
	static enum Scope {
		snsapi_base, snsapi_userinfo;
	}
}
