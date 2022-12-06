package com.microservices.currencyconversionservice.controller;


import com.microservices.currencyconversionservice.bean.CurrencyExchange;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {


    @GetMapping("/currency-exchange/from/{from_currency}/to/{to_currency}")

     CurrencyExchange retriveExchangeValue(@PathVariable("from_currency")
                                                         String from, @PathVariable("to_currency") String to) ;


}
