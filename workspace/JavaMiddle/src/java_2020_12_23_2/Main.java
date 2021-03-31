package java_2020_12_23_2;

import java.util.Random;
import java.util.Scanner;

import javax.activation.CommandMap;

public class Main {
	static int turn=1;
	static String heroName;
	static String monster = "����";
	static int heroHP = 100;
	static int monsterHP = 100;
	static int recoverable = 3;
	static int commandMonster;
	static int commandHero;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		System.out.println("����� �г����� �Է��ϼ��� : ");
		heroName = sc.next();
		if(heroName.equals(null)) {
			System.out.println("�̸��� �Էµ��� �ʾҽ��ϴ�.\n������ �����մϴ�."); return;
		}
		System.out.println("�����Ǿ����ϴ�.");
		System.out.println("�߻��� " + monster + "�� ��Ÿ����!!");
		boolean dead = true;
		while(dead) {
			Menu();
			System.out.print("������ �ұ��? : ");
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
				System.out.println("������ ����Ǿ����ϴ�.");
				if(heroHP <= 0) System.out.println(heroName + "�� �й�....");
				else System.out.println(heroName + "�� �¸�!");
				dead = false;
			}
			for(int i=0; i<4; i++) System.out.println();
		}
	}
	public static void attack(String attacker) {
		if(attacker.equals(heroName)) {
			System.out.println(heroName + "�� ����!");
			if(commandMonster == 2 || commandMonster == 3) System.out.println("������ " + monster + "�� ������ ����ߴ�!");
			else{
				System.out.println(monster + "���� 20�� �������� ������!");
				monsterHP -= 20;
			}
		}
		if(attacker.equals(monster)) {
			System.out.println(monster + "�� ����!");
			if(commandHero == 2 || commandHero == 3){
				System.out.println("������ " + heroName + "��(��) ������ ����ߴ�!"); 
			}
			else {
				System.out.println(heroName + "��(��) 10�� �������� �Ծ���!");
				heroHP -= 10;
			}
			
		}
	}
	public static void defence(String defencer) {
		if(defencer.equals(heroName)) {
			System.out.println(heroName + "�� ���!");
			System.out.println(heroName + "��(��) ��� �¼��� ����!");
		}
		if(defencer.equals(monster)) {
			System.out.println(monster + "�� ���!");
			System.out.println(monster + "�� ��� �¼��� ����!");
		}
	}
	public static void recovery(String Recoverer) {
		if(Recoverer.equals(heroName)) {
			System.out.println(heroName + "��(��) ȸ�� �ֹ��� ����ߴ�!");
			if(recoverable <=0) System.out.println("ȸ�� ���� Ƚ���� ��� �����Ǿ����ϴ�.");
			else{
				heroHP += 15;
				if(heroHP > 100) heroHP = 100;
				System.out.println(heroName + "�� ü���� ȸ���Ǿ���.");
				recoverable--;
			}
			
		}
		if(Recoverer.equals(monster)) {
			System.out.println(monster + "�� ȸ�� �ֹ��� ����ߴ�!");
			if(monsterHP > 50) {
				System.out.println("HP�� ���� ȸ���� �� �����ϴ�.");
			} else {
				monsterHP += 15;
				if(monsterHP > 100) monsterHP = 100;
				System.out.println(monster + "�� ü���� ȸ���Ǿ���.");
			}	
		}
	}
	public static void Menu() {
		System.out.println("----------------------------");
		System.out.println("���� �� �� : " + turn);
		System.out.println("***" + heroName + "�� ü�� : " + heroHP + "***");
		System.out.println("***" + monster + "�� ü�� : " + monsterHP + "***");
		System.out.println("*** ���� ȸ�� ���� Ƚ�� : " + recoverable + "***");
		System.out.println("----------------------------");
		System.out.println("1.�����Ѵ�		2.����Ѵ�		3.ȸ���Ѵ�");
		System.out.println("----------------------------");
		turn++;
	}
}
