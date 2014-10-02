package com.tojaoomy.jupiter.common.entity.response;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;


/** 
 *  文本消息
 *  @author 何剑
 *  @date 2014-09-19 
 */
@XStreamAlias("xml")
public class NewsMessageReponse extends BaseMessageResponse {  
    /** 图文消息个数，限制为10条以内 */
    @XStreamAlias("ArticleCount")
    private int articleCount;
    
    /** 多条图文消息信息，默认第一个item为大图 */
    @XStreamAlias("Articles")
    private List<Article> articles;

    /**
     *
     *	Get the articleCount
     *
     * @return the articleCount
     */
    public int getArticleCount() {
        return articleCount;
    }

    /**
     *
     *	Set the articleCount
     *
     * @param articleCount the articleCount to set
     */
    public void setArticleCount(int articleCount) {
        this.articleCount = articleCount;
    }

    /**
     *
     *	Get the articles
     *
     * @return the articles
     */
    public List<Article> getArticles() {
        return articles;
    }

    /**
     *
     *	Set the articles
     *
     * @param articles the articles to set
     */
    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    
}
