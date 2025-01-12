package com.plinqer.aws_s3.dto;

import com.plinqer.aws_s3.domain.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GoodsDto {
    private Long id;
    private String name;

    public GoodsDto(Goods goods) {
        this.id = goods.getId();
        this.name = goods.getName();
        // Add More field
    }
}
