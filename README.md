# blog 

使用SpringBoot框架整合Redis以及Mybatis开发的博客系统，实现了多用户在线管理博客功能

---

使用技术： <br>
&nbsp;  1.SpringBoot <br> 
&nbsp;  2.Redis <br>
&nbsp;  3.Mybatis <br>

---

用户：

1.获取首页数据：根据排序规则排列数据 <br>
2.登录，注册 <br>
3.个人中心：鼠标移入展示部分个人信息，点击进入个人信息管理 <br>
4.个人中心： <br>
           &nbsp; 1.我的关注根据时间或者关注用户等级排序，可以取消关注 <br>
		 &nbsp; &nbsp;   2.个人信息修改 <br>
		 &nbsp; &nbsp;   3.查看粉丝列表 <br>
		  &nbsp;  &nbsp;   4.账号设置 <br>
		  &nbsp;  &nbsp;   5.我的收藏：可以取消收藏 <br>
		  &nbsp;  &nbsp;   6.我的博客：待开发 <br>
		   &nbsp;  &nbsp;  7.我的文章：对文章的增删改操作 <br>
5.评论文章，点赞文章，收藏文章，关注用户 <br>
6.举报： <br>
      &nbsp;  1.文章举报 <br>
      &nbsp;  2.评论举报 <br>
7.支持站长：扫码付款

	   
---

管理员：

1.文章管理：彻底删除文章，屏蔽文章（屏蔽后通知用户修改文章，修改完成后申请重新发布，管理审核通过后正常发布） <br>
2.用户管理：-1禁止用户登录，0正常，1禁止评论并且该用户所有评论不可见，2禁止发布文章但是以前发布的可以看，3禁止发布文章并且以前的文章也被屏蔽 <br>
3.广告管理：增删广告 <br>
4.文章分类管理：增删操作 <br>
5.举报 <br>
      &nbsp; 1.举报受理 <br>
      &nbsp; 2.举报理由管理 <br>
6.用户权限管理：比如把用户发表评论所需要的等级提升 <br>
7.每日寄语管理 <br>

---
排序规则：

根据热度排序： <br>
热度=评论数量*1+点赞数量*2+浏览次数/2

根据发布时间排序

用户名命名规则： <br>
1.不能有特殊字符 <br>
2.必须英文字母和数字同时存在 <br>  
3.不能低于11位不能对于16位 <br>


密码设计规则： <br>
1.不能和用户名相同 <br>
2.英文字母开头 <br>
3.必须同时存在英文字母，阿拉伯数字，以下特殊字符中的一种：.@#* <br>
4.不能低于16位 <br>
