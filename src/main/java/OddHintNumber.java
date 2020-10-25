import com.google.common.collect.Iterables;

import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class OddHintNumber {

    public int getOddHintNumberXorVersion(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (a, b) -> a ^ b);
    }

    public int getOddHintNumberSetVersion(List<Integer> numbers) {
        Set<Integer> uniqNumbers = new HashSet<>();
        numbers.forEach(number -> {
            if (!uniqNumbers.add(number)) {
                uniqNumbers.remove(number);
            }
        });

        return Iterables.getOnlyElement(uniqNumbers);
    }

    public int getOddHintNumberMapVersion(List<Integer> numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        return numbers.stream()
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalArgumentException("There is no number with odd hint"));
    }
}
