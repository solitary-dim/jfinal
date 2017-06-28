package com.omdes.web.helper.session;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/28
 * Time: 16:10
 */
public final class SessionObject implements Serializable {
    private static final long serialVersionUID = 8431140804253819198L;

    private long id;
    private String loginName;
    private long role;
    private String roleName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public long getRole() {
        return role;
    }

    public void setRole(long role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
