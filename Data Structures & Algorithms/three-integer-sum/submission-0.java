class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int k = 0; k < nums.length - 2; k++){
            if(k > 0 && nums[k] == nums[k-1]){
                continue;
            }

            int i = k + 1;
            int j = nums.length - 1;
            
            while(i < j){
                int sum = nums[k] + nums[i] + nums[j];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    i++;
                    j--;
                    while(i < j && nums[i] == nums[i - 1]){
                        i++;
                    }
                    while(i < j && nums[j] == nums[j + 1]){
                        j--;
                    }
                }
                else if(sum < 0){
                    i++;
                }
                else{
                    j--;
                }
            }
        }
        return ans;
    }
}
