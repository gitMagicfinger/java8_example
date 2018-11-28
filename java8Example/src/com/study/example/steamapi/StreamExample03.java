package com.study.example.steamapi;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class StreamExample03 {

	public static void main(String[] args) {
		// ############################################################################
		final List<Product> products = 
			Arrays.asList(
				new Product(1L, "A", 100.50f),
				new Product(2L, "B", 23.00f),
				new Product(3L, "C", 31.45f),
				new Product(4L, "D", 80.20f),
				new Product(5L, "E", 7.50f)
			);
		
		final OrderedItem item1 = new OrderedItem(1L, products.get(0), 1);
		final OrderedItem item2 = new OrderedItem(2L, products.get(2), 3);
		final OrderedItem item3 = new OrderedItem(3L, products.get(4), 10);
		
		final Order order = new Order(1L, Arrays.asList(item1, item2, item3));
		
		System.out.println("\n########################################################");
		System.out.println("Products : \n" +
				products.stream()
						.map( product -> product.toString() )
						.collect(joining("\n"))
		);
		
		System.out.println("\n########################################################");
		System.out.println("Products.price >= 30 : \n" +
			products.stream()
					.filter( product -> product.getPrice() > 30 )
					.collect(toList())
		);
		
		System.out.println("\n########################################################");
		System.out.println("Products.price >= 30 (with joining(\\n)) : \n" +
				products.stream()
						.filter( product -> product.getPrice() > 30 )
						.map( product -> product.toString() )
						.collect(joining("\n"))
		);
		
		
		
		System.out.println("\n########################################################");
		System.out.println("IntStream.sum : " + 
				IntStream.of(1,2,3,4,5,6,7,8,9,10)
				 		 .sum()
		);
		
		System.out.println("\n########################################################");
		System.out.println("Total Price : " +
				products.stream()
						.map( product -> product.getPrice())
						.reduce(0f, (price1, price2) -> price1 + price2)
		);
		
		System.out.println("\n########################################################");
		System.out.println("Total Price (price >= 30): " +
				products.stream()
						.filter( product -> product.getPrice() > 30 )
						.map( product -> product.getPrice())
						.reduce(0f, (price1, price2) -> price1 + price2)
		);
		
		System.out.println("\n########################################################");
		System.out.println("Total Count (price >= 30): " +
				products.stream()
						.filter( product -> product.getPrice() > 30 )
						.count()
		);
		
		
		System.out.println("\n########################################################");
		System.out.println("Total Count (price >= 30): " +
				products.stream()
						.filter( product -> product.getPrice() > 30 )
						.count()
		);
		
		System.out.println("\n########################################################");
		System.out.println("Order.totalPrice() : " + order.totalPrice());
	}

}

@AllArgsConstructor
@Data
class Product {
	private Long id;
	private String name;
	private float price;
}

@AllArgsConstructor
@Data
class OrderedItem {
	private Long id;
	private Product product;
	private int quantity;
	
	public float getTotalPrice() {
		return product.getPrice() * quantity;
	}
}

@AllArgsConstructor
@Data
class Order {
	private Long id;
	private List<OrderedItem> items;
	
	public float totalPrice() {
		return items.stream()
					.map( item -> item.getTotalPrice())
					.reduce(0f, (price1, price2) -> price1 + price2);
	}
}