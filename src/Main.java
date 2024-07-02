import business.constants.RoleName;
import business.entity.Users;
import business.feature.impl.UserFeatureImpl;
import business.utils.IOFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		Users users = new Users();
//		users.setFullName("ADMIN");
//		users.setEmail("admin@gmail.com");
//		users.setPassword("admin");
//		users.setRoleName(RoleName.ROLE_ADMIN);
//		UserFeatureImpl.users.add(users);
//		IOFile.writeToFile(IOFile.PATH_USER, UserFeatureImpl.users);
		Scanner scanner = new Scanner(System.in);
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		int size = 3; // giới hạn
		int totalPage = (int) Math.ceil((double) list.size() / size); // tìm ra số trang
//		System.out.println(totalPage);
		int curr = 0;
		int end = size;
		// [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		do {
			showPagination(curr * size, end, list);
			if (curr != 0) {
				System.out.println("1. Prev");
			}
			if (curr != totalPage - 1) {
				System.out.println("2. Next");
			}
			System.out.println("3. Quay lại");
			
			System.out.println("Lựa chọn: ");
			int choice = Integer.parseInt(scanner.nextLine());
			switch (choice) {
				case 1:
					curr -= 1;
					end = end - size;
					break;
				case 2:
					curr += 1;
					end = end + size;
					break;
				case 3:
					System.exit(0);
					break;
				default:
					System.err.println("Vui lòng nhập lại từ 1 -> 2");
			}
		} while (true);
	}
	
	public static void showPagination(int start, int end, List<Integer> list) {
		for (int i = start; i < end; i++) {
			System.out.println(list.get(i));
		}
	}
}