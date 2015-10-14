package sort;

/**
 * Created by sharath on 8/3/15.
 */
public class BucketSort {
    private static final int ASCII_LENGTH = 256;

    static String sort(String inString) {
        int[] store = new int[ASCII_LENGTH + 1];
        for(int i = 0; i < inString.length(); i++) {
            store[inString.charAt(i)]++;
        }

        StringBuilder sb = new StringBuilder(inString.length());
        for(int i = 0; i < store.length; i++) {
            for(int j = 0; j < store[i]; j++) {
                char c = (char)i;
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(sort("aBcbBlkN"));
    }
}
