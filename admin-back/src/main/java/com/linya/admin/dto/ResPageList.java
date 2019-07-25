package com.linya.admin.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ResPageList<T> implements Serializable {

    private List<T> list;
    private long total;
    private long size;
    private long page;

    public ResPageList(List<T> list, long total, long size, long page) {
        this.list = list;
        this.total = total;
        this.size = size;
        this.page = page;
    }
}
