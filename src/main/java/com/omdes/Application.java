package com.omdes;

import com.jfinal.config.*;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.omdes.domains.account.model.Account;
import com.omdes.web.account.AccountController;
import com.omdes.web.helper.GlobalActionInterceptor;
import com.omdes.web.helper.GlobalServiceInterceptor;
import com.omdes.web.index.IndexController;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/13
 * Time: 15:54
 */
public class Application extends JFinalConfig {
    @Override
    public void configConstant(Constants constants) {
        constants.setEncoding("UTF-8");
        constants.setDevMode(true);
        constants.setViewType(ViewType.JSP);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.add("/actions/", IndexController.class);
        routes.add("/actions/user", AccountController.class);
    }

    @Override
    public void configPlugin(Plugins plugins) {
        //这里启用Jfinal插件
        /*PropKit.use("jdbc.properties");
        final String URL =PropKit.get("jdbcUrl");
        final String USERNAME = PropKit.get("user");
        final String PASSWORD =PropKit.get("password");
        final Integer INITIALSIZE = PropKit.getInt("initialSize");
        final Integer MIDIDLE = PropKit.getInt("minIdle");
        final Integer MAXACTIVEE = PropKit.getInt("maxActivee");
        DruidPlugin druidPlugin = new DruidPlugin(URL,USERNAME,PASSWORD);
        druidPlugin.set(INITIALSIZE,MIDIDLE,MAXACTIVEE);
        druidPlugin.setFilters("stat,wall");
        plugins.add(druidPlugin);
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidPlugin);
        activeRecordPlugin.addMapping("user","userid", Account.class);
        plugins.add(activeRecordPlugin);*/
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {
        //这里用于配置全局的拦截器，对所有请求进行拦截
        // 添加控制层全局拦截器
        interceptors.addGlobalActionInterceptor(new GlobalActionInterceptor());
        // 添加业务层全局拦截器
        interceptors.addGlobalServiceInterceptor(new GlobalServiceInterceptor());
    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
