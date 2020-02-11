package main;

import chap06.ExeTimeCalculator;
import chap06.ImplCalculator;
import chap06.RecCalculator;

public class MainProxy {
	public static void main(String[] args) {
		ExeTimeCalculator ttcal1 = new ExeTimeCalculator(new ImplCalculator());
		System.out.println(ttcal1.factorial(20));

		ExeTimeCalculator ttcal2 = new ExeTimeCalculator(new RecCalculator());
		System.out.println(ttcal2.factorial(20));
	}
}
