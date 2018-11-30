package com.avaya.me.controller.response;

import com.alibaba.fastjson.JSON;

public class APIResult<T> {
    private int code;
    private String message;
    private T data;

    public APIResult(APIResultBuilder<T> builder) {
        this.code = builder.code;
        this.message = builder.message;
        this.data = builder.data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getDate() {
        return data;
    }


    public static class APIResultBuilder<T> {
        private int code;
        private String message;
        private T data;

        public APIResultBuilder() {}

        public static APIResultBuilder getInstance() {
            return new APIResultBuilder();
        }
        public APIResultBuilder code(int code) {
            this.code = code;
            return this;
        }
        public APIResultBuilder message(String message ) {
            this.message = message;
            return this;
        }

        public APIResultBuilder data(T data) {
            this.data = data;
            return this;
        }

        public APIResult build() {
            return new APIResult(this);
        }
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
