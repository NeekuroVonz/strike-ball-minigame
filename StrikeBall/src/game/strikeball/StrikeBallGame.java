package game.strikeball;

import java.util.Random;
import java.util.Scanner;

public class StrikeBallGame {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random random = new Random();
		
		
		int[] team1 = new int[3];
		int[] team2 = new int[3];
		
		int[] check = new int[9];
		
		for (int i = 0; i < team1.length; i++) {
			int r = random.nextInt(9) + 1;
			
			if (check[r-1] == 0) {
				team1[i] = r;
				check[r-1] = 1;
			} else {
				i--;
			}
		}
		
		System.out.print("Team 1: ");
		for (int i = 0; i < team1.length; i++) {
			System.out.print(team1[i] + " ");
		}
		System.out.println();
		
		while (true) {
			
			int[] check1 = new int[9];
			for (int i = 0; i < team1.length; i++) {
				System.out.print("[" + (i + 1) + "] 1~9 enter: ");
				int data = sc.nextInt();
				
				if (data > 9 || data <= 0) {
					i--;
					continue;
				}
				
				if (check1[data-1] == 0) {
					team2[i] = data;
					check1[data-1] = 1;
				} else {
					System.out.println("(Number repeated)");
					i--;
				}
			}
			
			
			System.out.print("Team 2 = [ ");
			for (int i = 0; i < team2.length; i++) {
				System.out.print(team2[i] + " ");
			}
			System.out.print(" ]");
			System.out.println();
			
			int strike = 0;
			int ball = 0;
			
			for (int i = 0; i < team1.length; i++) {
				for (int j = 0; j < team2.length; j++) {
					if (team1[i] == team2[j]) {
						if (i == j) {
							strike++;
						} else {
							ball++;
						}
					}
				}
			}
			
			System.out.println("Strike (" + strike + ") Ball (" + ball + ")");
			System.out.println();
			
			
			if (strike == 3) {
				System.out.println("Correct");
				System.out.println("Game Over");
				break;
			}
			
		}
	}
	
}
