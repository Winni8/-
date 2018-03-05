package com.selenium2;

public class Teststring {
  public static void main(String[] args) {
   String s ="$12.56";
   String s1="$12.56 USD";
   String s2=s+" USD";
   
   System.out.println(s1);
   System.out.println(s2);
   if(s1.equals(s2) ){
	   System.out.println("ok");
   }else{
	   System.out.println("no");
   }
   
  		}
}
