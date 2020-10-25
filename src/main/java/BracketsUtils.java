import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class BracketsUtils {
    private static final List<Character> allowedOpenBrackets = Arrays.asList('(', '{', '[');
    private static final List<Character> allowedClosedBrackets = Arrays.asList(')', '}', ']');

    public boolean areBracketsBalanced(String inputString) {
        Deque<Character> openBracketsQueue = new ArrayDeque<>();
        for (char ch : inputString.toCharArray()) {
            if (isOpenBracket(ch)) {
                openBracketsQueue.addLast(ch);
            }
            if (isClosedBracket(ch)) {
                if (hasAppropriateOpenBracket(openBracketsQueue, ch)) {
                    openBracketsQueue.removeLast();
                } else {
                    return false;
                }
            }
        }
        return openBracketsQueue.isEmpty();
    }

    private boolean isOpenBracket(char ch) {
        return allowedOpenBrackets.contains(ch);
    }

    private boolean isClosedBracket(char ch) {
        return allowedClosedBrackets.contains(ch);
    }

    private boolean hasAppropriateOpenBracket(Deque<Character> openBracketsQueue, char closedBracket) {
        if (openBracketsQueue.isEmpty()) {
            return false;
        }
        char openedBracket = openBracketsQueue.getLast();
        if (closedBracket == ')') {
            return openedBracket == '(';
        }
        if (closedBracket == '}') {
            return openedBracket == '{';
        }
        if (closedBracket == ']') {
            return openedBracket == '[';
        }
        return false;
    }
}
