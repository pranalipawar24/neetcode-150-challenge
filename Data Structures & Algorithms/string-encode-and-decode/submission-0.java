class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(int i = 0; i < strs.size(); i++){
            String str = strs.get(i);
            encoded.append(str.length());
            encoded.append("#");
            encoded.append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;

            while(str.charAt(j) != '#'){
                j++;
            }

            int length = Integer.parseInt(str.substring(i, j));
            j++;
            String decoded = str.substring(j, j + length);
            ans.add(decoded);
            i = j + length;
        }
        return ans;
    }
}
