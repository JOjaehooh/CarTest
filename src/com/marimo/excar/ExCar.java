package com.marimo.excar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import com.marimo.car.Car;

public class ExCar extends Car {
	
	// 総走行距離を表すフィールド
	private double totalMileage;
	// 購入日を表すフィールド
	private String purchaseDay;
	
	public ExCar(String name, String number, int width, int height, int length, double tankCapacity, double fuel,
			double mileage) {
		super(name, number, width, height, length, tankCapacity, fuel, mileage);
		// TODO Auto-generated constructor stub
	}
	
	//　ExCarコンストラクタ
	public ExCar(String name, String number, int width, int height, int length, double tankCapacity, double fuel,
			double mileage, double totalMileage, String purchaseDay) {
		super(name, number, width, height, length, tankCapacity, fuel, mileage);
		this.totalMileage = totalMileage;
		this.purchaseDay = purchaseDay;
	}
	
	//　総走行距離を返すメソッド
	public double getTotalMileage() {
		return totalMileage;
	}
	
	//　移動するたび総走行距離を計算するコードを追加したオーバーライドメソッド
	@Override
	public boolean move(double movedX, double movedY) {
		// TODO Auto-generated method stub
		double movedDistance = Math.sqrt((Math.pow(movedX, 2) + Math.pow(movedY, 2)));
		//　移動するたび、移動した距離を総走行距離に足し算します
		totalMileage += movedDistance;
		return super.move(movedX, movedY);
	}
	
	// 入力された購入日を年月日形式で返すメソッド
	public String getPurchaseDay() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat outputSdf = new SimpleDateFormat("yyyy年MM月dd日(E)");
		String date = outputSdf.format(sdf.parse(purchaseDay)).toString();
		return date;
	}
	
	//　入力値から購入日を設定するメソッド
	public void setPurchaseDay(String purchaseDay) {
		this.purchaseDay = purchaseDay;
	}
	
	
	
	
}
