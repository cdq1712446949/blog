package com.cdq.blog.controller.user;

import com.cdq.blog.dto.ArticleExecution;
import com.cdq.blog.model.Article;
import com.cdq.blog.model.ArticleType;
import com.cdq.blog.model.User;
import com.cdq.blog.service.ArticleService;
import com.cdq.blog.unit.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Min;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/article", method = {RequestMethod.GET, RequestMethod.POST})
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 获取文章列表
     * 用户获取：
     * 管理员获取：
     * 1.查询内容赋值给keyword
     * 2.查询登陆用的的信息，普通用户设置文章状态为0，管理员不设置
     *
     * @return
     */
    @RequestMapping(value = "/getarticlelist", method = RequestMethod.GET)
    public Map<String, Object> getArticleList(HttpServletRequest request) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, Object> modelMap = new HashMap<>();
        //前端获取参数
        Article article = new Article();
        ArticleType articleType = new ArticleType();
        ArticleType parentArticleType = new ArticleType();
        articleType.setParentArticleType(parentArticleType);
        article.setArticleType(articleType);
        //可以有
        int articleTypeId = HttpServletRequestUtil.getInt(request, "articleTypeId");
        article.getArticleType().setArticleTypeId((short) articleTypeId);
        int parentArticleTypeId = HttpServletRequestUtil.getInt(request, "parentArticleTypeId");
        article.getArticleType().getParentArticleType().setArticleTypeId((short) parentArticleTypeId);
        String keyWord = HttpServletRequestUtil.getString(request, "keyWord");
        article.setArticleKeyWord(keyWord);
        String createTime = HttpServletRequestUtil.getString(request, "createTime");
        try {
            if (createTime != null) {
                article.setArticleCreateTime(simpleDateFormat.parse(createTime));
            }
        } catch (ParseException e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", "时间转换失败");
            return modelMap;
        }
        //必须有
        int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
        int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
        String sortColumn = HttpServletRequestUtil.getString(request, "sortColumn");
        String ad = HttpServletRequestUtil.getString(request, "ad");
        if (pageIndex == -1 || pageSize == -1 || sortColumn == null || ad == null) {
            modelMap.put("success", false);
            modelMap.put("errMsg", "缺少必要的参数");
            return modelMap;
        }
        article.setArticleStatus((byte) 0);
        ArticleExecution articleExecution = articleService.getArticleList(article, pageIndex, pageSize,
                sortColumn, ad);
        if (articleExecution.getState() == 0) {
            modelMap.put("success", true);
            modelMap.put("articleList", articleExecution.getArticleList());
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", articleExecution.getStateInfo());
        }
        return modelMap;
    }

    /**
     * 添加文章记录
     * 校验参数：
     * 2.用户id:session中获取userId
     * 3.至少有一个文章标签
     *
     * @return
     */
    @RequestMapping(value = "/addarticle", method = RequestMethod.GET)
    public Map<String, Object> addArticle() {
        Map<String, Object> modelMap = new HashMap<>();
        return modelMap;
    }

    /**
     * 1.根据articleId获取文章记录
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/getarticlebyid", method = RequestMethod.GET)
    public Map<String, Object> getArticleById(int articleId) {
        Map<String, Object> modelMap = new HashMap<>();
        Article article = new Article();
        article.setArticleId(articleId);
        //获取文章记录以及评论列表
        ArticleExecution articleExecution = articleService.getArticleById(article);
        if (articleExecution.getState() == 0) {
            modelMap.put("success", true);
            modelMap.put("article", articleExecution.getArticle());
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", articleExecution.getStateInfo());
        }
        return modelMap;
    }

    /**
     * * 3.根据userId获取最新的五篇文章
     *
     * @param userId 最小为1
     * @return
     */
    @RequestMapping(value = "/getnewarticlebyuserid", method = RequestMethod.GET)
    public Map<String, Object> getNewArticleByUserId(@Min(1) int userId) {
        Map<String, Object> modelMap = new HashMap<>();
        //TODO 可能后期要改
        Article article = new Article();
        User user = new User();
        user.setUserId(userId);
        article.setUser(user);
        //调用service层获取数据
        ArticleExecution articleExecution = articleService.getNewArticleByUserId(article);
        if (articleExecution.getState() == 0) {
            modelMap.put("success", true);
            modelMap.put("newArticleList", articleExecution.getArticleList());
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", articleExecution.getStateInfo());
        }
        return modelMap;
    }

}
