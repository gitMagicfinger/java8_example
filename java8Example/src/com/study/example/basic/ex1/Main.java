package com.study.example.basic.ex1;

public class Main {

	public static void main(String[] args) {
		System.out.println("My Age is " + new ToBeImplementsClass().getCount(10));

		System.out.println(TobeInterface.getMyName("Hong Gil Dong"));
	}

}

class ToBeImplementsClass implements TobeInterface, TobeInterface2 {
	@Override
	public void getName() {
		System.out.println("My name is Default");
	}

	@Override
	public int getCount(int value) {
		return TobeInterface.super.getCount(value);
	}
}