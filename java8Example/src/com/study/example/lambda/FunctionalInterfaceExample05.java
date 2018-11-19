package com.study.example.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;
import lombok.Data;

public class FunctionalInterfaceExample05 {
	public static void main(String[] args) {
		final List<Product> products = Arrays.asList(
			new Product(1L, "A", 10.00f),
			new Product(2L, "B", 50.50f),
			new Product(3L, "C", 17.45f),
			new Product(4L, "D", 20.00f),
			new Product(5L, "E", 110.99f)
		);
		
		//############################################################################
		List<Product> result = new ArrayList<Product>();
		for(Product product : products) {
			if ( product.getPrice() >= 20) {
				result.add(product);
			}
		}		
		System.out.println("products (20 이상) : " + result);
		
		//############################################################################
		// 20보다 가격이 높은 상품 추출
		List<Product> result2 = filter(products, product -> product.getPrice() >= 20 );
		System.out.println("products (20 이상) : " + result2);
		
		
		//############################################################################
		// 50보다 가격이 높은 상품 추출
		List<DiscountedProduct> discountProducts = new ArrayList<DiscountedProduct>();
		List<Product> expensiveProducts = filter(products, product -> product.getPrice() >= 50 );
		for(Product product : expensiveProducts) {
			discountProducts.add(new DiscountedProduct(product.getId(), product.getName(), product.getPrice()));
		}		
		System.out.println("expensive products (50 이상) : " + expensiveProducts);
		
		
		//############################################################################
		// 50보다 가격이 높은 상품 추출 후 50% 할인 적용
		List<DiscountedProduct> discountProducts2 = 
				map(expensiveProducts, product -> new DiscountedProduct(product.getId(), product.getName(), (product.getPrice() * 0.5f)));
		
		System.out.println("discount products (50 이상 50% 할인) : " + discountProducts2);
		
		final Predicate<Product> lessThanOrEqualTo30 = product -> product.getPrice() <= 30;
		System.out.println("discount products (50%할인 후 30 이하) : " + filter(discountProducts2, lessThanOrEqualTo30));
		System.out.println("discount products (50%할인 후 30 이하) : " + filter(products, lessThanOrEqualTo30));
		
		
		
		//############################################################################
		List<Float> prices = map(products, product -> product.getPrice());
		float total = 0.0f;
		for(float price : prices) {
			total += price;
		}
		System.out.println("Total : " + total);
		System.out.println("Total : " + total(products, product -> product.getPrice()));
		
	}
	
	private static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
		List<T> result = new ArrayList<T>();
		for(T info : list) {
			if ( predicate.test(info) ) {
				result.add(info);
			}
		}	
		return result;
	}
	
	private static <T,R> List<R> map(List<T> list, Function<T,R> function) {
		List<R> result = new ArrayList<R>();
		for(T t : list) {
			result.add(function.apply(t));
		}		
		return result;
	}
	
	private static <T> float total(List<T> list, Function<T,Float> mapper) {
		float total = 0.0f;
		for(T t : list) {
			total += mapper.apply(t);
		}		
		return total;
	}
	
}

@AllArgsConstructor
@Data
class Product {
	private Long id;
	private String name;
	private float price;
}

class DiscountedProduct extends Product{
	public DiscountedProduct(Long id, String name, float price) {
		super(id, name, price);
	}
}