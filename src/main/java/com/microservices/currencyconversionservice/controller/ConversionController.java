package com.microservices.currencyconversionservice.controller;

import com.microservices.currencyconversionservice.bean.CurrencyBean;
import com.microservices.currencyconversionservice.bean.CurrencyExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConversionController {

    @Value("${server.port}")
    String serverPort;
    @Autowired
    CurrencyExchangeProxy proxy;


    @GetMapping("currency-conversion/from/{from_currency}/to/{to_currency}/quantity/{quantities}")

    public CurrencyBean getConversion(@PathVariable("from_currency") String from,@PathVariable("to_currency")
                                      String to ,@PathVariable("quantities") int quantities)
    {
        CurrencyBean currencyBean=new CurrencyBean();
        Map<String,String> uriVariables=new HashMap<>();

        uriVariables.put("from",from);
        uriVariables.put("to",to);

        ResponseEntity<CurrencyExchange> responseEntity=new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyExchange.class,uriVariables );

        CurrencyExchange beanObj= responseEntity.getBody();
        currencyBean.setFrom(from);
        currencyBean.setTo(to);
        currencyBean.setEnvironment(serverPort);
        currencyBean.setQuantity(quantities);
        currencyBean.setConversionMultiple(beanObj.getConversionMultiple());
        currencyBean.setLongCalculatedValue(beanObj.getConversionMultiple()*quantities);
        return currencyBean;

    }




    @GetMapping("currency-conversion-fiegn/from/{from_currency}/to/{to_currency}/quantity/{quantities}")

    public CurrencyBean getConversionFiegn(@PathVariable("from_currency") String from,@PathVariable("to_currency")
            String to ,@PathVariable("quantities") int quantities)
    {
        CurrencyBean currencyBean=new CurrencyBean();
        CurrencyExchange beanObj=proxy.retriveExchangeValue(from,to);
        currencyBean.setFrom(from);
        currencyBean.setTo(to);
        currencyBean.setEnvironment(beanObj.getEnvironment()+"fiegn");
        currencyBean.setQuantity(quantities);
        currencyBean.setConversionMultiple(beanObj.getConversionMultiple());
        currencyBean.setLongCalculatedValue(beanObj.getConversionMultiple()*quantities);
        return currencyBean;

    }
  @GetMapping("/hello")

    public String hello()
  {
      return "hello";
  }



}
