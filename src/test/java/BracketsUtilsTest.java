import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BracketsUtilsTest {
    private final BracketsUtils bracketsUtils = new BracketsUtils();

    @ParameterizedTest
    @MethodSource("getBracketsCases")
    void areBracketsBalanced(String inputString, boolean isBalanced) {
        assertEquals(bracketsUtils.areBracketsBalanced(inputString), isBalanced);
    }

    private static Stream<Arguments> getBracketsCases() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("{}", true),
                Arguments.of("[]", true),
                Arguments.of("([{}])", true),
                Arguments.of("qwe(asd[asd{{asda}(asd)asd}fe]saeaw)qweqe", true),
                Arguments.of(")", false),
                Arguments.of("}", false),
                Arguments.of("]", false),
                Arguments.of("([{", false),
                Arguments.of("([){)", false),
                Arguments.of("qwe(asd[asd{{asda}(asd)asd}fe]saeaw)qweqe)", false)
        );
    }
}