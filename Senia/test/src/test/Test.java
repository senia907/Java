package test;

import java.util.BitSet;

public class Test {
	public static void main(String[] args) {
		//Demo demo = new Demo();
		//demo.run();
		BitSet bs = new BitSet(8);
		//bs.set(0, 1);
		//bs.set(1, 1);
		//bs.set(2, 3);
		BitSet shifted = new BitSet(8);
		bs.set(9);
		//bs.set(2);
		//bs.set(3);
		bs.set(0);
		bs.set(3);
		bs.set(4);
		bs.set(8, false);
		bs.set(3, true);
		bs.set(6);
		bs.set(8);
		bs.set(11, false);
		System.out.println("BS");
		for(int i=0;i<bs.length();i++){
			System.out.println(i+": "+bs.get(i));
		}
		shifted.set(9);
		//shifted.set(1, bs.get(0));
		for(int i=0;i<bs.length();i++){	//Moves left
			if(bs.get(i)==true){
				shifted.set((++i));
				--i;
			}		
		}
		System.out.println("SHIFTED:");
		for(int i=0;i<shifted.length();i++){
			System.out.println(i+": "+shifted.get(i));
		}
		System.out.println("KIK"+bs.get(4));
		


		System.out.println("SENIA");
		System.out.println(bs);
		System.out.println(shifted);
	}
}
