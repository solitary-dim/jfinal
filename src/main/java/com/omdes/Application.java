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

import static com.omdes.web.WebURIMappingConstant.*;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/13
 * Time: 15:54
 */
public class Application extends JFinalConfig {

    private static final String BASE_PATH = "/WEB-INF/pages/";

    /**
     * 配置常量
     */
    @Override
    public void configConstant(Constants constants) {
        constants.setEncoding("UTF-8");
        //设置开发模式
        constants.setDevMode(true);
        //设置视图类型为Jsp，否则默认为FreeMarker
        constants.setViewType(ViewType.JSP);
    }

    /**
     * 配置路由
     */
    @Override
    public void configRoute(Routes routes) {
        //第三个参数为该Controller的视图存放路径
        routes.add("/actions", IndexController.class, "/");
        routes.add(URI_ACCOUNT, AccountController.class, BASE_PATH + "account/");
    }

    /**
     * 配置插件
     */
    @Override
    public void configPlugin(Plugins plugins) {
        //这里启用Jfinal插件
        PropKit.use("jdbc.properties");
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
        activeRecordPlugin.addMapping("t_account","ID", Account.class);
        plugins.add(activeRecordPlugin);
    }

    /**
     * 配置全局拦截器
     */
    @Override
    public void configInterceptor(Interceptors interceptors) {
        //这里用于配置全局的拦截器，对所有请求进行拦截
        // 添加控制层全局拦截器
        interceptors.addGlobalActionInterceptor(new GlobalActionInterceptor());
        // 添加业务层全局拦截器
        interceptors.addGlobalServiceInterceptor(new GlobalServiceInterceptor());
    }

    /**
     * 配置处理器
     */
    @Override
    public void configHandler(Handlers handlers) {

    }
}
