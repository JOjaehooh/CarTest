package com.marimo.car;

public class Car {
	static final int START_LOCATION = 0;	// X座標とY座標はともに０とするため
	private String name;			// 名前
	private String number;			// ナンバー
	private int width;				// 幅
	private int height;				// 高さ
	private int length;				// 長さ
	private double locationX;		// 現在位置X座標
	private double locationY;		// 現在位置y座標
	private double tankCapacity;	// タンク容量
	private double fuel;			// 残り燃料
	private double mileage;			// 燃費
	
	// コンストラクタ
	public Car(String name, String number, int width, int height, int length, double tankCapacity, double fuel,
			double mileage) {
		this.name = name;
		this.number = number;
		this.width = width;
		this.height = height;
		this.length = length;
		this.locationX = START_LOCATION;	// X座標を０とします。
		this.locationY = START_LOCATION;	// Y座標を０とします。
		this.tankCapacity = tankCapacity;
		// 残り燃料がタンク容量より大きかった場合はタンク容量にします。
		if(fuel > tankCapacity) fuel = tankCapacity;
		this.fuel = fuel;
		this.mileage = mileage;
	}

	// フィールドX座標の値をそのまま返すメソッド
	public double getX() {
		return locationX;
	}

	// フィールドY座標の値をそのまま返すメソッド
	public double getY() {
		return locationY;
	}

	// フィールド残り燃料の値をそのまま返すメソッド
	public double getFuel() {
		return fuel;
	}

	// 名前・ナンバー・車幅・車高・車長・タンク容量・燃費を１行ずつ表示するメソッド
	public void putSpec() {
		System.out.println("名   前	: " + this.name);
		System.out.println("ナンバー	: " + this.number);
		System.out.println("車   幅	: " + this.width + "mm");
		System.out.println("車   高	: " + this.height + "mm");
		System.out.println("車   長	: " + this.length + "mm");
		System.out.println("タ　ン　ク	: " + this.tankCapacity + "リットル");
		System.out.println("燃  　費	: " + this.mileage + "km/リットル");
	}
	
	// 指示されたX方向の移動距離とY方向の移動距離に基づいて自動車を移動するメソッド
	public boolean move(double movedX, double movedY) {
		// 引数のX座標とY座標を二乗したものを足し算し平方根を求めて移動距離を算出。
		double movedDistance = Math.sqrt((Math.pow(movedX, 2) + Math.pow(movedY, 2)));
		// 移動距離に対して残り燃料が足りれば、現在位置と残り燃料を更新しtrueを返します。
		if(this.fuel >= movedDistance/this.mileage) {
			this.locationX += movedX;
			this.locationY += movedY;
			this.fuel -= Math.round(movedDistance/this.mileage*100)/100.0;
			return true;
		}
		// 残り燃料が不足していれば、移動不能と判断し、falseを返します。
		return false;
	}
	
	// 給油を行うメソッド
	public void refuel(double refuel) {
		// 引数で受け取った分だけ、残り燃料を増加させます。
		this.fuel += refuel;
		// 増加後の値がタンク容量を超えないようにします。
		if(this.fuel > this.tankCapacity) this.fuel = this.tankCapacity;
	}
	
}
