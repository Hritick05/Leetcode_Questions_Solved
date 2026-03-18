class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int index = 0; // position to write

        while (i < chars.length) {
            char current = chars[i];
            int count = 0;

            // count frequency of current char
            while (i < chars.length && chars[i] == current) {
                i++;
                count++;
            }

            // write character
            chars[index++] = current;

            // write count if > 1
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (char c : countStr.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}