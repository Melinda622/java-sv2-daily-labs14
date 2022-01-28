package day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class StreetManager {

    Map<String, List<Integer>> soldHouses = new TreeMap<>();

    public List<String> read(Path path) {
        List<String> output = new ArrayList<>();
        try {
            output = Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalArgumentException("No file found");
        }
        return output;
    }

    public Map<String, List<Integer>> changeString(Path path) {

        Map<String, List<Integer>> temporary = new TreeMap<>();
        List<Integer> numbersKossuth = new ArrayList<>();
        List<Integer> numbersPetofi = new ArrayList<>();

        String[] temp;

        String streetKossuth="";
        String streetPetofi="";


        for (int i = 0; i < read(path).size(); i++) {
            temp = read(path).get(i).split(" ");

            if (temp[0].trim().equals("Kossuth")) {
                streetKossuth = temp[0];
                numbersKossuth.add(Integer.parseInt(temp[1]));
            } else if (temp[0].trim().equals("Petofi")) {
                streetPetofi = temp[0];
                numbersPetofi.add(Integer.parseInt(temp[1]));
            }
            temporary.clear();
            temporary.put(streetKossuth, numbersKossuth);
            temporary.put(streetPetofi, numbersPetofi);

        }
        return temporary;
    }

   public Map<String, List<Integer>> transform(Path path){
       List<Integer>numberKossuth= changeString(path).get("Kossuth");

       numberKossuth=changeHouseNumbers(numberKossuth);

       List<Integer>numberPetofi= changeString(path).get("Petofi");
       numberPetofi=changeHouseNumbers(numberPetofi);

       for (String s: changeString(path).keySet()) {

           if(s.equals("Kossuth")){
               soldHouses.put(s,numberKossuth);
           }else{
               soldHouses.put(s,numberPetofi);
           }
       }return soldHouses;
    }


    public List<Integer> changeHouseNumbers(List<Integer> input){

        int a=2;
        int b=1;

        for (int i = 0; i <input.size() ; i++) {
            int test=input.get(i);
            if(test==0){
                input.set(i,a);
                a+=2;
            }else{
                input.set(i,b);
                b+=2;
            }
        }return input;
    }
}
