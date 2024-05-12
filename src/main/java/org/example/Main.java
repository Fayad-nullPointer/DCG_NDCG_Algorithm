package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer,Integer> h=new HashMap<>();
        HashMap<Integer,Integer> h2;
        double sum1=0.0;
        double sum2=0.0;
        ArrayList<Double>DG=new ArrayList<>();
        ArrayList<Double>DG2=new ArrayList<>();
        System.out.println("Enter number of Doxs");
        Scanner sc=new Scanner(System.in);
        int Doxs_number=sc.nextInt();
        System.out.println("Enter Doxs & Gain");
        int k,g;
        for (int i = 0; i <Doxs_number ; i++) {
            k= sc.nextInt();
            g= sc.nextInt();
            h.put(k,g);
            double x=g/(Math.log(k)/Math.log(2));
            if(k==1){
                DG.add((double) g);
                sum1+=(double) g;
            }
            else{
                DG.add(x);
                sum1+=x;
            }
        }


        System.out.println(h);
        System.out.println(DG);
       h2= (HashMap<Integer, Integer>) (sort(h));
        System.out.println(h2);

        double u=0.0;
        for (int i = 1; i <= h2.size() ; i++) {
            if(i==1){
                u=h2.get(i);
                DG2.add(u);
                sum2+=u;
            }
            else{
                u=h2.get(i)/(Math.log(i)/Math.log(2));
                DG2.add(u);
                sum2+=u;

            }

        }
        System.out.println(DG2);
        System.out.println("nDCG Measure ="+" "+sum1/sum2);







    }

    public static HashMap<Integer, Integer> sort(HashMap<Integer, Integer> map) {
//        int big;
//        int x;
        for (int i = 1; i <= map.size(); i++) {
//           big = map.get(i);
            for (int j = 2; j <= map.size(); j++) {

                swap(map, i, j);



            }

        }
        return map;
    }

    public static void swap(HashMap<Integer,Integer>map,int x,int y){
        if((x<y)&&(map.get(y)>map.get(x))){
            int tmp=map.get(x);
            map.replace(x, map.get(y));
            map.replace(y, tmp);

        }

    }


}