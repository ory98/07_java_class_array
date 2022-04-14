package step7_01.classArray;

import java.util.ArrayList;

class Tv {
	
	String name;
	String brand;
	int price;

	void setData(String name, String brand, int price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	
}

class TvList { // 직접 구현한 arraylist 
	
	Tv[] arr; // tv 배열 
	int elementCount; 

	void add(Tv tv) { // add의 Tv의 tv
		
		if (elementCount == 0) { 
			arr = new Tv[elementCount + 1]; // arr를 새로만듬 
		} 
		else if (elementCount > 0) { 
			Tv[] temp = arr;  // temp에 arr을 넣어줌 

			arr = new Tv[elementCount + 1]; //  arr에 새로운 배열을 넣음
			for (int i = 0; i < elementCount; i++) {
				arr[i] = temp[i];  // 내용 넣기 
			}
		}
		arr[elementCount] = tv;
		elementCount++;
		
	}

	int size() {
		return elementCount;
	}

	void remove(int index) {
		
		if (elementCount == 1) {
			arr = null;
			elementCount = 0;
		} 
		else if (elementCount > 1) {
			Tv[] temp = arr;

			arr = new Tv[elementCount - 1];
			int j = 0;
			for (int i = 0; i < elementCount; i++) {
				if (i != index) {
					arr[j++] = temp[i];
				}
			}
			elementCount--;
		}
		
	}

	Tv get(int index) {
		return arr[index];
	}

}


public class ClassArrayEx12_연습 {

	public static void main(String[] args) {
		
		// ArrayList 사용
		ArrayList<Tv> list = new ArrayList<>(); // tv를 가지고 있는 리스트 작성

		Tv temp = new Tv(); // 안에 티비의 내용(temp) 구성 
		temp.setData("TV", "삼성", 1000); // temp안에 세부내용 추가 
		list.add(temp); // 리스트에 temp 추가된 내용 추가 
		
		temp = new Tv(); // 새로운 temp 구성 
		temp.setData("시그니처TV", "엘지", 2000); //  temp안에 세부내용 추가 
		list.add(temp); // 리스트에 temp 추가된 내용 추가

		temp = new Tv(); // 새로운 temp 구성 
		temp.setData("스마트TV", "애플", 3000); //  temp안에 세부내용 추가
		list.add(temp); // 리스트에 temp 추가된 내용 추가
	
		for (Tv tv : list) { // 리스트 범위 안 구성요소의 티비의 범위가 충족될때
			System.out.println("name : " + tv.name); 
			System.out.println("brand : " + tv.brand);
			System.out.println("price : " + tv.price);
			System.out.println();
		}
		

		System.out.println("\n========================================\n");

		// 직접 구현한 ArrayList 사용
		TvList myList = new TvList(); 
		temp = new Tv();
		temp.setData("TV", "삼성", 1000);
		myList.add(temp);

		temp = new Tv();
		temp.setData("시그니처TV", "엘지", 2000);
		myList.add(temp);

		temp = new Tv();
		temp.setData("스마트TV", "애플", 3000);
		myList.add(temp);

		for (Tv tv : myList.arr) {
			System.out.println("name : " + tv.name);
			System.out.println("brand : " + tv.brand);
			System.out.println("price : " + tv.price);
			System.out.println();
		}

	}

}
