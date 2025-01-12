package com.plinqer.aws_s3.controller;

import com.plinqer.aws_s3.domain.Goods;
import com.plinqer.aws_s3.dto.GoodsDto;
import com.plinqer.aws_s3.exception.BaseResponse;
import com.plinqer.aws_s3.service.GoodsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final GoodsService service;

    @GetMapping("/goods")
    public BaseResponse findGoods() {
        List<Goods> goods = service.findAll();
        List<GoodsDto> collect = goods.stream()
                .map(GoodsDto::new)
                .collect(Collectors.toList());
        return BaseResponse.success(collect);
    }

    @PostMapping("/goods")
    public BaseResponse saveGoods(@RequestBody Goods goods) {
        Long id = service.save(goods);
        return BaseResponse.success(id);
    }

    @DeleteMapping("/goods/{id}")
    public BaseResponse deleteGoods(@PathVariable Long id) {
        Goods findGoods = service.findGoods(id);
        service.delete(findGoods);
        return BaseResponse.success(id);
    }
}
