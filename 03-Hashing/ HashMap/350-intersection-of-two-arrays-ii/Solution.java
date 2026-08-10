class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int n = nums1.length;
        int m = nums2.length;
        
        for(int i =0;i<n;i++){
            map.put(nums1[i],map.getOrDefault(nums1[i],0)+1);
        }
        List <Integer> result = new ArrayList<>();

        for(int i =0;i<m;i++){
            if(map.containsKey(nums2[i])&& map.get(nums2[i])>0){
                result.add(nums2[i]);
                map.put(nums2[i],map.get(nums2[i])-1);
                
            }
        }
        int arr[] = new int[result.size()];
        for(int i =0;i<result.size();i++){
            arr[i]=result.get(i);
        }
        return arr;
    }
}
