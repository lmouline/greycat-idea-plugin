package greycat.idea.toolwindow;

public class Base64 {

    private final static char[] encodeArray = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private final static int[] decodeArray = new int[123];

    static {
        int i = 0;
        for (char c = 'A'; c <= 'Z'; c++) {
            decodeArray[c] = i;
            i++;
        }
        for (char c = 'a'; c <= 'z'; c++) {
            decodeArray[c] = i;
            i++;
        }
        for (char c = '0'; c <= '9'; c++) {
            decodeArray[c] = i;
            i++;
        }
        decodeArray['+'] = i;
        i++;
        decodeArray['/'] = i;
    }


    /**
     * Encodes a long in a base-64 string. Sign is encoded on bit 0 of the long => LS bit of the right-most char of the string. 1 for negative; 0 otherwise.
     *
     * @param l the long to encode
     * @return the encoded string
     */
    public static String encodeLong(long l) {
        String result = "";
        long tmp = l;
        if (l < 0) {
            tmp = -tmp;
        }
        for (int i = 47; i >= 5; i -= 6) {
            if (!(result.equals("") && ((int) (tmp >> i) & 0x3F) == 0)) {
                result += encodeArray[(int) (tmp >> i) & 0x3F];
            }
        }
        result += Base64.encodeArray[(int) ((tmp & 0x1F) << 1) + (l < 0 ? 1 : 0)];
        return result;
    }

    public static void encodeLongToBuffer(long l, StringBuilder buffer) {
        boolean empty = true;
        long tmp = l;
        if (l < 0) {
            tmp = -tmp;
        }
        for (int i = 47; i >= 5; i -= 6) {
            if (!(empty && ((int) (tmp >> i) & 0x3F) == 0)) {
                empty = false;
                buffer.append(encodeArray[(int) (tmp >> i) & 0x3F]);
            }
        }
        buffer.append(Base64.encodeArray[(int) ((tmp & 0x1F) << 1) + (l < 0 ? 1 : 0)]);
    }


    /**
     * Encodes a int in a base-64 string. Sign is encoded on bit 0 of the long => LS bit of the right-most char of the string. 1 for negative; 0 otherwise.
     *
     * @param l the int to encode
     * @return the encoded string
     */
    public static String encodeInt(int l) {
        String result = "";
        int tmp = l;
        if (l < 0) {
            tmp = -tmp;
        }
        for (int i = 29; i >= 5; i -= 6) {
            if (!(result.equals("") && ((tmp >> i) & 0x3F) == 0)) {
                result += Base64.encodeArray[(tmp >> i) & 0x3F];
            }
        }
        result += Base64.encodeArray[(tmp & 0x1F) * 2 + (l < 0 ? 1 : 0)];
        return result;
    }


    public static void encodeIntToBuffer(int l, StringBuilder buffer) {
        boolean empty = true;
        int tmp = l;
        if (l < 0) {
            tmp = -tmp;
        }
        for (int i = 29; i >= 5; i -= 6) {
            if (!(empty && ((int) (tmp >> i) & 0x3F) == 0)) {
                empty = false;
                buffer.append(encodeArray[(tmp >> i) & 0x3F]);
            }
        }
        buffer.append(Base64.encodeArray[((tmp & 0x1F) << 1) + (l < 0 ? 1 : 0)]);
    }

    public static long decodeToLong(String s) {
        return decodeToLongWithBounds(s, 0, s.length());
    }

    public static long decodeToLongWithBounds(String s, int offsetBegin, int offsetEnd) {
        long result = 0;
        result += (Base64.decodeArray[s.charAt(offsetEnd - 1)] & 0xFF) >> 1;
        for (int i = 1; i < (offsetEnd - offsetBegin); i++) {
            result += ((long) (Base64.decodeArray[s.charAt((offsetEnd - 1) - i)] & 0xFF)) << ((6 * i) - 1);
        }
        if (((Base64.decodeArray[s.charAt(offsetEnd - 1)] & 0xFF) & 0x1) != 0) {
            result = -result;
        }
        return result;
    }

    public static int decodeToInt(String s) {
        return decodeToIntWithBounds(s, 0, s.length());
    }

    public static int decodeToIntWithBounds(String s, int offsetBegin, int offsetEnd) {
        int result = 0;
        result += (Base64.decodeArray[s.charAt(offsetEnd - 1)] & 0xFF) >> 1;
        for (int i = 1; i < (offsetEnd - offsetBegin); i++) {
            result += (Base64.decodeArray[s.charAt((offsetEnd - 1) - i)] & 0xFF) << ((6 * i) - 1);
        }
        if (((Base64.decodeArray[s.charAt(offsetEnd - 1)] & 0xFF) & 0x1) != 0) {
            result = -result;
        }
        return result;
    }


