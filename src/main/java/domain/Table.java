package domain;

public class Table {
    private final int number;
    private final Orders orders = new Orders();

    public Table(final String number) {
    	if (number.trim().isEmpty()) {
    		throw new IllegalArgumentException("입력된 값이 없습니다.");
    	}
    	
    	this.number = Integer.parseInt(number);
    }

	@Override
    public String toString() {
        return Integer.toString(number);
    }
	
	public boolean isSame(Table compare) {
		return Integer.toString(number).equals(compare.toString());
	}
	
	public Orders toOrders() {
		return orders;
	}
}
