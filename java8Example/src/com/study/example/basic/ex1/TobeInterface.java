package com.study.example.basic.ex1;

public interface TobeInterface {
	int age = 20; 		// �������̽��� ����� ������ �⺻������ public static final �� ����

    void getName(); 

    default int getCount(int value) {
        return TobeInterface.age + value;
    } 

    static String getMyName(String name) {
        return "My Name is " + name;
    }
}
