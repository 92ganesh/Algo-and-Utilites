package Algorithms;

import java.io.*;
import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.Math;
import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class KMPAlgo {

    public static <T> void printTemplate(T element){
        System.out.println(element);
    }

    public static void pf(Object ob){
        System.out.print(ob);
    }

    public static void pfn(Object ob){
        System.out.println(ob);
    }

    private int powerFun(int x,int y){
        if(y==0){
            return 1;
        }
        else if(x==0){
            return 0;
        }
        else{
            if(y%2==0){
                return powerFun(x,(y/2));
            }
            else{
                if(y>0){
                    return x*powerFun(x,(y/2))*powerFun(x,(y/2));
                }
                else{
                    return (powerFun(x,(y/2))*powerFun(x,(y/2)))/x;
                }
            }
        }

    }
    public void KMP(String text, String pat){
        int patLen=pat.length(),i=0,j=0;
        int textLen=text.length();
        int[] lpsArr;
        lpsArr=LPS(pat);
        while(i<textLen){
            if(text.charAt(i)==pat.charAt(j)){
                 i++;
                 j++;
            }
            if(j==patLen) {
                printTemplate("pattern found at:"+(i-j));
                j=lpsArr[j-1];
            }
            else if((i<textLen) && (text.charAt(i)!=pat.charAt(j))) {
                if(j==0){
                    i++;
                }
                else{
                    j=lpsArr[j-1];
                }
            }
        }
    }

    int[] LPS(String pat){
        int patLen=pat.length(),len=0;
        int[] lpsArr=new int[patLen];
        lpsArr[0]=0;
        int i=1;
        while(i<patLen){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lpsArr[i]=len;
                i++;
            }
            else{
                if(len!=0){
                    len=lpsArr[len-1];
                }
                else{
                    lpsArr[i]=len;
                    i++;
                }
            }
        }
        return lpsArr;
    }
//    AABC[0,1,0,0]
//    AABCDEAABC
//    public static void main(String[] args)throws Exception  {
//
//        Scanner sc = new Scanner(System.in);
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String text="THIS IS A TEST TEXT";
//        String pat="TEXT";
//        KMP(text, pat);
//    }
}

