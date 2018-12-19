package com.itdage.configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.itdage.realm.MyShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置类
 * Created by scy on 2018/11/28.
 */
@Configuration
public class ShiroConfiguration {
//    private final Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);
//
//    @Bean
//    public EhCacheManager getEhCacheManager(){
//        EhCacheManager ehcacheManager = new EhCacheManager();
//        ehcacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
//        return ehcacheManager;
//    }
//
//    // 加上MD5验证
//    @Bean(name = "securityManager")
//    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("authRealm") MyShiroRealm myShiroRealm){
//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        //设置realm
//        securityManager.setRealm(myShiroRealm);
//        //自定义session管理
////        securityManager.setSessionManager(sessionManager());
//        securityManager.setCacheManager(getEhCacheManager());
//        return securityManager;
//    }
//
//    @Bean
//    public SessionManager sessionManager(){
//        return new MySessionManager();
//    }
//
//    @Bean(name = "myShiroRealm")
//    public MyShiroRealm myShiroRealm(){
//        MyShiroRealm realm = new MyShiroRealm();
//        realm.setCachingEnabled(true);
//        realm.setCacheManager(getEhCacheManager());
//        return realm;
//    }
//
//    @Bean(name = "lifecycleBeanPostProcessor")
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
//    @Bean
//    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager){
//        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
//        advisor.setSecurityManager(securityManager);
//        return advisor;
//    }
//
//    @Bean
//    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
//        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
//        creator.setProxyTargetClass(true);
//        return creator;
//    }
//
////    @Bean
////    public SimpleCORSFilter simpleCORSFilter(){
////        return new SimpleCORSFilter();
////    }
//
//    @Bean(name = "shiroFilter")
//    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
//        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
//        factoryBean.setSecurityManager(securityManager);
//        // 自定义filter 加入shiro过滤器链
//        Map<String,Filter> map2 = new HashMap<String, Filter>();
////        map2.put("simpleCORSFilter", simpleCORSFilter());
//        factoryBean.setFilters(map2);
//
//        Map<String,String> map = new HashMap<String, String>();
//        //登出
//        map.put("/logout","logout");
//        //对所有用户认证
//        map.put("/**","authc");
//        //登录  如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
////        factoryBean.setLoginUrl("/user/login");
//        factoryBean.setLoginUrl("/home/index");
//        //首页
//        factoryBean.setSuccessUrl("/index");
//        //错误页面，认证不通过跳转
//        factoryBean.setUnauthorizedUrl("/unauth");
//        factoryBean.setFilterChainDefinitionMap(map);
//        loadShiroFilterChain(factoryBean);
////        logger.info("shiro拦截器工厂类注入成功");
//        return factoryBean;
//    }
//
//    /**
//     * 加载ShiroFilter权限控制规则
//     */
//    private void loadShiroFilterChain(ShiroFilterFactoryBean factoryBean) {
//        /**下面这些规则配置最好配置到配置文件中*/
//        Map<String, String> filterChainMap = new LinkedHashMap<String, String>();
//        /** authc：该过滤器下的页面必须验证后才能访问，它是Shiro内置的一个拦截器
//         * org.apache.shiro.web.filter.authc.FormAuthenticationFilter */
//        // anon：它对应的过滤器里面是空的,什么都没做,可以理解为不拦截
//        //authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
//        filterChainMap.put("/", "anon");
//        filterChainMap.put("/static", "anon");
//        filterChainMap.put("/error", "anon");
//        filterChainMap.put("/user/info","anon");
//        //  filterChainDefinitionManager.put("/user/edit/**", "authc,perms[user:edit]");
////        filterChainMap.put("/user/getAllUser","authc, roles[admin]");
////        filterChainMap.put("/user/getAllUser","anon");
//        filterChainMap.put("/login/logout", "anon");
//        filterChainMap.put("/**", "authc");
//
//        factoryBean.setFilterChainDefinitionMap(filterChainMap);
//    }
//
//    /**
//     * @description 密码校验规。在登陆认证的时候 ,这个类也负责对form里输入的密码进行编码
//     * @author xxx
//     * @date 2018/11/28
//     * @return org.apache.shiro.authc.credential.HashedCredentialsMatcher
//     */
//    @Bean("hashedCredentialsMatcher")
//    public HashedCredentialsMatcher hashedCredentialsMatcher() {
//        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
//        //指定加密方式为MD5
//        credentialsMatcher.setHashAlgorithmName("MD5");
//        //加密次数
//        credentialsMatcher.setHashIterations(1);
//        credentialsMatcher.setStoredCredentialsHexEncoded(true);
//        return credentialsMatcher;
//    }
//    @Bean("authRealm")
//    @DependsOn("lifecycleBeanPostProcessor")//可选
//    public MyShiroRealm authRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher) {
//        MyShiroRealm myRealm = new MyShiroRealm();
//        myRealm.setAuthorizationCachingEnabled(false);
//        myRealm.setCredentialsMatcher(matcher);
//        return myRealm;
//    }
//
//    @Bean
//    public ShiroDialect shiroDialect() {
//        return new ShiroDialect();
//    }
}
