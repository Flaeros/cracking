package bitmap_5;

public class DrawLine_5_8 {
    public static void main(String[] args) {
        new DrawLine_5_8().drawLine(new byte[]{0, 0, 0, 0}, 16, 3, 12, 1);
    }

    byte[] drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int startOffset = x1 % 8;
        int firstFullByte = x1 / 8;
        if (startOffset != 0) {
            firstFullByte++;
        }

        int endOffset = x2 % 8;
        int lastFullByte = x2 / 8;
        if (endOffset != 7) {
            lastFullByte--;
        }

        // Set full bytes
        for (int b = firstFullByte; b <= lastFullByte; b++) {
            screen[(width / 8) * y + b] = (byte) 0xFF;
        }

        // Create masks for start and end of line
        byte start_mask = (byte) (0xFF >> startOffset);
        byte end_mask = (byte) -(0xFF >> (endOffset + 1));

        // Set start and end of line
        if ((x1 / 8) == (x2 / 8)) { // x1 and x2 are in the same byte
            byte mask = (byte) (start_mask & end_mask);
            screen[(width / 8) * y + (x1 / 8)] |= mask;
        } else {
            if (startOffset != 0) {
                int byte_number = (width / 8) * y + firstFullByte - 1;
                screen[byte_number] |= start_mask;
            }
            if (endOffset != 7) {
                int byte_number = (width / 8) * y + lastFullByte + 1;
                screen[byte_number] |= end_mask;
            }
        }

        return screen;
    }
}
