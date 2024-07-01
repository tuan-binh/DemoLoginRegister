package presentation;

import business.constants.RoleName;
import business.entity.Users;
import business.feature.IUserFeature;
import business.feature.impl.UserFeatureImpl;

import java.util.Scanner;

public class MainMenu {
	
	static IUserFeature userFeature = new UserFeatureImpl();
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("=================== MENU ===================");
			System.out.println("1. Đăng nhập");
			System.out.println("2. Đăng ký");
			System.out.println("3. Thoát");
			System.out.println("============================================");
			System.out.println("Lựa chọn của bạn: ");
			int choice = inputNumber(scanner);
			switch (choice) {
				case 1:
					handleLogin(scanner);
					break;
				case 2:
					handleRegister(scanner);
					break;
				case 3:
					System.exit(0);
					break;
				default:
					System.err.println("Vui lòng nhập lại từ 1 -> 3");
			}
		} while (true);
	}
	
	public static void handleRegister(Scanner scanner) {
		System.out.println("Nhập vào họ và tên: ");
		String fullName = scanner.nextLine();
		System.out.println("NHập vào email: ");
		String email = scanner.nextLine();
		System.out.println("Nhập vào password: ");
		String password = scanner.nextLine();
		userFeature.register(fullName, email, password);
		System.out.println("Đăng ký thành công");
	}
	
	public static void handleLogin(Scanner scanner) {
		System.out.println("Nhập vào email: ");
		String email = scanner.nextLine();
		System.out.println("Nhập vào password: ");
		String password = scanner.nextLine();
		Users user = userFeature.login(email, password);
		if (user == null) {
			System.err.println("Email và password không đúng");
			return;
		}
		// check quyền
		if (user.getRoleName().equals(RoleName.ROLE_ADMIN)) {
			// điều hướng đến menu admin
			MenuAdmin menuAdmin = new MenuAdmin();
			menuAdmin.menu(scanner);
		} else if (user.getRoleName().equals(RoleName.ROLE_MODERATOR)) {
			// điều hướng đến menu moderator
		} else {
			// điều hướng đến menu user
			MenuUsers menuUsers = new MenuUsers();
			menuUsers.menu(scanner);
		}
	}
	
	public static int inputNumber(Scanner scanner) {
		do {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.err.println("Vui lòng nhập lại số: ");
			}
		} while (true);
	}
}
