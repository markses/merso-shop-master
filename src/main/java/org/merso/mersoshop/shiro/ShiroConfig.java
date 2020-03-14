package org.merso.mersoshop.shiro;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 创建三个bean
 * 1.ShiroFilterFactoryBean
 * 2.DefaultWebSecurityManager
 * 3.Realm
 */

@Configuration
public class ShiroConfig {
    /**
     * 注入安全过滤器
     *
     * @param securityManager
     * @return
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager securityManager) {
        
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //和securityManager关联起来
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //拦截器
        /**
         * 常用的过滤器：
         * anon:无需认证
         * authc：需要认证
         * user：使用rememberMeg功能可以直接访问
         * perms:资源授权可以访问
         * role：角色授权可以访问
         */
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置不会被拦截的链接 顺序判断
        filterChainDefinitionMap.put("/login/**", "anon");
        //前后端带login登录的或者其他登录的通通放行
        filterChainDefinitionMap.put("/**/login/**", "anon");
        filterChainDefinitionMap.put("/**.js", "anon");
        filterChainDefinitionMap.put("/druid/**", "anon");
        filterChainDefinitionMap.put("/swagger**/**", "anon");
        filterChainDefinitionMap.put("/**/swagger**/**", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/v2/**", "anon");
        // 添加自己的过滤器并且取名为jwt
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 注入安全管理器
     *
     * @param myRealm
     */
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(MyRealm myRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;


    }
  @Bean
    public MyRealm getMyRealm(){
        return new MyRealm();
    }
}
