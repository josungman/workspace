package myGameProjcet;

import java.util.Scanner;

public class RPG {

	// 캐릭터 참조변수
	static Hero User = null;
	// 몬스터
	static Monster GameMonster = null;

	// 계정 (클래스 인스턴스 생성할때 앞에 이미 형식을 지정한상태라 메서드 안에서 클래스 변수를 붙이지 마라.)
	static String ID;
	static String PW;
	static boolean run;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		// 게임 실행 page1으로 이동
		run = true;
		page1();

	}

	static void page1() {// 페이지1(첫 시작)

		while (run) {

			System.out.println("==============RPG=============");
			System.out.println("1.새로시작 | 2.불러오기 3.종료");
			System.out.println("==============================");

			System.out.print("선택>>");
			int input = scan.nextInt();

			switch (input) {
			case 1:
				// 새로시작시 page2로 넘어가기
				run = false;
				page2();
				break;
			case 2:
				// 새로시작시 page3로 넘어가기

				break;
			case 3:
				// 프로그램 종료
				System.out.println("프로그램이 종료 되었습니다.");
				System.exit(0);
			}

		}

	}

	static void page2() {// 페이지2(영웅선택 및 회원가입)
		run = true;

		while (run) {
			System.out.println("=====first Page====");
			System.out.println("1.영웅선택 | 2.종료");
			System.out.println("===================");
			System.out.print("선택>>");
			int input = scan.nextInt();

			switch (input) {
			case 1:
				System.out.println("==========Hero==========");
				System.out.println("1.전사 | 2.법사 | 3.도적");
				System.out.println("========================");

				System.out.print("선택>>");
				int input2 = scan.nextInt();

				// 영웅 객체 (클래스 참조변수로 가져옴)
				if (input2 == 1) {
					User = new Warrior();
				} else if (input2 == 2) {
					User = new Wizard();
				} else if (input2 == 3) {
					User = new thief();
				}

				System.out.println(User.getName());
				System.out.println("영웅이 선택되었습니다.");

				// 파일 읽어오기를 통한 ID 비번 저장
				System.out.print("ID입력>>");
				ID = scan.next();

				System.out.print("비번입력>>");
				PW = scan.next();

				System.out.println("캐릭터가 정상적으로 만들어졌습니다.");

				run = false;
				GamePage();
				break;

			case 2:
				// 프로그램 종료
				System.out.println("프로그램이 종료 되었습니다.");
				System.exit(0);
			}

		}

	}

	static void GamePage() {// 게임실행페이지
		run = true;
		while (run) {
			System.out.println("=====================Town=========================");
			System.out.println("1.영웅정보 | 2.던전탐험 | 3.상점 | 4.저장 | 5.종료");
			System.out.println("==================================================");
			System.out.print("선택>>");
			int input = scan.nextInt();

			switch (input) {
			case 1:
				// 영웅 정보 구현
				System.out.println("======" + ID + "======");
				System.out.println("직업 : " + User.getName());
				System.out.println("빠워 : " + User.getPower());
				System.out.println("지능 : " + User.getIntt());
				System.out.println("민첩 : " + User.getDex());
				System.out.println("자산 : " + User.getMoney() + " 원");

				break;
			case 2:
				// 던전으로 이동 (던전 페이지 구현)
				run = false;
				DungeonPage();
				break;
			case 3:
				run = false;
				shop();
				// 상점 구현
				break;
			case 4:
				// 저장 기능 구현
				break;
			case 5:
				System.out.println("프로그램이 종료 되었습니다.");
				System.exit(0);
				break;
			}

		}

	}

	static void shop() {// 상점
		run = true;

		while (run) {
			System.out.println("==============shop==============");
			System.out.println("1.물건사기 | 2.뒤로가기 | 3.종료");
			System.out.println("================================");
			System.out.print("선택>>");
			int input = scan.nextInt();

			switch (input) {

			case 1: // 물건사기

				System.out.println("======================weapon_Test====================");
				System.out.println("1.버서커검 | 2.간달프지팡이 | 3.최강아대 | 4.뒤로가기");
				System.out.println("===W100===========w100===========w100================");
				System.out.println("=====================================================");

				System.out.print("선택>>");
				int input2 = scan.nextInt();

				switch (input2) {
				case 1: // 전사 전용 무기 구현

					if (User.getName() == "전사") {

						// 무기 살돈이 있는지 확인
						if (User.getMoney() >= 100) {
							// 무기 구매시 힘 증가 표시
							int accpower = User.getPower();
							accpower += 10;
							System.out.println("힘이 +10 증가 하였습니다.");
							User.setPower(accpower);
							System.out.println("힘 능력치 : " + User.getPower());

							// 무기를 샀을때 돈 감소
							int money = User.getMoney();
							money -= 100;
							User.setMoney(money);

							System.out.println("남은 자산은 : " + User.getMoney());

						} else {
							System.out.println("무기를 살 돈이 없습니다.");
						}

					} else {
						System.out.println("전용 무기가 아닙니다.");
					}

					break;
				case 2: // 마법사 전용 무기 구현

					if (User.getName() == "마법사") {

						// 무기 살돈이 있는지 확인
						if (User.getMoney() >= 100) {
							// 무기 구매시 힘 증가 표시
							int accpower = User.getIntt();
							accpower += 10;
							System.out.println("지능이 +10 증가 하였습니다.");
							User.setIntt(accpower);
							System.out.println("지능 능력치 : " + User.getIntt());

							// 무기를 샀을때 돈 감소
							int money = User.getMoney();
							money -= 100;
							User.setMoney(money);

							System.out.println("남은 자산은 : " + User.getMoney());

						} else {
							System.out.println("무기를 살 돈이 없습니다.");
						}

					} else {
						System.out.println("전용 무기가 아닙니다.");
					}

					break;
				case 3: // 도적 전용 무기 구현

					if (User.getName() == "도적") {

						// 무기 살돈이 있는지 확인
						if (User.getMoney() >= 100) {
							// 무기 구매시 힘 증가 표시
							int accpower = User.getDex();
							accpower += 10;
							System.out.println("민첩이 +10 증가 하였습니다.");
							User.setDex(accpower);
							System.out.println("민첩 능력치 : " + User.getDex());

							// 무기를 샀을때 돈 감소
							int money = User.getMoney();
							money -= 100;
							User.setMoney(money);

							System.out.println("남은 자산은 : " + User.getMoney());

						} else {
							System.out.println("무기를 살 돈이 없습니다.");
						}

					} else {
						System.out.println("전용 무기가 아닙니다.");
					}

					break;
				case 4: // 뒤로가기
					shop();
					run = false;
					break;
				}

				break;

			case 2:// 뒤로가기
				GamePage();
				break;
			case 3:// 종료
				System.out.println("프로그램이 종료 되었습니다.");
				System.exit(0);
				break;

			}
		}

	}

	static void DungeonPage() {// 던전페이지
		run = true;

		while (run) {
			System.out.println("====================던전=======================");
			System.out.println("1.동굴 | 2.심해 | 3.정글 | 4.뒤로가기 | 5.종료");
			System.out.println("===============================================");
			System.out.print("선택>>");
			int input = scan.nextInt();

			switch (input) {
			case 1: // 던전 공격 화면 구현
				run = false;
				Attack(1);
				break;

			case 2:// 던전 공격 화면 구현
				run = false;
				Attack(2);
				break;
			case 3:// 던전 공격 화면 구현
				run = false;
				Attack(3);
				break;
			case 4:
				GamePage();
				break;
			case 5:
				System.out.println("프로그램이 종료 되었습니다.");
				System.exit(0);
			}

		}

	}

	static void Attack(int location) { // 공격 화면
		// 입장 알림

		String disp = null;
		switch (location) {
		case 1:
			disp = "동굴";
			break;

		case 2:
			disp = "심해";
			break;
		case 3:
			disp = "정글";
			break;
		}

		System.out.println("===============================================");
		System.out.println("===============================================");
		System.out.println("===============================================");
		System.out.println("=======================" + disp + "======================");
		System.out.println("===============================================");
		System.out.println("===============================================");
		System.out.println("===============================================");

		System.out.println();
		System.out.println();
		run = true;

		// 몬스터 구현(던전에 따라 다르게)
		//박쥐 몬스터로 Test
		GameMonster = new Bat();
		
		while (run) {
			
			GameMonster.getAttackname();
			
			//몬스터 정보 및 공격 출력
			System.out.println(GameMonster.getName() + "이(가) 공격을 하였다. " + GameMonster.getAttackname() + "(" + GameMonster.getAttacknum() + ")" );
			System.out.println(GameMonster.getName() + "채력 : " + GameMonster.getHP() );
			
			System.out.println();
			
			
			// 몬스터 가 유저한테 공격 하는 소스 코드
			int UserHP = User.getHP();
			UserHP -= GameMonster.getAttacknum(); //몬스터 공격
			User.setHP(UserHP);
			
			System.out.println(User.getName() + "의 HP가 " + "(" + GameMonster.getAttacknum() + ") 감소 하였다. 잔여 HP : " + User.getHP() );

			System.out.println();
			
			System.out.println("=============공격화면===========");
			System.out.println("1.공격 | 2.특수공격 | 3.도망치기");
			System.out.println("HP:" + User.getHP());
			System.out.print("선택>>");
			int input = scan.nextInt();

			switch (input) {
			case 1: // 공격 구현 (직업별 능력치로 공격)
				User.Attach();
			
				int MonsterHP = GameMonster.getHP();
				
				if(User.getName() == "전사") {
					
					MonsterHP -= User.getPower();
					
					
				} else if(User.getName() == "마법사") {
					
					MonsterHP -= User.getIntt();
					
				}else if(User.getName() == "도적"){
					
					MonsterHP -= User.getDex();
					
				}
			
				
				//몬스터한테 타격 입히기
				GameMonster.setHP(MonsterHP);
				System.out.println(GameMonster.getName() + "한테 타격을 입혔다.");
				System.out.println(GameMonster.getName() + "채력 : " + GameMonster.getHP());
				
				System.out.println();
				
				
				// 몬스터 가 유저한테 공격 하는 소스 코드
					
				
				
				
				
				
				
				break;
			case 2: // 특수공격 구현

				break;
			case 3:
			    System.out.println("성공적으로 도망쳤다.");
				run = false;
				DungeonPage();
				break;

			}
		}
	}
}
