DROP TABLE IF EXISTS TRADE;
CREATE TABLE TRADE (
                       ID int NOT NULL AUTO_INCREMENT,
                       USER_ID VARCHAR(255),
                       CURRENCY_FROM VARCHAR(255),
                       CURRENCY_TO VARCHAR(255),
                       AMOUNT_SELL DECIMAL(10,4),
                       AMOUNT_BUY DECIMAL(10,4),
                       RATE DECIMAL(10,4),
                       TIME_PLACED TIMESTAMP,
                       ORIGINATING_COUNTRY VARCHAR(255)
);
