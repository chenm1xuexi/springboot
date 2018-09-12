package com.bibi.springboot.common.util;

public class Pagination {
    private long totalCount;
    private long pageCount;
    private long pageSize;
    private long currentPage;
    private long offset;
    private boolean firstPage;
    private boolean lastPage;

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getPageCount() {
        return pageCount = (totalCount%pageSize) == 0 ? totalCount/pageSize : (totalCount/pageSize + 1);
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        if (pageSize < 0) {
            pageSize = 5L;
        }
       /* if (pageSize > 1000) {
            pageSize = 1000L;
        }*/
        this.pageSize = pageSize;
    }

    public long getOffset() {
        return offset = (currentPage-1) * pageSize;
    }


    public long getCurrentPage() {
        if (currentPage <= 0) {
            currentPage = 1L;
            firstPage = true;
        }
        if (currentPage > totalCount) {
            currentPage = totalCount;
            lastPage = true;
        }
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }
}
