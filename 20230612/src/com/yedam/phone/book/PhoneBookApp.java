package com.yedam.phone.book;

// PhoneInfo: 이름, 연락처.
// PhoneCompanyInfo : 회사 정보.
// PhoneUnivInfo: 학교포함.
// PhoneBookManger: 기능포함.
// 예외사항: MenuChoiceException, 메뉴: INIT_MENU, INPUT_SELECT
// 메뉴출력: MenuViewer
// 
public class PhoneBookApp {
	public static void main(String[] args) {
		PhoneBookManager app = PhoneBookManager.getInstance();
		UserCheck user = new UserCheck();
		int menu;

		// id, pass : id와 passwd를 입력하세요.
		// UserCheck.longinCheck(id, pw);
		while (true) {
			System.out.println("id와 passw를 입력 >");
			System.out.println("(ex)user1 1111");
			String val = MenuViewer.scn.nextLine();
			String[] record = val.split(" ");
			if (user.loginCheck(record[0], record[1])) {
				break;
			}
		}

		// 프로그램 시작.
		while (true) {
			try {
				MenuViewer.showMenu();
				menu = MenuViewer.scn.nextInt();
				MenuViewer.scn.nextLine();

				if (menu < INIT_MENU.INPUT || menu > INIT_MENU.EXIT) {
					throw new MenuChoiceException(menu);
				}

				switch (menu) {
				case INIT_MENU.INPUT:
					app.inputData();
					break;
				case INIT_MENU.SEARCH:
					app.searchData();
					break;
				case INIT_MENU.DELETE:
					app.deleteData();
					break;
				case INIT_MENU.EXIT:
					app.storeToFile();
					app.storeToStream();
					return;
				}
			} catch (MenuChoiceException e) {
				e.showWrongChoice();
			}

		}

	}
}
