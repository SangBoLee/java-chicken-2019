package view;

import java.util.Scanner;

import domain.FunctionNumber;
import domain.Menu;
import domain.MenuCount;
import domain.MenuRepository;
import domain.PaymentOption;
import domain.Table;
import domain.TableRepository;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    
    public static FunctionNumber inputFunctionNumber() {
		try {
			System.out.println("## 원하는 기능을 선택하세요.");
			FunctionNumber functionNumber = new FunctionNumber(scanner.nextLine());
			System.out.println();
			return functionNumber;
		} catch (NumberFormatException e) {
			System.out.println("1, 2, 3만 입력 가능합니다.");
			return inputFunctionNumber();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputFunctionNumber();
		}
    }

    public static Table inputTableNumber() {
    	try {
			OutputView.printTables(TableRepository.tables());
			System.out.println("\n## 테이블을 선택하세요.");
			return TableRepository.hasTableNumber(new Table(scanner.nextLine()));
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력 가능합니다.");
			return inputTableNumber();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputTableNumber();
		} 
    }
    
    public static Menu inputMenuNumber() {
 		try {
			System.out.println("## 등록할 메뉴를 선택하세요.");
			return MenuRepository.hasMenu(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력 가능합니다.");
			return inputMenuNumber();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputMenuNumber();
		}
     }
    
    public static MenuCount inputMenuCount() {
    	try {
			System.out.println("\n## 메뉴의 수량을 입력하세요.");
			return new MenuCount(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력 가능합니다.");
			return inputMenuCount();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputMenuCount();
		}
    }
    
    public static PaymentOption inputPaymentOption() {
    	try {
			System.out.println("## 신용카드는 1번, 현금은 2번");
			return new PaymentOption(scanner.nextLine());
 		} catch (NumberFormatException e) {
			System.out.println("1(신용카드), 2(현금) 숫자만 입력 가능합니다.");
			return inputPaymentOption();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return inputPaymentOption();
		}
    }
}
