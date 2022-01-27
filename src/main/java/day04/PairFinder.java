package day04;

import java.util.ArrayList;
import java.util.List;

public class PairFinder {

    public int findPairs(int[] arr){
    int countNumbers=0;
    int countPairs=0;
    int sumPairs=0;
    int test=0;
        List<Integer> numbers=new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
            countNumbers=0;
            countPairs=0;

            if(!numbers.contains(arr[i])){
                test=arr[i];
                numbers.add(arr[i]);
            }else{
                test=0;
            }
            System.out.println(test);
            for (int j = 0; j <arr.length ; j++) {
                if(test==arr[j]){
                    countNumbers++;
                }
            }
            if(countNumbers%2==0){
                countPairs=countNumbers/2;
            }else if(countNumbers>1){
                    countPairs=(countNumbers-1)/2;

            }else if(countNumbers==1){
                countNumbers=0;
            }
            sumPairs+=countPairs;
        }

        return sumPairs;
    }
}
