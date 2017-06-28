package com.omdes.web;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/13
 * Time: 16:46
 */
public final class WebURIMappingConstant {
    public static final String ROOT = "/actions/";
    public static final String SECURITY_ROOT = "/actions/secured/";

    public static final String URI_INDEX = ROOT + "index";
    public static final String URI_LOGIN = ROOT + "login";
    public static final String URI_LOGOUT = ROOT + "logout";

    //account management
    public static final String URI_ACCOUNT = SECURITY_ROOT + "account";
    public static final String URI_ACCOUNT_ADD = URI_ACCOUNT + "/add";
    public static final String URI_ACCOUNT_ADD_REDIRECT = URI_ACCOUNT + "/toAddPage";
}
