package study.base;

import java.io.InputStream;
import java.util.ArrayList;

public class Swap {
	public static void main(String[] args) {
	    int num1 = 10;
	    int num2 = 20;

	    swap(num1, num2);

	    System.out.println("num1 = " + num1);
	    System.out.println("num2 = " + num2);
	    swap1(num1, num2);
	    System.out.println("num1 = " + num1);
	    System.out.println("num2 = " + num2);
	    ArrayList list = new ArrayList();
	    System.out.println(list.hashCode());
	}

	public static void swap(int a, int b) {
	    int temp = a;
	    a = b;
	    b = temp;

	    System.out.println("a = " + a);
	    System.out.println("b = " + b);
	}
	public static void swap1(int a, int b) {
		ArrayList list = new ArrayList();
	    a = 66;
	    b = 88;
	}
}
