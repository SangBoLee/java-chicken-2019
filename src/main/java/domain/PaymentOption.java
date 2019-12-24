package domain;

public class PaymentOption {
    private final int creditCard = 1;
    private final int cash = 2;
    private final int value;
	
    public PaymentOption(final String value) {
        if (value.trim().isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
        int paymentOption = Integer.parseInt(value);
		
        this.value = paymentOption;
        if (this.value != creditCard && this.value != cash) {
            throw new IllegalArgumentException("입력 번호는 1(신용카드), 2(현금)만 가능합니다.");
        }
    }
	
    public boolean isCash() {
        return value == cash;
    }
}
