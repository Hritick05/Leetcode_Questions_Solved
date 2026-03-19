public int nextGreaterElement(int n) {
    char[] digits = String.valueOf(n).toCharArray();
    int len = digits.length;

    // Step 1: find first decreasing element from right
    int i = len - 2;
    while (i >= 0 && digits[i] >= digits[i + 1]) {
        i--;
    }

    // If no such element → no greater permutation
    if (i < 0) return -1;

    // Step 2: find just greater element from right
    int j = len - 1;
    while (digits[j] <= digits[i]) {
        j--;
    }

    // Step 3: swap
    char temp = digits[i];
    digits[i] = digits[j];
    digits[j] = temp;

    // Step 4: reverse right part
    reverse(digits, i + 1, len - 1);

    // Step 5: convert to number
    long result = Long.parseLong(new String(digits));

    // Step 6: check 32-bit limit
    return (result > Integer.MAX_VALUE) ? -1 : (int) result;
}

// Helper function
private void reverse(char[] arr, int left, int right) {
    while (left < right) {
        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        left++;
        right--;
    }
}