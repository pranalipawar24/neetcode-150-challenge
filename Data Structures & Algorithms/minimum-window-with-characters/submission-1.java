class Solution {
    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> have = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0;
        int haveCount = 0;
        int needCount = need.size();

        int minLength = Integer.MAX_VALUE;
        int resultLeft = 0;
        int resultRight = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            have.put(ch, have.getOrDefault(ch, 0) + 1);

            if (need.containsKey(ch)
                    && have.get(ch).intValue() == need.get(ch).intValue()) {
                haveCount++;
            }

            while (haveCount == needCount) {

                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    resultLeft = left;
                    resultRight = right;
                }

                char leftChar = s.charAt(left);

                have.put(leftChar, have.get(leftChar) - 1);

                if (need.containsKey(leftChar)
                        && have.get(leftChar).intValue() < need.get(leftChar).intValue()) {
                    haveCount--;
                }
                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(resultLeft, resultRight + 1);
    }
}
