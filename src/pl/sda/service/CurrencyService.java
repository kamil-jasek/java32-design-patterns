package pl.sda.service;

import java.time.LocalDate;

public interface CurrencyService {

    double exchange(String currencyCode, LocalDate date);
}
