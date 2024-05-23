package com.marimo.excar;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExCarTester {
	public static void main(String[] args) {
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
		String purchaseDay = null;
		
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
		System.out.print("購 入 日	:  (ｙｙｙｙMMｄｄ形式にお願いします！)");
		purchaseDay = sc.next();
		} 
		// 入力のデータ型が合わない場合のため
		catch (InputMismatchException e) {
			System.out.println("いたずらしないでください");
		}
		
		// 入力された値に基づいてExCarインスタンスを生成します。
		ExCar exCar = new ExCar(name, number, width, height, length, tankCapacity, fuel, mileage);
		
		// 購入日を設定します。
		exCar.setPurchaseDay(purchaseDay);
		System.out.println("現在位置 : (" + exCar.getX() + ", " + exCar.getY() + ")");
		System.out.println("残り燃料 : " + exCar.getFuel() + "リットル");
		try {
			System.out.println("購 入 日 : " + exCar.getPurchaseDay());
		//　購入日が正しい形式に入力されなかった場合
		} catch (ParseException e) {
			System.out.println("購入日が「yyyyMMdd」の形式に入力されてありません。");
		} 
		
		sc.close();
	}
}
