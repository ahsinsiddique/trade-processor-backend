package com.elysian.trade.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Trade")
public class Trade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "USER_ID")
    private String userId;

    @Column(name = "CURRENCY_FROM")
    private String currencyFrom;

    @Column(name = "CURRENCY_TO")
    private String currencyTo;

    @Column(name = "AMOUNT_SELL")
    private Double amountSell;

    @Column(name = "AMOUNT_BUY")
    private Double amountBuy;

    @Column(name = "RATE")
    private Double rate;

    @Column(name = "TIME_PLACED")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime timePlaced;

    @Column(name = "ORIGINATING_COUNTRY")
    private String originatingCountry;

}
