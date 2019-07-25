package com.linya.admin.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageList<T> implements Serializable {

    private List<T> list;
    private long total;
    private long size;
    private long page;

    public PageList(List<T> list, long total, long size, long page) {
        this.list = list;
        this.total = total;
        this.size = size;
        this.page = page;
    }
}
