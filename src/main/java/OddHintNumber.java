import com.google.common.collect.Iterables;

import java.util.*;

public class OddHintNumber {

    public Integer getOddHintNumberSetVersion(List<Integer> numbers) {
        Set<Integer> uniqNumbers = new HashSet<>();
        numbers.forEach(number -> {
            if (!uniqNumbers.add(number)) {
                uniqNumbers.remove(number);
            }
        });

        return Iterables.getOnlyElement(uniqNumbers);
    }

    public Integer getOddHintNumberMapVersion(List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        numbers.forEach(i -> {
            map.computeIfPresent(i, (k, v) -> v + 1);
            map.putIfAbsent(i, 1);
        });
        return map.entrySet().stream()
                .filter(e -> isOdd(e.getValue()))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new RuntimeException("There is no number with odd hint"));
    }

    private boolean isOdd(Integer number) {
        return number % 2 != 0;
    }
}
