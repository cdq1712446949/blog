package com.cdq.blog.model;

public class ThumbsCollection {

//    public static final int TRUE=1; //是
//    public static final int FALSE=0; //否

    //用户id
    private int userId;
    //文章id
    private int articleId;
    //点赞记录id
    private int thumbsUpId;
    //收藏记录id
    private int collectionId;
    //是否点赞了该文章
    private int isThumbsUp;
    //是否收藏了该文章
    private int isCollection;

    public int getThumbsUpId() {
        return thumbsUpId;
    }

    public void setThumbsUpId(int thumbsUpId) {
        this.thumbsUpId = thumbsUpId;
    }

    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getIsThumbsUp() {
        return isThumbsUp;
    }

    public void setIsThumbsUp(int isThumbsUp) {
        this.isThumbsUp = isThumbsUp;
    }

    public int getIsCollection() {
        return isCollection;
    }

    public void setIsCollection(int isCollection) {
        this.isCollection = isCollection;
    }
}
