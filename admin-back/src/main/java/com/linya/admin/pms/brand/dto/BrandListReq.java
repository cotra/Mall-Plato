package com.linya.admin.pms.brand.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class BrandListReq implements Serializable {
    @NotNull(message = "数量不能为空")
    private long size;
    @NotNull(message = "页数不能为空")
    private long page;
}
