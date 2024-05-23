package com.marimo.car;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CarTester {
	public static void main(String args[]){
		// 入力を受け取る準備
		Scanner sc = new Scanner(System.in);
		
		String name=null;
		String number = null;
		int width = 0;
		int height = 0;
		int length = 0;
		double tankCapacity = 0;
		double fuel = 0;
		double mileage = 0;
		double locationX = 0;
		double locationY = 0;
		
		// 入力を受け取ります。
		try {
		System.out.println("車のデータを入力せよ。");
		System.out.print("名   前	: ");
		name = sc.next();
		System.out.print("ナンバー	: ");
		number = sc.next();
		System.out.print("車   幅	: ");
		width = sc.nextInt();
		System.out.print("高   さ	: ");
		height = sc.nextInt();
		System.out.print("長   さ	: ");
		length = sc.nextInt();
		System.out.print("タンク容量: ");
		tankCapacity = sc.nextDouble();
		System.out.print("ガソリン量: ");
		fuel = sc.nextDouble();
		System.out.print("燃   費	: ");
		mileage = sc.nextDouble();
		} 
		// 入力のデータ型が合わない場合のため
		catch (InputMismatchException e) {
			System.out.println("いたずらしないでください");
		}
		
		// 入力された値に基づいてCarインスタンスを生成します。
		Car car = new Car(name, number, width, height, length, tankCapacity, fuel, mileage);
		
		// 現在値と残り燃料を見せます
		System.out.println("現在値 : (0.00, 0.00)");
		System.out.print("残り燃料：　" + car.getFuel() + "\n");
		
		// 移動
		int moving = 1;
		while(true) {
			System.out.print("移動しますか？[0・・・No／1・・・Yes]　: ");
			moving = sc.nextInt();
			if(moving != 1) {
				if(moving == 0) break;
				else {
					System.out.println("0または１を入力してください！");
					continue;
				}
			}
			System.out.print("X方向の移動距離 : ");
			locationX = sc.nextDouble();			
			System.out.print("Y方向の移動距離 : ");
			locationY = sc.nextDouble();
			if(car.move(locationX, locationY)) {
				System.out.println("現在値 : (" + car.getX() + ", " + car.getY() + ")");
				System.out.println("残り燃料 : " + car.getFuel());
			} else {
				System.out.println("移動できませんでした。");
				System.out.println("現在値 : (" + car.getX() + ", " + car.getY() + ")");
				System.out.println("残り燃料 : " + car.getFuel());
			}
		}
		
		sc.close();
	}
}
