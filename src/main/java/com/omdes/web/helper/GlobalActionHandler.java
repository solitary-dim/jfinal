package com.omdes.web.helper;

import com.jfinal.handler.Handler;
import com.omdes.web.helper.session.SessionManager;
import com.omdes.web.helper.session.SessionObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/28
 * Time: 17:04
 */
public final class GlobalActionHandler extends Handler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalActionHandler.class);

    @Override
    public void handle(String s, HttpServletRequest request, HttpServletResponse response, boolean[] booleans) {
        String requestUrl = request.getRequestURI();
        LOGGER.info("request URI: {}", requestUrl);

        if (requestUrl.contains("secured")) {
            //后台操作，验证是否登录用户（session）
            SessionObject sessionObject = SessionManager.getCurrentUser(request.getSession());
            if (!checkSecuredAccess(sessionObject)) {
                return;
            }
        } else {
            //
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
