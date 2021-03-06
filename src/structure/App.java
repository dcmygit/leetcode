package structure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {
        int []test={3,3,0,0,2,3,2};
        List<List<Integer>>list=new App().permute(test);
        System.out.println(list.size()+""+list);
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  result = new ArrayList<List<Integer>>();
        if(nums.length==0||nums==null)
            return result;

        permute(nums,0,nums.length-1,result);
        return result;


    }
    public void permute(int[]nums,int start,int end,List<List<Integer>> result){
        if(start>=end){
            List<Integer> tmp = new ArrayList<Integer>();
            for(int i=0;i<nums.length;i++){
                tmp.add(nums[i]);
            }
            result.add(tmp);
            return ;
        }else{
            for(int i=start; i<=end;i++){
                if(i<end&&(nums[i]==nums[i+1])){
                    continue;
                }
                int tmps = nums[start];
                nums[start] = nums[i];
                nums[i] = tmps;
                permute(nums,start+1,end,result);
                tmps = nums[start];
                nums[start] = nums[i];
                nums[i] = tmps;
            }
        }
    }
}