package com.plinqer.aws_s3.service;

import com.plinqer.aws_s3.domain.Goods;
import com.plinqer.aws_s3.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsService {

    private final GoodsRepository repository;

    public List<Goods> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Long save(Goods goods) {
        repository.save(goods);
        return goods.getId();
    }

    public Goods findGoods(Long id) {
        return repository.findOne(id);
    }

    @Transactional
    public Goods update(Long id, Goods goods) {
        Goods findGoods = repository.findOne(id);
        findGoods.change(goods);
        return findGoods;
    }

    @Transactional
    public void delete(Goods goods) {
        repository.remove(goods);
    }
}
