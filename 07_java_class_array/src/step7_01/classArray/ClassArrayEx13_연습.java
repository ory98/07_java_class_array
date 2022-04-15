package step7_01.classArray;

//# ArrayList 클래스의 기능을 직접 구현해보자!

//class MyList {
//
//	int[] arr; // arr이라는 배열
//	int elementCnt; 
//
//	void print() { 
//		
//		System.out.print("["); 
//		for (int i = 0; i < elementCnt; i++) {
//			System.out.print(arr[i]); 
//			if (i != elementCnt - 1) { // 맨끝에 자리가 아닌 곳까지
//				System.out.print(", "); // ,로 배열하기 
//			}
//		}
//		System.out.println("]\n");
//		
//	}
//
//	
//	void add(int value) {  // value를 넣으려는 행위 
//		
//		if (elementCnt == 0) { 
//			arr = new int[elementCnt + 1]; // 새로운 배열 만들기
//		} 
//		else if (elementCnt > 0) { 
//			int[] temp = arr; // 임시배열 만들기 
//			arr = new int[elementCnt + 1]; // 기존 배열에 하나를 추가한 배열 넣기
// 
//			for (int i = 0; i < elementCnt; i++) { 
//				arr[i] = temp[i]; // arr배열에 temp배열 내용 넣기 
//			}
//			temp = null; // 임시 배열 삭제 
//		}
//
//		arr[elementCnt] = value; // 맨 끝에 값을 추가 
//		elementCnt++; // 요소 개수 증가 
//		
//	}
//
//	
//	void add(int index, int value) { // 어디 index에 값을 넣으려는 행위 
//		
//		if (elementCnt == 0) { 
//			arr = new int[elementCnt + 1];
//		} 
//		else if (elementCnt > 0) { 
//			int[] temp = arr;
//			arr = new int[elementCnt + 1]; // 여기까지 값만 넣을 경우를 적음 
//
//			int j = 0; 
//			for (int i = 0; i < elementCnt + 1; i++) { // 범위가 요소갯수+1 안에 있을 경우 
//				if (i != index) { // 인덱스 값인 i와 입력한 index가 다를 때 
//					arr[i] = temp[j++]; // arr[i]내용에 추가되는 temp[j++] 내용을 계속 넣는다. (이동)
//				}
//			}
//			temp = null; 
//		}
//
//		arr[index] = value; // 지정 자리에 값을 넣는다 .
//		elementCnt++; // 구성요소는 증가 
//		
//	}
//
//	
//	void remove(int index) { // 인덱스 삭제 
//		
//		if (elementCnt == 1) { // 요소가 한개일 경우
//			arr = null; // 배열은 사라진다. 
//		} 
//		else if (elementCnt > 1) { // 1개 이상일 경우
//			int[] temp = arr; // 기존 배열을 임시 배열에 넣고  
//			arr = new int[elementCnt - 1]; // 기존 배열은 요소에서 하나 뺀 배열을 넣어준다. 
//
//			int j = 0;
//			for (int i = 0; i < elementCnt; i++) { 
//				if (i != index) { // i와 index가 다를 때 
//					arr[j++] = temp[i]; // 바뀐[j++] 배열에 임시 배열 i자리 값을 계속 넣어준다 (이동)  
//				}
//			}
//			temp = null;
//		}
//		elementCnt--; 
//		
//	}
//
//	
//	int size() { 
//		return elementCnt;
//	}
//
//	
//	int get(int index) { 
//		return arr[index];
//	}
//
//	
//	void set(int index, int value) {
//		arr[index] = value;
//	}
//
//	
//	void clear() {
//		arr = null;
//		elementCnt = 0;
//	}
//
//}
//
//
//public class ClassArrayEx13_연습 {
//
//	public static void main(String[] args) {
//
//		// 직접 구현한 ArrayList
//		MyList list = new MyList();
//
//		// 추가하기
//		list.add(10);
//		list.add(20);
//		list.add(30);
//		list.add(40);
//		list.add(50);
//		list.print();
//		
//		// 삽입하기
//		list.add(0, 9);
//		
//		// 출력하기
//		list.print();
//
//		// (index로)삭제하기
//		list.remove(3);
//		list.print();
//
//		// 길이 구하기
//		int elementCnt = list.size();
//		System.out.println("elementCnt = " + elementCnt);
//
//		// (index로)값 꺼내오기
//		System.out.print("[");
//		for (int i = 0; i < elementCnt; i++) {
//			System.out.print(list.get(i));
//			if (i != elementCnt - 1) { // 맨끝에 ,를 빼기위한 행위 
//				System.out.print(", ");
//			}
//		}
//		System.out.println("]");
//
//		// 특정 위치의 값 수정하기
//		list.set(3, 5);
//		list.print();
//
//		// 모든 데이터를 제거하기
//		list.clear();
//		System.out.println(list.size());
//
//	}
//
//}
