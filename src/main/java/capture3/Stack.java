package capture3;

/**
 * 使用Stack反转字符串
 */
public class Stack {
    public static void main(String[] args) {
        String word = "stack";
        String convertedWord= reverse(word);
        System.out.println(convertedWord);
    }

    public static String reverse(String word){
        char[] chars = word.toCharArray();
        java.util.Stack<Character> characters = new java.util.Stack<Character>();
        for (char aChar : chars) {
            characters.push(aChar);
        }
        char [] convert = new char[word.length()];
        for (int i = 0; i < convert.length; i++) {
            convert[i] = characters.pop();
        }
        return new String(convert);
    }
}
