package com.avaya.me.controller.response;

public class UserResponseDetails {
    private long id;
    private String username;
    private RequestMess link;


    public UserResponseDetails(UserResponseDetailsBuiler builer) {
        this.id = builer.id;
        this.username = builer.username;
        this.link = builer.link;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RequestMess getLink() {
        return link;
    }

    public void setLink(RequestMess link) {
        this.link = link;
    }

    public static class UserResponseDetailsBuiler{
        private long id;
        private String username;
        private RequestMess link;

        public UserResponseDetailsBuiler(){}

        public static UserResponseDetailsBuiler getInstance() {
            return new UserResponseDetailsBuiler();
        }

        public UserResponseDetailsBuiler id(long id) {
            this.id = id;
            return this;
        }

        public UserResponseDetailsBuiler username(String username) {
            this.username = username;
            return this;
        }

        public UserResponseDetailsBuiler link(RequestMess link) {
            this.link = link;
            return this;
        }
        public UserResponseDetails build() {
            return new UserResponseDetails(this);
        }
    }
}
