package arrays_strings;

/**
 * aabbccc
 * a2b2c3
 */
public class StringCompression_1_6 {

    public static void main(String[] args) {
        System.out.println(new StringCompression_1_6().compressString("pale"));
        System.out.println(new StringCompression_1_6().compressString("aabbccc"));
        System.out.println(new StringCompression_1_6().compressString("aabcccccaaa"));
    }

    private String compressString(String s) {
        if (s.length() == 0)
            return "";
        if (s.length() == 1)
            return s;

        StringBuilder builder = new StringBuilder();

        int count = 0;
        for (int i = 1; i < s.length(); i++) {
            count++;
            if (i + 1 >= s.length() || s.charAt(i + 1) != s.charAt(i)) {
                builder.append(s.charAt(i));
                builder.append(count);
                count = 0;
            }
        }

        if (builder.length() < s.length())
            return builder.toString();
        return s;
    }
}
