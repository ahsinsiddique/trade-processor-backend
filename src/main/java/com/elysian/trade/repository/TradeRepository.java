package com.elysian.trade.repository;

import com.elysian.trade.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {

    @Override
    Trade save(Trade entity);

    @Override
    List<Trade> findAll();
}
