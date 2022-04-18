package step7_01.classArray;

import java.util.HashMap;

/*

# HashMap ( = 압축파일)

- HashMap은 K(Key)에 V(Value)를 할당 방식으로 데이터가 저장하는 데이터 형식이다.
- HashMap은 순서와 상관없이 key로 데이터를 저장 및 관리한다.
- HashMap 생성방법

HashMap<키, 값> 변수명 = new HashMap<키, 값>();
HashMap<키, 값> 변수명 = new HashMap<>();						// new 뒤쪽의 generic은 생략 가능하다.

Ex)
HashMap<String, Integer> hmap = new HashMap<String, Integer>();
HashMap<String, Integer> hmap = new HashMap<>();				 

설명)
HashMap<String,Integer> : key의 데이터타입은 String이고 저장될 값의 데이터 타입은 Integer이다.
HashMap<String,String>  : key의 데이터타입은 String이고 저장될 값의 데이터 타입은 String이다.
HashMap<String,Object>  : key의 데이터타입은 String이고 저장될 값의 데이터 타입은 Object이다.
HashMap<String,Product> : key의 데이터타입은 String이고 저장될 값의 데이터 타입은 Product이다.
HashMap<String,Member>  : key의 데이터타입은 String이고 저장될 값의 데이터 타입은 Member이다.


*/

class TempMember {
	
	String id;
	String passwd;
	String name;
	String email;
	String address;
	
}
public class ClassArrayEx15 {

	public static void main(String[] args) {
		
		HashMap<String, Integer> hMap = new HashMap<String, Integer>();
		
		// put(key, value) : HashMap의 key에 value를 할당한다. 
		hMap.put("data1", 1000); 
		hMap.put("data2", 2000); 
		hMap.put("data3", 3000);  
		System.out.println(hMap);  // 순서가 의미 없음, 키로 값을 불러옴
		System.out.println("\n==============\n");
		
		// put()메서드는 존재하지 않는 key에 넣어주면 데이터가 입력되고 존재하는 key에 넣어주면 수정된다.
		hMap.put("data1", 10000); // 수정 
		hMap.put("data4", 4000);  // 입력 
		hMap.put("data5", 5000); 
		System.out.println(hMap);
		System.out.println("\n==============\n");
		
		// size() : HashMap의 데이터개수를 반환한다.
		System.out.println("size : " + hMap.size());
		System.out.println("\n==============\n");
		
		// get(key) : HashMap의 key에 할당된 value를 얻어온다.
		System.out.println(hMap.get("data1")); // 인덱스(위치)가 아닌 키를 통해 데이터를 가지고 온다. 
		System.out.println(hMap.get("data2"));
		System.out.println(hMap.get("data3"));
		System.out.println(hMap.get("data4"));
		System.out.println(hMap.get("data5"));
		System.out.println("\n==============\n");
		
		// keySet() : HashMap의 key만 얻어온다.
		System.out.println(hMap.keySet());
		System.out.println("\n==============\n");
		
		for (String key : hMap.keySet()) System.out.println(hMap.get(key)); // 향상된 for문 
		System.out.println("\n==============\n");
		
		// remove(key) : HashMap의 key에 해당하는 값을 제거한다.
		hMap.remove("data2");
		hMap.remove("data3");
		System.out.print(hMap);
		System.out.println("\n==============\n");
		
		hMap.clear(); // HashMap의 모든 데이터 삭제
		hMap = null; // HashMap 자체를 삭제 
		System.out.println("\n==============\n");
		
		
		// 웹에서 자주 사용하는 예시 
		HashMap<String, TempMember> memberMap = new HashMap<String, TempMember>();
		
		// 실습데이터 생성
		for (int i = 0; i < 3; i++) {
			
			TempMember temp = new TempMember();
			temp.id = "user" + i;
			temp.passwd = "0000";
			temp.name = "익명";
			temp.email = "user" + i + "@naver.com";
			temp.address = "서울";
			
			memberMap.put(temp.id, temp); // id키를 이용하여 temp 데이터를 다 가지고 옴.
		}
		
		for (String key : memberMap.keySet()) {
			System.out.println("key : " + key); // key = temp.id (위 for문에서 명시)
			System.out.println("memberMap : " + memberMap.get(key));
			System.out.println("id : " + memberMap.get(key).id);
			System.out.println("passwd : " + memberMap.get(key).passwd);
			System.out.println("name : " + memberMap.get(key).name);
			System.out.println("email : " + memberMap.get(key).email);
			System.out.println("address : " + memberMap.get(key).address);
			System.out.println();
		}
		
		
		
	}

}
