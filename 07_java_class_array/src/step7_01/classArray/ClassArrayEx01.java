package step7_01.classArray;

import javax.swing.Spring;

class Product {
	
	String name;
	int price;
	
}
public class ClassArrayEx01 {

	public static void main(String[] args) {
		
		// # 클래스배열 생성 방법
		// 클래스명[] 배열명 = new 클래스명[크기];
		Product[] productList = new Product[3];
		
		Product t = new Product();
		
		productList[0] = t;
		productList[1] = new Product();
		productList[2] = new Product();
		
		productList[0].name = "기계식 키보드";
		productList[0].price = 45000;
		
		productList[1].name = "무소음 마우스";
		productList[1].price = 27000;
		
		productList[2].name = "장패드";
		productList[2].price = 10000;
		
		for (int i = 0; i < productList.length; i++) {
			System.out.println("name : " + productList[i].name);
			System.out.println("price : " + productList[i].price);
			System.out.println();
		}
		
		// [응용] 생각해보기             // 주소 or 값
		Product[] temp1 = productList;          //주소
		Product temp2 = productList[1];         // 주소
		String temp3 = productList[0].name;  // 기계식 키보드 
		int temp4 = productList[0].price;  // 27000
		
		Product temp = productList[2];
		System.out.println("temp : " + temp); 
		System.out.println("productList[2] : " + productList[2]); 
		
		System.out.println("temp.name : " + temp.name);
		System.out.println("productList[2].name : " + productList[2].name);
		
		temp.name = "장패드1";
		System.out.println("temp.name : " + temp.name);
		System.out.println("productList[2].name : " + productList[2].name);
		
		productList[2].name = "장패드2";
		System.out.println("temp.name : " + temp.name);
		System.out.println("productList[2].name : " + productList[2].name);
		
		
	}

}
