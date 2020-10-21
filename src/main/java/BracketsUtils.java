import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class BracketsUtils {
    private static final List<Character> allowedOpenBrackets = Arrays.asList('(', '{', '[');
    private static final List<Character> allowedClosedBrackets = Arrays.asList(')', '}', ']');

    public boolean areBracketsBalanced(String inputString) {
        Deque<Character> openBracketsStack = new ArrayDeque<>();
        for (char ch : inputString.toCharArray()) {
            if (isOpenBracket(ch)) {
                openBracketsStack.push(ch);
            }
            if (isClosedBracket(ch)) {
                if (hasAppropriateOpenBracket(openBracketsStack, ch)) {
                    openBracketsStack.pop();
                } else {
                    return false;
                }
            }
        }
        return openBracketsStack.isEmpty();
    }

    private boolean isOpenBracket(char ch) {
        return allowedOpenBrackets.contains(ch);
    }

    private boolean isClosedBracket(char ch) {
        return allowedClosedBrackets.contains(ch);
    }

    private boolean hasAppropriateOpenBracket(Deque<Character> openBracketsStack, char closedBracket) {
        if (openBracketsStack.isEmpty()) {
            return false;
        }
        char openedBracket = openBracketsStack.peekFirst();
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
