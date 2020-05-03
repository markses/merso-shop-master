# merso-shop


<p>
 <img src="https://badges.frapsoft.com/os/v1/open-source.png?v=103"></img>
    </a>
    <img src="https://img.shields.io/github/commit-activity/m/markses/Study-notes"></img>
    <a ref="hexo-theme" href="https://github.com/yscoder/hexo-theme-indigo">
        <img src="https://img.shields.io/badge/hexo%20theme-indigo-green"></img>
    </a>
     <img src="https://img.shields.io/github/repo-size/markses/merso-shop-master"></img>
    <img src="https://img.shields.io/badge/github-shop-orange"></img>
    <img src="https://badgen.net/badge/stars/%E2%98%85%E2%98%85%E2%98%85%E2%98%85%E2%98%86"></img>
    <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/4.0/">
        <img alt="知识共享许可协议" style="border-width:0" height="21" src="https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png"/>
    </a>
</p>


## 项目介绍

`merso-shop`项目是一套在线购物网站系统，包括前台商城系统及后台管理系统，采用SpringBoot+Vue前后端分离的方式进行设计与实现。前台商城系统包含首页门户、商品推荐、商品搜索、商品展示、购物车、订单流程、客户服务、帮助中心等模块。后台管理系统包含商品管理、订单管理、用户管理等模块。

### 项目演示

#### 前台商城系统

前端项目`merso-shop-vue`地址：https://gitee.com/merso/merso-shop

项目演示地址：敬请期待......

![前台商城系统功能演示.gif](/Study-notes/blob/master/img/%E5%95%86%E5%9F%8E%E7%B3%BB%E7%BB%9F2.gif)

#### 后台管理系统

前端项目`mershop`地址：地址：https://github.com/markses/merso-shop-master

项目演示地址：敬请期待......

![后台管理系统功能演示.gif](/document/resource/mall-app.gif)

### 后端代码组织结构

``` lua
merso-shop
├── config -- 项目配置类代码
├── controller -- 控制层
├── entiyty -- 实体层
├── service -- 逻辑处理层代码
├── repository -- dao层交互相关代码
├── shiro -- shiro安全框架
└── result -- 封装返回给前端的结果工具类
```

### 前端代码组织结构

``` lua
merso-shop
├── api -- 封装与前端交互的axios请求
├── assets -- 全局通用配置
├── components -- 页面组件
├── images -- 图片资源
├── plugins -- 引入的element插件
├── router -- 负责前台页面路由的跳转
├── store -- VueX的引用
├── views -- 所有前台页面代码
├── App.vue -- 全局窗口
└── main.js -- 全局配置

```

### 技术选型

#### 后端技术

| 技术                 | 说明                | 官网                                                 |
| -------------------- | ------------------- | ---------------------------------------------------- |
| SpringBoot           | 容器+MVC框架        | https://spring.io/projects/spring-boot               |
| shiro                 | 认证和授权框架      |http://shiro.apache.org/                             |
| MyBatis              | ORM框架             | http://www.mybatis.org/mybatis-3/zh/index.html       |
| Redis                | 分布式缓存          | https://redis.io/                                    |
| Mysql                | Mysql数据库         | https://www.mysql.com                                |
| Druid                | 数据库连接池        | https://github.com/alibaba/druid                     |
| JWT                  | JWT登录支持         | https://github.com/jwtk/jjwt                         |
| Lombok               | 简化对象封装工具    | https://github.com/rzwitserloot/lombok               |
               

#### 前端技术

| 技术       | 说明                  | 官网                                   |
| ---------- | --------------------- | -------------------------------------- |
| Vue        | 前端框架              | https://vuejs.org/                     |
| Vue-router | 路由框架              | https://router.vuejs.org/              |
| Vuex       | 全局状态管理框架      | https://vuex.vuejs.org/                |
| Element    | 前端UI框架            | https://element.eleme.io               |
| Axios      | 前端HTTP框架          | https://github.com/axios/axios         |
| v-charts   | 基于Echarts的图表框架 | https://v-charts.js.org/               |


## 许可证

[Apache License 2.0](https://github.com/macrozheng/mall/blob/master/LICENSE)

Copyright (c) 2019-2020 merso
