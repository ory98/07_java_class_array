package step7_01.classArray;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * 
 * [ 래퍼 클래스(wrapper class) ]
 * 
 * - 래퍼 클래스란, 기본 자료형을 클래스로 만들어 놓은 것을 의미한다.
 *   [기본형]          [래퍼 클래스]
 *    byte                Byte
 *    short               Short
 *    int                 Integer
 *    long                Long
 *    float               Float
 *    double              Double
 *    char                Character
 *    boolean             Boolean
 *
 *
 *
 *  [ 제네릭 ]
 *  
 * - 제네릭(generic)이라 부르며 ArrayList에 저장될 데이터 타입을
 *   반드시 클래스로 작성한다.
 * - 기본 자료형 데이터를 저장하는 ArrayList를 만들어야 하는 경우에는
 *   래퍼 클래스를 사용한다.
 *
 *
 *
 *  [ java.util.ArrayList ]
 *  
 * - 배열은 한번 선언하면 프로그램에서 그 크기를 바꿀 수 없다.
 * - ArrayList 클래스는 데이터가 입력되면, 자동으로 크기가 커지고
 * - 데이터가 제거되면, 자동으로 크기가 작아진다.
 * - 중간에 데이터가 삽입되면, 데이터가 삽입될 위치부터 모든 데이터가 뒤로 이동되고
 * - 중간의 데이터가 제거된 다음 위치부터 모든 데이터가 앞으로 이동한다.
 * - ArrayList 생성 방법
 * 
 *   ArrayList<Integer> list = new ArrayList<Integer>();     
 *   ArrayList<Integer> list = new ArrayList<>();           // 우변의 제네릭의 데이터형은 생략 가능하다.
 *   
 *   
 *   ArrayList<String> list = new ArrayList<String>();
 *   ArrayList<Product> list = new ArrayList<Product>();
 *   ArrayList<Member> list = new ArrayList<Member>();
 */

public class ClassArrayEx10 {

	public static void main(String[] args) {
		
		int[] arr = new int[10];
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		
		System.out.println(Arrays.toString(arr));
		System.out.println(list); 
		
		System.out.println("==================\n");
		
		// 1. 추가 
		arr[0] = 10; // 기존 배열 : 값을 하나씩 입력 
		arr[1] = 20;
		arr[2] = 30;
		arr[3] = 40;
		arr[4] = 50;
		
		// add(value) : arrayList의 맨뒤에 value를 추가한다.
		// add(index,value) : arrayList의 index번째에 value를 추가한다.
		list.add(10);
		list.add(20);
		list.add(40);
		list.add(50);
		list.add(2,30); // 2번째 칸에 30을 넣는다. 
		
		System.out.println(Arrays.toString(arr));
		System.out.println(list); 
		
		System.out.println("==================\n");
		
		
		// 2. 크기 
		System.out.println("크기 : " + arr.length);
		// size() : arrayList의 데이터의 개수를 반환한다.
		System.out.println("크기 : " + list.size());
		System.out.println("==================\n");
		
		
		// 3. 수정 
		arr[0] = 1000;
		arr[1] = 2000;
		arr[2] = 3000;
		
		// set(index,value) : ArrayList의 index번째의 값을 value값으로 수정한다.
		list.set(0, 1000);
		list.set(1, 2000);
		list.set(2, 3000);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(list); 
		
		System.out.println("==================\n");
		
		
		// 4. 지우기 
		arr[0] = 0;
		arr[1] = 0;
		arr[2] = 0;
		
		// remove(index) : ArrayList의 index번째 위치의 값을 삭제한다.
		list.remove(2);
		list.remove(1);
		list.remove(0);
		
		System.out.println(Arrays.toString(arr));
		System.out.println(list); 
		
		System.out.println("==================\n");
		
		
		// 5. 값 꺼내쓰기 
		for (int i = 0; i <arr.length; i++) System.out.print(arr[i] + " ");
		System.out.println();
		
		// get(index) : ArrayList의 index번째의 value를 얻어온다.
		for (int i = 0; i <list.size(); i++) System.out.print(list.get(i) + " "); // 범위 조심 
		System.out.println();
		System.out.println("==================\n");
		
		
		/*
		 * 
		 *  # 향상된 for문 (foreach)
		 *  
		 *  [ 구조 ]
		 *  
		 *  for (자료형 변수명 : Array or ArrayList) {
		 *  	명령어;
		 *  }
		 * 
		 *  element가 직접 변수에 저장된다.
		 * 
		 * */
		
		for (int element : arr) System.out.print(element + " ");
		System.out.println();
		
		for (int element : list) System.out.print(element + " ");
		System.out.println();
		System.out.println("==================\n");
		
		// 예시 1) 
		String[] indexs = {"하나", "둘", "셋", "넷", "다섯"};
		
		for (String index : indexs) System.out.print(index + " ");
		System.out.println();
		System.out.println("==================\n");
		
		// 예시 2)
		ArrayList<Product> productList = new ArrayList<Product>();
		
		
		for (int i = 1; i <11; i++) {
			Product temp = new Product(); // class 1번에 있음 , Product는 객체 , temp = new Product() > 데이터 
			temp.name = "상품" + i;
			temp.price = 1000 * i; // 
			
			productList.add(temp); // > 데이터를 안에 넣어줌 
		}
		
		for (int i = 0; i < productList.size(); i++) {
			System.out.println(productList.get(i).name +  " / " + productList.get(i).price);
		}
		System.out.println();
		
		for (Product pd : productList) System.out.println(pd.name +  " / " + pd.price);
		// pd는 새로운 이름 
		
		// 6. 통으로 지우기
		arr = null; // 가는길 끊기
		
		list.clear(); // ArrayList의 모든 데이터만 삭제, 틀은 남아있음
		list.add(10); // 새로운 입력 가능 
		
		list = null; // new 하는 변수는 null로 다 끊을 수 있음, ArrayList 자체를 삭제 
		// list.add(10); > 새로운 입력 불가능 
		
		
	}

}
