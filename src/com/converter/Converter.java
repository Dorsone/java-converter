package com.converter;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Converter {

    protected Currency defaultCurrency;

    protected Currency converted;

    public Converter(Currency defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }
    public Converter convert(Currency to)
    {
        Http http = Http.connect("https://api.exchangerate.host/convert");
        Map<String, String> queryParams = new HashMap<>();

        queryParams.put("from", this.defaultCurrency.getCurrency());
        queryParams.put("to", to.getCurrency());

        try {
            JSONObject response = http.addQueryParam(queryParams).get();
            to.setAmount(Double.parseDouble(response.get("result").toString()) * this.defaultCurrency.getAmount());
            this.converted = to;
            return this;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Currency getConverted()
    {
        return this.converted;
    }
}
