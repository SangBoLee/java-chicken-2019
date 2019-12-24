package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {
	private final int chickenDiscountCriteria = 10;
	private final int chickenDiscountPrice = 10000;
	private final double cashDiscountRate = 0.95;
	private final List<Order> orderList = new ArrayList<>();
	
	public void addOrder(Order order) {
		if (hasSameMenu(order)) {
			addMenuCount(order);
		}
		if (!hasSameMenu(order)) {
			orderList.add(order);
		}
	}
	
	private boolean hasSameMenu(Order input) {
		return orderList.stream()
				.filter(order -> order.toMenu().toNumber() == input.toMenu().toNumber())
				.findFirst()
				.isPresent();
	}
	
	private void addMenuCount(Order input) {
		Order order;
		
		for (int i = 0; i < orderList.size(); i++) {
			order = orderList.get(i);
			modifyOrder(i, order, input);
		}
	}
	
	private void modifyOrder(int inx, Order order, Order input) {
		if (order.toMenu().toNumber() == input.toMenu().toNumber()) {
			orderList.set(inx, new Order(order.toMenu(), 
					order.toMenuCount().calculate(input.toMenuCount())));
		}
	}
	
	public boolean hasNotOrder() {
		return orderList.isEmpty();
	}
	
	public List<Order> toList() {
		return orderList;
	}
	
	public String toAllPrice(final PaymentOption paymentOption) {
		double allPrice = 0;
		
		for (Order order : orderList) {
			allPrice += order.toOrderPrice();
		}
		
		allPrice = applyChickenDiscount(allPrice);
		allPrice = applyCashDiscount(allPrice, paymentOption);
		return allPrice + "원";
	}
	
	public double applyChickenDiscount(final double allPrice) {
		int discountCount = toChickenCount() / chickenDiscountCriteria;

		return allPrice - (discountCount * chickenDiscountPrice);
	}
	
	public int toChickenCount() {
		return orderList.stream()
					.filter(order -> order.toMenu().toCategory().isChicken())
					.collect(Collectors.summingInt(order -> order.toMenuCount().toInteger()));
	}
	
	public double applyCashDiscount(final double allPrice, final PaymentOption paymentOption) {
		if (paymentOption.isCash()) {
			return allPrice * cashDiscountRate;
		}
		return allPrice;
	}
	
	public void removeOrders() {
		orderList.clear();
	}
}
