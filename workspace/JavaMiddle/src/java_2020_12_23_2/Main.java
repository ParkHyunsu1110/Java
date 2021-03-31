package java_2020_12_23_2;

import java.util.Random;
import java.util.Scanner;

import javax.activation.CommandMap;

public class Main {
	static int turn=1;
	static String heroName;
	static String monster = "몬스터";
	static int heroHP = 100;
	static int monsterHP = 100;
	static int recoverable = 3;
	static int commandMonster;
	static int commandHero;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("사용자 닉네임을 입력하세요 : ");
		heroName = sc.next();
		if(heroName.equals(null)) {
			System.out.println("이름이 입력되지 않았습니다.\n게임을 종료합니다."); return;
		}
		System.out.println("설정되었습니다.");
		System.out.println("야생의 " + monster + "가 나타났다!!");
		boolean dead = true;
		while(dead) {
			Menu();
			System.out.print("무엇을 할까요? : ");
			commandHero = sc.nextInt();
			commandMonster = random.nextInt(3) + 1;
			
			for(int i=0; i<4; i++) System.out.println();
			
			if(commandMonster == 2) {
				defence(monster);
				System.out.println();
				switch(commandHero) {
					case 1: attack(heroName); break;
					case 2: defence(heroName); break;
					case 3: recovery(heroName); break;
				}
			} else {
				switch(commandHero) {
					case 1: attack(heroName); break;
					case 2: defence(heroName); break;
					case 3: recovery(heroName); break;
				}
				System.out.println();
				switch(commandMonster) {
					case 1: attack(monster); break;
					case 3: recovery(monster); break;
				}
			}
			
			if(heroHP <= 0 || monsterHP <= 0) {
				System.out.println();
				System.out.println("게임이 종료되었습니다.");
				if(heroHP <= 0) System.out.println(heroName + "의 패배....");
				else System.out.println(heroName + "의 승리!");
				dead = false;
			}
			for(int i=0; i<4; i++) System.out.println();
		}
	}
	public static void attack(String attacker) {
		if(attacker.equals(heroName)) {
			System.out.println(heroName + "의 공격!");
			if(commandMonster == 2 || commandMonster == 3) System.out.println("하지만 " + monster + "는 공격을 방어했다!");
			else{
				System.out.println(monster + "에게 20의 데미지를 입혔다!");
				monsterHP -= 20;
			}
		}
		if(attacker.equals(monster)) {
			System.out.println(monster + "의 공격!");
			if(commandHero == 2 || commandHero == 3){
				System.out.println("하지만 " + heroName + "은(는) 공격을 방어했다!"); 
			}
			else {
				System.out.println(heroName + "은(는) 10의 데미지를 입었다!");
				heroHP -= 10;
			}
			
		}
	}
	public static void defence(String defencer) {
		if(defencer.equals(heroName)) {
			System.out.println(heroName + "의 방어!");
			System.out.println(heroName + "은(는) 방어 태세에 들어갔다!");
		}
		if(defencer.equals(monster)) {
			System.out.println(monster + "의 방어!");
			System.out.println(monster + "는 방어 태세에 들어갔다!");
		}
	}
	public static void recovery(String Recoverer) {
		if(Recoverer.equals(heroName)) {
			System.out.println(heroName + "은(는) 회복 주문을 사용했다!");
			if(recoverable <=0) System.out.println("회복 가능 횟수가 모두 소진되었습니다.");
			else{
				heroHP += 15;
				if(heroHP > 100) heroHP = 100;
				System.out.println(heroName + "의 체력이 회복되었다.");
				recoverable--;
			}
			
		}
		if(Recoverer.equals(monster)) {
			System.out.println(monster + "는 회복 주문을 사용했다!");
			if(monsterHP > 50) {
				System.out.println("HP가 많아 회복할 수 없습니다.");
			} else {
				monsterHP += 15;
				if(monsterHP > 100) monsterHP = 100;
				System.out.println(monster + "의 체력이 회복되었다.");
			}	
		}
	}
	public static void Menu() {
		System.out.println("----------------------------");
		System.out.println("현재 턴 수 : " + turn);
		System.out.println("***" + heroName + "의 체력 : " + heroHP + "***");
		System.out.println("***" + monster + "의 체력 : " + monsterHP + "***");
		System.out.println("*** 남은 회복 가능 횟수 : " + recoverable + "***");
		System.out.println("----------------------------");
		System.out.println("1.공격한다		2.방어한다		3.회복한다");
		System.out.println("----------------------------");
		turn++;
	}
}
