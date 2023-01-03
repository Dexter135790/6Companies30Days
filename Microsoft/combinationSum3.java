//Author: Dhiraj Kumar Barela

package Microsoft;

import java.util.ArrayList;
import java.util.List;

public class combinationSum3 {

    //This function finds all the combinations recursively and puts in result array
    public static void combinationSum3(int start,int k, int n,List<Integer> prefix, List<List<Integer>> result) {
        if(n==0 &&  prefix.size()==k){              //If combination is found
            result.add(new ArrayList<>(prefix));
        }
        for(int i=start;i<=9;i++){          //Try all possible combination form 1-9
            prefix.add(i);
            combinationSum3(i+1,k, n-i,prefix,result);  //Recursively trying all combinations
            prefix.remove(prefix.size()-1);     //Removing the i  term and trying other numbers
        }

    }

    //Method for forming the result array and calling the function to get the combinations
    public static List<List<Integer>> combinationSum3(int k,int n){
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3(1,k, n, new ArrayList<Integer>(), result);
        return result;
    }

    //Main function for calling the method
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 9));
    }
}
