package com.elysian.trade.mapper;

import com.elysian.trade.entity.Trade;
import com.elysian.trade.model.TradeModel;

public class TradeMapper {

    public TradeModel convertToDto(Trade trade) {
        return TradeModel.builder()
                .id(trade.getId())
                .userId(trade.getUserId())
                .amountBuy(trade.getAmountBuy())
                .amountSell(trade.getAmountSell())
                .currencyFrom(trade.getCurrencyFrom())
                .currencyTo(trade.getCurrencyTo())
                .originatingCountry(trade.getOriginatingCountry())
                .rate(trade.getRate())
                .timePlaced(trade.getTimePlaced())
                .build();
    }

    public Trade convertToEntity(TradeModel tradeModel) {
        return Trade.builder()
                .id(tradeModel.getId())
                .userId(tradeModel.getUserId())
                .amountBuy(tradeModel.getAmountBuy())
                .amountSell(tradeModel.getAmountSell())
                .currencyFrom(tradeModel.getCurrencyFrom())
                .currencyTo(tradeModel.getCurrencyTo())
                .originatingCountry(tradeModel.getOriginatingCountry())
                .rate(tradeModel.getRate())
                .timePlaced(tradeModel.getTimePlaced())
                .build();
    }

}
