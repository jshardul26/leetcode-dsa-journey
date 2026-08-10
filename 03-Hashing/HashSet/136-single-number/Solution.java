
class Solution {
    public int singleNumber(int[] nums) {
    //    int res =0;
    //    for(int n : nums){
    //     res ^= n ;
    //    }    
    //    return res ;    

    HashSet <Integer> set = new HashSet<>();
    for(int i =0; i< nums.length;i++){
        if(set.contains(nums[i])){
            set.remove(nums[i]);
        }else{

        set.add(nums[i]);
        }
    }
    return set.iterator().next();
    }
}
