package com.elysian.trade.service;

import com.elysian.trade.component.TradeModule;
import com.elysian.trade.entity.Trade;
import com.elysian.trade.repository.TradeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Slf4j
public class TradeService {

    @Autowired
    public TradeRepository tradeRepository;

    @Autowired
    public TradeModule tradeModule;

    public Trade postTrade(Trade trade) {
        log.info("Service: Adds the Trade");
        Trade tradeRepositoryData = this.tradeRepository.save(trade);
        String result = "{\"userId\": \"Invalid\"}";
        try {
            result = new ObjectMapper().writeValueAsString(tradeRepositoryData);
        } catch (Exception exception) { exception.printStackTrace(); }
        tradeModule.namespace.getBroadcastOperations().sendEvent("trade", result);
        return tradeRepositoryData;
    }

    public List<Trade> getAllTrades() {
        log.info("Service: Retrieves all Trades");
        return this.tradeRepository.findAll();
    }

}
