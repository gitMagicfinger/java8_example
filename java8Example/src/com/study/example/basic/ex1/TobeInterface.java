package com.study.example.basic.ex1;

public interface TobeInterface {
	int age = 20; 		// 인터페이스에 선언된 변수는 기본적으로 public static final 이 선언

    void getName(); 

    default int getCount(int value) {
        return TobeInterface.age + value;
    } 

    static String getMyName(String name) {
        return "My Name is " + name;
    }
}
