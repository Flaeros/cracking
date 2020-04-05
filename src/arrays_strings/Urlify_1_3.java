package arrays_strings;

/**
 * Replace spaces with %20
 */
public class Urlify_1_3 {

    public static void main(String[] args) {
        System.out.println(new Urlify_1_3().urlify("ad,   ad  dasd  ad".toCharArray()));
        System.out.println(new Urlify_1_3().urlify(" aaa  ad a".toCharArray()));
        System.out.println(new Urlify_1_3().urlify("  a  b c  ".toCharArray()));

    }

    /**
     * in-place move spaces to the end
     * replace intermediate spaces with %20
     * O(N)
     */
    public String urlify(char[] one) {
        int firstSpaceIndex = 0;
        int countSpaces = 0;
        int interSpaces = 0;
        for (int i = 0; i < one.length; i++) {
            if (one[i] != ' ') {
                if (firstSpaceIndex != i) {
                    if (countSpaces > 0) {
                        firstSpaceIndex++;
                        interSpaces++;
                    }
                    one[firstSpaceIndex] = one[i];
                    one[i] = ' ';
                    countSpaces = 0;
                }
                firstSpaceIndex++;
            } else {
                if (one[0] != ' ') {
                    countSpaces++;
                }
            }
        }

        int newLength = firstSpaceIndex - interSpaces + interSpaces * 3;
        char[] totalChars = new char[newLength];

        int j = 0;
        for (int i = 0; i < firstSpaceIndex; i++) {
            if (one[i] != ' ') {
                totalChars[j++] = one[i];
            } else {
                totalChars[j++] = '%';
                totalChars[j++] = '2';
                totalChars[j++] = '0';
            }
        }

        return "[" + String.valueOf(totalChars) + "]";
    }
}
