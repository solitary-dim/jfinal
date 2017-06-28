package com.omdes.web.helper.session;

import javax.servlet.http.HttpSession;

import static com.omdes.utils.ConfigConstant.SESSION_USER_PROFILE;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/28
 * Time: 16:56
 */
public final class SessionManager {

    private SessionManager(){}

    /**
     * get current user's information from session
     * @param session
     * @return
     */
    public static SessionObject getCurrentUser(final HttpSession session) {
        return (SessionObject) session.getAttribute(SESSION_USER_PROFILE);
    }

    /**
     * save current user's information into session
     *
     * @param session
     * @param user
     */
    public static void setCurrentUser(final HttpSession session, final SessionObject user) {
        session.setAttribute(SESSION_USER_PROFILE, user);
    }

    /**
     * refresh current user's information that's in session
     *
     * @param session
     */
    public static void refreshCurrentUser(final HttpSession session) {
        final SessionObject user = getCurrentUser(session);
        SessionManager.setCurrentUser(session, user);
    }

    /**
     * clean current user's information from session
     *
     * @param session
     */
    public static void cleanCurrentUser(final HttpSession session) {
        session.removeAttribute(SESSION_USER_PROFILE);
    }

    /**
     * destroy the session
     *
     * @param session
     */
    public static void cleanSession(final HttpSession session){
        session.invalidate();
    }
}
