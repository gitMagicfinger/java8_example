package com.study.example.optional;

import java.util.Optional;

import com.study.example.optional.vo.Address;
import com.study.example.optional.vo.Member;
import com.study.example.optional.vo.Order;

public class Main02 {

	public static void main(String[] args) {
		Main02 main = new Main02();
		Order order = new Order();
		
		System.out.println("1. " + main.getCityOfMemberFromOrder1(order));
		System.out.println("2. " + main.getCityOfMemberFromOrder2(order));
		System.out.println("3. " + main.getCityOfMemberFromOrder3(order));
	}
	
	public String getCityOfMemberFromOrder1(Order order) {
		if (order != null) {
			Member member = order.getMember();
			if (member != null) {
				Address address = member.getAddress();
				if (address != null) {
					String city = address.getCity();
					if (city != null) {
						return city;
					}
				}
			}
		}
		return "Seoul"; // default
	}
	
	public String getCityOfMemberFromOrder2(Order order) {
		if (order == null) {
			return "Seoul";
		}
		Member member = order.getMember();
		if (member == null) {
			return "Seoul";
		}
		Address address = member.getAddress();
		if (address == null) {
			return "Seoul";
		}
		String city = address.getCity();
		if (city == null) {
			return "Seoul";
		}
		return city;
	}
	
	/* 주문을 한 회원이 살고 있는 도시를 반환한다 */
	public String getCityOfMemberFromOrder3(Order order) {
		return Optional.ofNullable(order)
				.map(Order::getMember)
				.map(Member::getAddress)
				.map(Address::getCity)
				.orElse("Seoul");
	}

}