    /**
     * Encodes a boolean array into a Base64 string
     *
     * @param boolArr the array to encode
     * @return the string encoding the array.
     */
    public static String encodeBoolArray(boolean[] boolArr) {
        String result = "";
        int tmpVal = 0;
        for (int i = 0; i < boolArr.length; i++) {
            tmpVal = tmpVal | ((boolArr[i] ? 1 : 0) << i % 6);
            if (i % 6 == 5 || i == boolArr.length - 1) {
                result += Base64.encodeArray[tmpVal];
                tmpVal = 0;
            }
        }
        return result;
    }

    public static void encodeBoolArrayToBuffer(boolean[] boolArr, StringBuilder buffer) {
        int tmpVal = 0;
        for (int i = 0; i < boolArr.length; i++) {
            tmpVal = tmpVal | ((boolArr[i] ? 1 : 0) << i % 6);
            if (i % 6 == 5 || i == boolArr.length - 1) {
                buffer.append(Base64.encodeArray[tmpVal]);
                tmpVal = 0;
            }
        }
    }

    public static boolean[] decodeBoolArray(String s, int arraySize) {
        return decodeToBoolArrayWithBounds(s, 0, s.length(), arraySize);
    }

    public static boolean[] decodeToBoolArrayWithBounds(String s, int offsetBegin, int offsetEnd, int arraySize) {
        boolean[] resultTmp = new boolean[arraySize];
        for (int i = 0; i < (offsetEnd - offsetBegin); i++) {
            int bitarray = Base64.decodeArray[s.charAt(offsetBegin + i)] & 0xFF;
            for (int bit_i = 0; bit_i < 6; bit_i++) {
                if ((6 * i) + bit_i < arraySize) {
                    resultTmp[(6 * i) + bit_i] = (bitarray & (1 << bit_i)) != 0;
                } else {
                    break;
                }
            }
        }
        return resultTmp;
    }

    /**
     * Encodes a double into Base64 string Following the IEEE-754.
     * 2 first chars for sign + exponent; remaining chars on the right for the mantissa.
     * Trailing 'A's (aka 0) are dismissed for compression.
     *
     * @param d the double to encode
     * @return the encoding string
     */
    public static String encodeDouble(double d) {
        String result = "";
        long l = Double.doubleToLongBits(d);
        //encode sign + exp
        result += Base64.encodeArray[(int) (l >> 58) & 0x3F];
        result += Base64.encodeArray[(int) (l >> 52) & 0x3F];
        //encode mantissa
        result += Base64.encodeArray[(int) (l >> 48) & 0x0F];
        for (int i = 42; i >= 0; i -= 6) {
            if (((l >> i) & 0x3F) == 0 && (l & (~(0xFFFFFFFFFFFFFFFFl << i))) == 0) {
                break;
            }
            result += Base64.encodeArray[(int) (l >> i) & 0x3F];
        }
        return result;
    }

    public static void encodeDoubleToBuffer(double d, StringBuilder buffer) {
        long l = Double.doubleToLongBits(d);
        //encode sign + exp
        buffer.append(Base64.encodeArray[(int) (l >> 58) & 0x3F]);
        buffer.append(Base64.encodeArray[(int) (l >> 52) & 0x3F]);
        //encode mantisse
        buffer.append(Base64.encodeArray[(int) (l >> 48) & 0x0F]);
        for (int i = 42; i >= 0; i -= 6) {
            if (((l >> i) & 0x3F) == 0 && (l & (~(0xFFFFFFFFFFFFFFFFl << i))) == 0) {
                return;
            }
            buffer.append(Base64.encodeArray[(int) (l >> i) & 0x3F]);
        }
    }

    public static double decodeToDouble(String s) {
        return decodeToDoubleWithBounds(s, 0, s.length());
    }

    public static double decodeToDoubleWithBounds(String s, int offsetBegin, int offsetEnd) {
        long result = 0;
        //sign + exponent
        result += ((long) Base64.decodeArray[s.charAt(offsetBegin)] & 0xFF) << 58;
        result += ((long) Base64.decodeArray[s.charAt(offsetBegin+1)] & 0xFF) << 52;
        //Mantisse
        for (int i = 2; i < (offsetEnd - offsetBegin); i++) {
            result += ((long) Base64.decodeArray[s.charAt(offsetBegin + i)] & 0xFF) << (48 - (6 * (i - 2)));
        }
        return Double.longBitsToDouble(result);
    }




