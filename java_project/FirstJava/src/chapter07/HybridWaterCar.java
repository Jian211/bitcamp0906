package chapter07;

public class HybridWaterCar extends HybridCar {
	int waterGuage;
	
	HybridWaterCar(int gasolinegauge, int electronicGauge, int waterGuage) {
		super(gasolinegauge, electronicGauge); // 2. 생성자 호출
		this.waterGuage = waterGuage;
	}
	
	public static void main(String[] args) {
		HybridWaterCar hdCar = new HybridWaterCar(10,20,30); // 1. 생성자 호출
		System.out.println(Car.door);
		System.out.println(HybridWaterCar.door);
	}
}

class HybridCar extends Car{

	int electronicGauge;
	
	// 상속관계에서 상위클래스에 생성자가 존재하면 생성자 호출 해주어야한다.
	// 상위클래스의 변수를 초기화 해야하기 때문에 초기화할 값을 받아서 
	// 상위클래스의 생성자를 호출!
	HybridCar(int gasolinegauge, int electronicGauge) {
		super(gasolinegauge); // 상위 클래스의 생성자 호출
		this.electronicGauge = electronicGauge;
	}

}

class Car{
	static int door = 5;
	int gasolinegauge;
	
	Car(int gasolinegauge){
		this.gasolinegauge = gasolinegauge;
	}
}