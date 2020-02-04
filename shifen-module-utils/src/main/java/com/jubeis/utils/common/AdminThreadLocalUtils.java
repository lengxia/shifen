package com.jubeis.utils.common;


import com.jubeis.model.user.dos.UserDO;

public class AdminThreadLocalUtils {

    private final static ThreadLocal<UserDO> userThreadLocal = new ThreadLocal<>();

    /**
     * 设置当前线程中的用户
     *
     * @param user
     */
    public static void setUser(UserDO user) {
        userThreadLocal.set(user);
    }

    /**
     * 获取线程中的用户
     *
     * @return
     */
    public static UserDO getUser() {
        return userThreadLocal.get();
    }

}
