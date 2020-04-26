package bitmap_5;

public class FlipBitToWin_5_3 {

    public static void main(String[] args) {
        System.out.println(new FlipBitToWin_5_3().maxOnesLength(1775)); //8
    }

    int maxOnesLength(int num) {
        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1;
        while (num > 0) {

            if ((num & 1) == 1) {
                currentLength++;
            } else if ((num & 1) == 0) {
                previousLength = (num & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(previousLength + currentLength + 1, maxLength);
            num >>>= 1;
        }

        return maxLength;
    }


}
