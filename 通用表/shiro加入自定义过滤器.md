##SpringBoot下Shiro添加过滤器
1. 自定义filter继承AdviceFilter
	<pre><code>
	package com.itdage.filter;
	import org.apache.shiro.web.filter.AccessControlFilter;
	import org.apache.shiro.web.filter.authz.AuthorizationFilter;
	import org.apache.shiro.web.servlet.AdviceFilter;
	import org.springframework.stereotype.Component;
	import javax.servlet.ServletRequest;
	import javax.servlet.ServletResponse;
	import javax.servlet.http.HttpServletResponse;

	/**
 	* @ClassName SimpleCORSFilter
 	* @Description
 	* @Author huayu
 	* @Date 2018/12/2 17:18
 	* @Version 1.0
 	**/
	@Component
	public class SimpleCORSFilter extends AdviceFilter {
    	@Override
    	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
	        HttpServletResponse res = (HttpServletResponse) response;
    	    res.setHeader("Access-Control-Allow-Origin", "*");
    	    res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    	    res.setHeader("Access-Control-Max-Age", "3600");
    	    res.setHeader("Access-Control-Allow-Headers", "Content-Type,XFILENAME,XFILECATEGORY,XFILESIZE");
        	return true;
    	}
	}
	</code></pre>

2. ShiroFilterFactoryBean中追加自己定义的过滤器
	<pre><code>
	package com.itdage.configuration;
	import com.itdage.filter.SimpleCORSFilter;
	import com.itdage.realm.MyShiroRealm;
	import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
	import org.apache.shiro.cache.ehcache.EhCacheManager;
	import org.apache.shiro.spring.LifecycleBeanPostProcessor;
	import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
	import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
	import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
	import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
	import org.springframework.beans.factory.annotation.Qualifier;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.context.annotation.DependsOn;
	import javax.servlet.Filter;
	import java.util.HashMap;
	import java.util.LinkedHashMap;
	import java.util.Map;
 	//shiro配置类
	@Configuration
	public class ShiroConfiguration {
	//    private final Logger logger = Logger.getLogger(ShiroConfiguration.class);
    // 加上MD5验证
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("authRealm") MyShiroRealm myShiroRealm){
        	DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        	//设置realm
        	securityManager.setRealm(myShiroRealm);
        	securityManager.setCacheManager(getEhCacheManager());
        	return securityManager;
    	}
    @Bean(name = "myShiroRealm")
    	public MyShiroRealm myShiroRealm(EhCacheManager ehCacheManager){
	    	MyShiroRealm realm = new MyShiroRealm();
        	realm.setCacheManager(ehCacheManager);
        	return realm;
    	}
    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        	return new LifecycleBeanPostProcessor();
    }
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager){
     		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        	advisor.setSecurityManager(securityManager);
        	return advisor;
    }
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }
    @Bean
    public EhCacheManager getEhCacheManager(){
        EhCacheManager ehcacheManager = new EhCacheManager();
        ehcacheManager.setCacheManagerConfigFile("classpath:config/ehcache-shiro.xml");
        return ehcacheManager;
    }
    @Bean
    public SimpleCORSFilter simpleCORSFilter(){
        return new SimpleCORSFilter();
    }
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
	        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
	        factoryBean.setSecurityManager(securityManager);
	        // 自定义filter 加入shiro过滤器链
	        Map<String,Filter> map2 = new HashMap&lt;String, Filter>();
	        map2.put("simpleCORSFilter", simpleCORSFilter());
	        factoryBean.setFilters(map2);
	        Map<String,String> map = new HashMap&lt;String, String>();
	        //登出
	        map.put("/logout","logout");
	        //对所有用户认证
	        map.put("/\*\*","authc");
	        //登录  如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
	        factoryBean.setLoginUrl("/user/login");
	        //首页
	        factoryBean.setSuccessUrl("/index");
	        //错误页面，认证不通过跳转
	        factoryBean.setUnauthorizedUrl("/error");
	        factoryBean.setFilterChainDefinitionMap(map);
	        loadShiroFilterChain(factoryBean);
	        return factoryBean;
    }
     //加载ShiroFilter权限控制规则
    private void loadShiroFilterChain(ShiroFilterFactoryBean factoryBean) {
	        //下面这些规则配置最好配置到配置文件中
	        Map<String, String> filterChainMap = new LinkedHashMap<String, String>();
	        /** authc：该过滤器下的页面必须验证后才能访问，它是Shiro内置的一个拦截器
	         * org.apache.shiro.web.filter.authc.FormAuthenticationFilter */
	        // anon：它对应的过滤器里面是空的,什么都没做,可以理解为不拦截
	        //authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问
	        filterChainMap.put("/permission/userInsert", "anon");
	        filterChainMap.put("/error", "anon");
	        filterChainMap.put("/tUser/insert","anon");
	        filterChainMap.put("/\*\*", "authc");
	        factoryBean.setFilterChainDefinitionMap(filterChainMap);
    }
	//@description 密码校验规。在登陆认证的时候 ,这个类也负责对form里输入的密码进行编码
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }
    @Bean("authRealm")
    @DependsOn("lifecycleBeanPostProcessor")//可选
    public MyShiroRealm authRealm(@Qualifier("hashedCredentialsMatcher") HashedCredentialsMatcher matcher) {
        MyShiroRealm myRealm = new MyShiroRealm();
        myRealm.setAuthorizationCachingEnabled(false);
        myRealm.setCredentialsMatcher(matcher);
        return myRealm;
    }
	}
	</code></pre>

3. shiro的MD5工具类
	<pre><code>
	  public static String encrypt(String password, String salt) {
      	password = new SimpleHash(ALGORITH_NAME, password, ByteSource.Util.bytes(salt), HASH_ITERATIONS).toHex();
      	return password;
    }
	</code></pre>
4. vue模板后台解决跨域
	<pre><code>
	HttpServletResponse res = (HttpServletResponse) response;
    res.setHeader("Access-Control-Allow-Origin", "*");
    res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
    res.setHeader("Access-Control-Max-Age", "3600");
    res.setHeader("Access-Control-Allow-Headers", "Content-Type,XFILENAME,XFILECATEGORY,XFILESIZE");
	</code></pre>