package com.elysian.trade.controller;

import com.elysian.trade.entity.Trade;
import com.elysian.trade.mapper.TradeMapper;
import com.elysian.trade.model.TradeModel;
import com.elysian.trade.service.TradeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/api/trade")
public class TradeRestController {

    @Autowired
    public TradeService tradeService;

    private TradeMapper tradeMapper;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<TradeModel> postTrade(@RequestBody TradeModel tradeModel) throws ParseException {
        log.info("Controller: Adds the Trade");
        if (Objects.isNull(tradeMapper))
            tradeMapper = new TradeMapper();
        Trade trade = tradeMapper.convertToEntity(tradeModel);
        TradeModel returnTrade = tradeMapper.convertToDto(this.tradeService.postTrade(trade));
        return new ResponseEntity<>(returnTrade , HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<TradeModel>> getAllTrades() {
        log.info("Controller: Retrieves all Trade");
        if (Objects.isNull(tradeMapper))
            tradeMapper = new TradeMapper();
        List<Trade> trades = this.tradeService.getAllTrades();
        List<TradeModel> tradeModels = trades.stream()
                .map(tradeMapper::convertToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(tradeModels, HttpStatus.OK);
    }

}
