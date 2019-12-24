package domain;

public class MenuCount {
    private final int maximumCount = 99;
    private final int value;
	
    public MenuCount(final String value) {
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
        int menuCount = Integer.parseInt(value);
		
        if (menuCount > maximumCount) {
            throw new IllegalArgumentException("최대 99개까지 주문할 수 있습니다.");
        }
		
        this.value = menuCount;
    }
	
    public MenuCount calculate(MenuCount newOrder) {
        return new MenuCount(String.valueOf(value + newOrder.toInteger()));
    }
	
    public int toInteger() {
        return value;
    }
}
