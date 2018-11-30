package com.avaya.me.controller.response;

public class RequestMess {

    private String method;
    private String url;

    public RequestMess(RequestMessBuilder builder) {
        this.method = builder.method;
        this.url = builder.url;
    }


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "RequestMess{" +
                "method='" + method + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public static class RequestMessBuilder {
        private String method;
        private String url;


        public static RequestMessBuilder newInstance( ) {
            return new RequestMessBuilder();
        }

        private RequestMessBuilder() {}

        public RequestMessBuilder method(final String method) {
            this.method = method;
            return this;
        }

        public RequestMessBuilder url(final String url) {
            this.url = url;
            return this;
        }

        public RequestMess build()
        {
            return new RequestMess(this);
        }
    }
}



