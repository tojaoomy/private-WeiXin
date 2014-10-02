/**
 *
 * Copyright (C), 2013-2013, 上海汽车集团股份有限公司
 * FileName : Token.java
 * Author : 何剑
 * Date : 2014年9月21日
 * 
 */
package com.tojaoomy.jupiter.common.entity.authentication;

/**
 * 微信通用接口凭证
 * 
 * @author hejian
 * 
 * @date 2014年9月21日
 */
public class Token {
    // 获取到的凭证
    private String token;
    // 凭证有效时间，单位：秒
    private int expiresIn;
    /**
     *
     *	Get the token
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }
    /**
     *
     *	Set the token
     *
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }
    /**
     *
     *	Get the expiresIn
     *
     * @return the expiresIn
     */
    public int getExpiresIn() {
        return expiresIn;
    }
    /**
     *
     *	Set the expiresIn
     *
     * @param expiresIn the expiresIn to set
     */
    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

}
