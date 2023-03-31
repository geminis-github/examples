package com.examples.java.design.builder;

/**
 * 用户信息类
 *
 * @author liangjinlong9527
 * @date 2023-03-07 23:17
 */
public class UserInfo {
    private String name;
    private String zhName;
    private String account;
    private String password;

    public UserInfo(String name, String zhName, String account, String password) {
        this.name = name;
        this.zhName = zhName;
        this.account = account;
        this.password = password;
    }

    public UserInfo() {
    }

    /**
     * 静态类里的属性和父类里的一致
     */
    public static class Builder {
        private String name;
        private String zhName;
        private String account;
        private String password;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder zhName(String zhName) {
            this.zhName = zhName;
            return this;
        }

        public Builder account(String account) {
            this.account = account;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public UserInfo build() {
            return new UserInfo(this.name, this.zhName, this.account, this.password);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", zhName='" + zhName + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
