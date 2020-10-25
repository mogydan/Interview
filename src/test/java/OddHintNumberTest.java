import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class OddHintNumberTest {
    private final OddHintNumber oddHintNumber = new OddHintNumber();

    @ParameterizedTest
    @MethodSource("getOddHintNumberCases")
    void getOddHintNumberXorVersion(List<Integer> inputNumbers, Integer expectedNumber) {
        assertThat(oddHintNumber.getOddHintNumberXorVersion(inputNumbers)).isEqualTo(expectedNumber);
    }

    @ParameterizedTest
    @MethodSource("getOddHintNumberCases")
    void getOddHintNumberSetVersion(List<Integer> inputNumbers, Integer expectedNumber) {
        assertThat(oddHintNumber.getOddHintNumberSetVersion(inputNumbers)).isEqualTo(expectedNumber);
    }

    @ParameterizedTest
    @MethodSource("getOddHintNumberCases")
    void getOddHintNumberMapVersion(List<Integer> inputNumbers, Integer expectedNumber) {
        assertThat(oddHintNumber.getOddHintNumberMapVersion(inputNumbers)).isEqualTo(expectedNumber);
    }

    private static Stream<Arguments> getOddHintNumberCases() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 5, 1, 2, 3, 4), 5),
                Arguments.of(Arrays.asList(1, 1, 2, 2, 2), 2),
                Arguments.of(Arrays.asList(1, 2, 2), 1),
                Arguments.of(Arrays.asList(-1, -1, -2, -2, 1, 2, 2), 1),
                Arguments.of(Arrays.asList(1, 1, 1), 1)
        );
    }
}