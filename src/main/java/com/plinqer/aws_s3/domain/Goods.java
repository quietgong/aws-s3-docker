package com.plinqer.aws_s3.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Goods {
    @Id @GeneratedValue
    private Long id;

    private String category;

    private String name;

    private LocalDateTime sellDate;

    private Integer price;

    private String imgPath;

    private String thumbnailPath;

    @Builder
    public Goods(String name, String category, LocalDateTime sellDate, Integer price, String imgPath, String thumbnailPath) {
        this.name = name;
        this.category = category;
        this.sellDate = sellDate;
        this.price = price;
        this.imgPath = imgPath;
        this.thumbnailPath = thumbnailPath;
    }

    public void change(Goods goods) {}
}
