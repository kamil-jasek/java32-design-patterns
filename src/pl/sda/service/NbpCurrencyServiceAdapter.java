package pl.sda.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.LocalDate;
import java.util.regex.Pattern;

public class NbpCurrencyServiceAdapter implements CurrencyService {

    @Override
    public double exchange(String currencyCode, LocalDate date) {
        try {
            final HttpResponse<String> response = requestCurrencyRate(currencyCode, date);
            System.out.println(response.body());
            final double bid = extractBid(response);
            final double ask = extractAsk(response);
            return BigDecimal.valueOf((bid + ask) / 2)
                    .setScale(4, RoundingMode.HALF_UP)
                    .doubleValue();
        } catch (Exception ex) {
            throw new RuntimeException("cannot calculate currency rate: " + currencyCode, ex);
        }
    }

    private HttpResponse<String> requestCurrencyRate(String currencyCode, LocalDate date) throws IOException, InterruptedException, URISyntaxException {
        final var httpClient = HttpClient.newHttpClient();
        final HttpResponse<String> response = httpClient.send(HttpRequest.newBuilder()
                .GET()
                .uri(buildUri(currencyCode, date))
                .build(), BodyHandlers.ofString());
        return response;
    }

    private double extractAsk(HttpResponse<String> response) {
        final var askMatcher = Pattern.compile("\"ask\":(\\d+\\.\\d+)")
                .matcher(response.body());
        if (!askMatcher.find()) {
            throw new RuntimeException("cannot find ask");
        }
        final var ask = Double.parseDouble(askMatcher.group(1));
        return ask;
    }

    private double extractBid(HttpResponse<String> response) {
        final var bidMatcher = Pattern.compile("\"bid\":(\\d+\\.\\d+)")
                .matcher(response.body());
        if (!bidMatcher.find()) {
            throw new RuntimeException("cannot find bid");
        }
        return Double.parseDouble(bidMatcher.group(1));
    }

    private URI buildUri(String currencyCode, LocalDate date) throws URISyntaxException {
        final var url = String.format(
                "http://api.nbp.pl/api/exchangerates/rates/c/%s/%s?format=json", currencyCode, date);
        return new URI(url);
    }
}
