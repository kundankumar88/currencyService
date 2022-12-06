package com.microservices.currencyconversionservice.bean;

public class CurrencyBean {

    int id;
    String from;
    String to;
    Double conversionMultiple,longCalculatedValue;
    int quantity;
    String environment;

    public CurrencyBean() {
    }


    @Override
    public String toString() {
        return "CurrencyBean{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversionMultiple=" + conversionMultiple +
                ", longCalculatedValue=" + longCalculatedValue +
                ", quantity=" + quantity +
                ", environment='" + environment + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Double getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(Double conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public Double getLongCalculatedValue() {
        return longCalculatedValue;
    }

    public void setLongCalculatedValue(Double longCalculatedValue) {
        this.longCalculatedValue = longCalculatedValue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
