package com.cg.day1;

public class Prime100 {

	public static void main(String[] args) {
		boolean flag=false;
		for(int i=2;i<=100;i++) {
			flag=false;
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					flag=true;
				}
			}
			if(flag==false)
				System.out.print(i+" ");
		}
		
	}

}