    public static String encodeString(String s) {
        String result = "";

        int sLength = s.length();
        char currentSourceChar;
        int currentEncodedChar = 0;
        int freeBitsInCurrentChar = 6;

        for(int charIdx = 0; charIdx < sLength; charIdx++) {
            currentSourceChar = s.charAt(charIdx);
            if(freeBitsInCurrentChar == 6) {
                result += Base64.encodeArray[currentSourceChar >> 2 & 0x3F];
                currentEncodedChar = (currentSourceChar & 0x3) << 4;
                freeBitsInCurrentChar = 4;
            } else if(freeBitsInCurrentChar == 4) {
                result += Base64.encodeArray[(currentEncodedChar | ((currentSourceChar >> 4) & 0xF)) & 0x3F];
                currentEncodedChar = (currentSourceChar & 0xF) << 2;
                freeBitsInCurrentChar = 2;
            } else if(freeBitsInCurrentChar == 2) {
                result += Base64.encodeArray[(currentEncodedChar | ((currentSourceChar >> 6) & 0x3)) & 0x3F];
                result += Base64.encodeArray[currentSourceChar & 0x3F];
                freeBitsInCurrentChar = 6;
            }
        }

        if(freeBitsInCurrentChar != 6) {
            result += Base64.encodeArray[currentEncodedChar];
        }
        return result;
    }

    public static void encodeStringToBuffer(String s, StringBuilder buffer) {
        int sLength = s.length();
        char currentSourceChar;
        int currentEncodedChar = 0;
        int freeBitsInCurrentChar = 6;

        for(int charIdx = 0; charIdx < sLength; charIdx++) {
            currentSourceChar = s.charAt(charIdx);
            if(freeBitsInCurrentChar == 6) {
                buffer.append(Base64.encodeArray[currentSourceChar >> 2 & 0x3F]);
                currentEncodedChar = (currentSourceChar & 0x3) << 4;
                freeBitsInCurrentChar = 4;
            } else if(freeBitsInCurrentChar == 4) {
                buffer.append(Base64.encodeArray[(currentEncodedChar | ((currentSourceChar >> 4) & 0xF)) & 0x3F]);
                currentEncodedChar = (currentSourceChar & 0xF) << 2;
                freeBitsInCurrentChar = 2;
            } else if(freeBitsInCurrentChar == 2) {
                buffer.append(Base64.encodeArray[(currentEncodedChar | ((currentSourceChar >> 6) & 0x3)) & 0x3F]);
                buffer.append(Base64.encodeArray[currentSourceChar & 0x3F]);
                freeBitsInCurrentChar = 6;
            }
        }

        if(freeBitsInCurrentChar != 6) {
            buffer.append(Base64.encodeArray[currentEncodedChar]);
        }
    }

    public static String decodeToString(String s) {
        return decodeToStringWithBounds(s, 0, s.length());
    }

    public static String decodeToStringWithBounds(String s, int offsetBegin, int offsetEnd) {
        if(offsetBegin == offsetEnd) {
            return null;
        }
        String result = "";

        int currentSourceChar;
        int currentDecodedChar = 0;
        int freeBitsInCurrentChar = 8;

        for(int charIdx = offsetBegin; charIdx < offsetEnd; charIdx++) {
            currentSourceChar = Base64.decodeArray[s.charAt(charIdx)];
            if(freeBitsInCurrentChar == 8) {
                currentDecodedChar = currentSourceChar << 2;
                freeBitsInCurrentChar = 2;
            } else if(freeBitsInCurrentChar == 2) {
                result += (char)(currentDecodedChar | (currentSourceChar >> 4));
                currentDecodedChar = (currentSourceChar & 0xF) << 4;
                freeBitsInCurrentChar = 4;
            } else if(freeBitsInCurrentChar == 4) {
                result += (char)(currentDecodedChar | (currentSourceChar >> 2));
                currentDecodedChar = (currentSourceChar & 0x3) << 6;
                freeBitsInCurrentChar = 6;
            } else if(freeBitsInCurrentChar == 6) {
                result += (char)(currentDecodedChar | currentSourceChar);
                freeBitsInCurrentChar = 8;
            }
        }

        return result;
    }


    /*

    private static String printBits(long val) {
        String toString = Long.toBinaryString(val);
        String res = "";

        for (int i = 0; i < 64 - toString.length(); i++) {
            res += "0";
        }
        return res + toString;
    }

    private static String printBits(int val) {
        String toString = Integer.toBinaryString(val);
        String res = "";

        for (int i = 0; i < 32 - toString.length(); i++) {
            res += "0";
        }
        return res + toString;
    }
    */


}
