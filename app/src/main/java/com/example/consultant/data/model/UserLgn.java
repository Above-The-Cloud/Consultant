package com.example.consultant.data.model;

public class UserLgn {
    /**
     * code : 0
     * msg : success
     * data : {"username":"壹汪春雨","phone":"18918053907","gender":1,"avatar":"http://consultant.yiwangchunyu.wang/meida/system/avatar.jpg","status":1,"ctime":"2019-05-02T17:06:01.416Z","mtime":"2019-05-02T17:06:01.417Z","user_id":1}
     */

    private int code;
    private String msg;
    private DataBean data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * username : 壹汪春雨
         * phone : 18918053907
         * gender : 1
         * avatar : http://consultant.yiwangchunyu.wang/meida/system/avatar.jpg
         * status : 1
         * ctime : 2019-05-02T17:06:01.416Z
         * mtime : 2019-05-02T17:06:01.417Z
         * user_id : 1
         */

        private String username;
        private String phone;
        private int gender;
        private String avatar;
        private int status;
        private String ctime;
        private String mtime;
        private String user_id;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getCtime() {
            return ctime;
        }

        public void setCtime(String ctime) {
            this.ctime = ctime;
        }

        public String getMtime() {
            return mtime;
        }

        public void setMtime(String mtime) {
            this.mtime = mtime;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }
    }
}
