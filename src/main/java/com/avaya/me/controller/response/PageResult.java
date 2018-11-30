package com.avaya.me.controller.response;

public class PageResult extends APIResult {

    private long total;
    private long perSize;

    public PageResult(PageResultBuilder builder) {
        super(builder);
        this.total = builder.total;
        this.perSize = builder.perSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPerSize() {
        return perSize;
    }

    public void setPerSize(long perSize) {
        this.perSize = perSize;
    }


    public static class PageResultBuilder extends APIResult.APIResultBuilder{

        private long total;
        private long perSize;

        public PageResultBuilder() {}

        public static PageResultBuilder getInstance() {
            return new PageResultBuilder();
        }

        public PageResultBuilder total(final long total) {
            this.total = total;
            return this;
        }
        public PageResultBuilder perSize(final long perSize) {
            this.perSize = perSize;
            return this;
        }

        public PageResult build() {
            return new PageResult(this);
        }
    }
}
