package pl.sda;

import java.util.HashMap;
import java.util.List;
import java.util.function.Function;

public class MapTest {

    public static void main(String[] args) {
        final var map = new HashMap<Object, List<Double>>();
        final var sumAll = map.values()
                .stream()
                .flatMap(list -> list.stream())
                .mapToDouble(d -> d)
                .sum();

        final var size = map.values().stream()
                .mapToInt(list -> list.size())
                .sum();
    }
}
