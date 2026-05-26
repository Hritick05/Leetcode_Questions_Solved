class Solution {
    public String removeKdigits(String num, int k) {
         StringBuilder st = new StringBuilder();

       
        for (char digit : num.toCharArray()) {

            // Remove larger digits from the end
            while (st.length() > 0 && k > 0 &&
                   st.charAt(st.length() - 1) > digit) {
                st.deleteCharAt(st.length() - 1);
                k--;
            }

            // Avoid leading zeros
            if (st.length() > 0 || digit != '0') {
                st.append(digit);
            }
        }

        // If k still remains, remove from the end
        while (st.length() > 0 && k > 0) {
            st.deleteCharAt(st.length() - 1);
            k--;
        }

        // If result is empty, return "0"
        return st.length() == 0 ? "0" : st.toString();
    }
}