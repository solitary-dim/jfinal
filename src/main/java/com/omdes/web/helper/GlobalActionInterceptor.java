package com.omdes.web.helper;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.JFinal;
import com.omdes.web.helper.session.SessionManager;
import com.omdes.web.helper.session.SessionObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/13
 * Time: 16:54
 */
public final class GlobalActionInterceptor implements Interceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalActionInterceptor.class);

    private Invocation invocation;

    @Override
    public void intercept(Invocation invocation) {
        try {
            //一定要把处理放在invoke之后，因为放在之前的话，是会空指针
            invocation.invoke();
            globalIntercept(invocation);
        } catch (Exception e) {
            logWrite(invocation, e);
        }
    }

    private void logWrite(Invocation inv, Exception e) {
        if (JFinal.me().getConstants().getDevMode()) {
            //开发模式
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder("---Exception Log Begin---\n").
                append("Controller:").append(inv.getController().getClass().getName()).append("\n").
                append("Method:").append(inv.getMethodName()).append("\n").
                append("Exception Type:").append(e.getClass().getName()).append("\n").
                append("Exception Details:\n");
        LOGGER.error(sb.toString(), e);
    }

    private boolean globalIntercept(Invocation invocation) {
        String requestUrl = invocation.getActionKey();
        LOGGER.info("request URI: {}", requestUrl);

        if (requestUrl.contains("secured")) {
            //后台操作，验证是否登录用户（session）
            SessionObject sessionObject = SessionManager.getCurrentUser(invocation.getController().getSession());

            return checkSecuredAccess(sessionObject);
        } else {
            return  true;
        }
    }

    private boolean checkSecuredAccess(final SessionObject userSession) {
        if (null == userSession) {
            // 用户没有登录或session已过期
            LOGGER.info("User is null!");

            return false;
        } else {
            // session中用户信息有效
            return true;
        }
    }
}
