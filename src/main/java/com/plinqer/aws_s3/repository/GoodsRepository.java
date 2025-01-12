package com.plinqer.aws_s3.repository;

import com.plinqer.aws_s3.domain.Goods;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Repository
public class GoodsRepository {
    @PersistenceContext
    private EntityManager em;

    public List<Goods> findAll() {
        return em.createQuery("select g from Goods g", Goods.class).getResultList();
    }

    public void save(Goods goods) {
        em.persist(goods);
    }

    public Goods findOne(Long id) {
        return em.find(Goods.class, id);
    }

    public void remove(Goods goods) {
        em.remove(goods);
    }
}
