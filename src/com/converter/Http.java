package com.converter;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class Http {
    protected String url;

    protected Http(String url) {
        this.url = url;
    }

    public static Http connect(String url) {
        return new Http(url);
    }

    public Http addQueryParam(Map<String, String> params) {
        StringBuilder url = new StringBuilder(this.url + "?");
        for (String key : params.keySet()) {
            url.append(key).append("=").append(params.get(key)).append("&");
        }
        url.deleteCharAt(url.length() - 1);
        this.url = url.toString();
        return this;
    }

    public JSONObject get() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200)
        {
            throw new Exception();
        }

        return new JSONObject(response.body());
    }
}
