package pl.sda;

import pl.sda.service.NbpCurrencyServiceAdapter;

import java.time.LocalDate;

public class CurrencyServiceTest {

    public static void main(String[] args) {
        final var service = new NbpCurrencyServiceAdapter();
        final var exchange = service.exchange("CAD", LocalDate.of(2021, 8, 26));
        assert exchange == 3.0828;
    }
}
