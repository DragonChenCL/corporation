##vue-admin学习总结
1. `<router-view/>`路由匹配到的组件将显示在这里
2. 登录成功后从`src/permission.js`中拉取用户权限信息
3. 调用`api/login.js`中的`/user/info`拉取信息
##登录篇
4. 需要改造shiro的session验证方式,接收X-Token的请求头
5. 当用户登录后,获取用户role,将role和路由表每个页面的需要的权限作比较,生成最终用户可访问的路由表
6. 调用router.addRoutes(store.getters.addRouters)添加用户可访问的路由
4. 使用vuex管理路由表,根据vuex中可访问的路由渲染侧边栏组件
5. vuex中store数据改变的唯一方法就是mutation
6. mapGetters可快速获取store里面的属性
7. 面包屑是在`Breadcrumb\index.vue`的`watch`中生成的
8. `src/lang/en.js`是配置`i18n`的文件
##VUEX
1. 每一个Vuex应用的核心就是store(仓库)。store基本上就是一个容器,它包含着你的应用中大部分状态。
2. Vuex的状态存储是响应式的。当Vuex组件从store中读取状态的时候,若store中的状态发生变化,那么相应的组件也会相应地得到高效更新。
3. 你不能直接改变store中的状态。改变store中的状态唯一途径就是显示地提交(commit)mutation。
##流程篇
1. 登录,成功后在store中设置token
2. 登录成功转向主页,路由守卫拦截到,判断是否有token
	+ 没有则跳转到登录页
	+ 有则判断是否有角色
		+ 没有角色的话,去拉取角色信息,并且在store中设置角色信息,然后判断并添加路由
		+ 有角色直接判断路由是否有权限
			+ 有权限则访问
			+ 没权限则到401页面