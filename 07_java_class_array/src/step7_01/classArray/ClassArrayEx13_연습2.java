package step7_01.classArray;

import javax.lang.model.element.Element;

//# ArrayList 클래스의 기능을 직접 구현해보자!

class MyList {
	
	int[] arr;
	int elementCnt;
	
	void print() { // 출력하기 
		
		System.out.print("[");
		for (int i = 0; i < elementCnt; i++) {
			System.out.print(arr[i]);
			if (i != elementCnt -1) System.out.print(", ");
		}
		System.out.println("]\n");
	}

	void add(int value) {  // 추가하기
		
		if (elementCnt == 0) arr = new int[elementCnt +1];
		else if (elementCnt > 0) {
			int[] temp = arr;
			arr = new int[elementCnt +1];
			
			for (int i =0; i < elementCnt; i++) arr[i] = temp[i];
			temp = null; 
		}
		
		arr[elementCnt] = value;
		elementCnt++;
			
	}
	
	void add(int index, int value) { // 삽입하기
		
		if (elementCnt == 0) arr = new int[elementCnt +1];
		else if (elementCnt > 0) {
			int[] temp = arr;
			arr = new int[elementCnt +1];
			
			int j =0; 
			for (int i = 0; i < elementCnt + 1; i++) {
				if(i != index) arr[i] = temp[j++];
			}
			temp = null; 
		}	
		
		arr[index] = value;
		elementCnt++;
	}
	
	void remove(int index) { // (index로)삭제하기
		 
		if(elementCnt == 1) arr = null;
		else if (elementCnt > 1) {
			int[] temp = arr;
			arr = new int[elementCnt-1];
			
			int j = 0; 
			for (int i = 0; i < elementCnt; i++) {
				if (i != index) arr[j++] = temp[i];
			}
			temp = null;
		} 
		elementCnt--;
	}

	
	int size() { // 길이 구하기
		return elementCnt;
	}

	
	int get(int index) { // (index로)값 꺼내오기
		return arr[index];
	}

	
	void set(int index, int value) { // 특정 위치의 값 수정하기
		arr[index] = value;
	}

	
	void clear() { // 모든 데이터를 제거하기
		arr = null;
		elementCnt = 0;
	}

	public void arr(int i) {
		// TODO Auto-generated method stub
		
	}

}


public class ClassArrayEx13_연습2 {

	public static void main(String[] args) {

		// 직접 구현한 ArrayList
		MyList list = new MyList();
		
		// 추가하기
		list.arr(10);
		list.arr(20);
		list.arr(30);
		list.arr(40);
		list.arr(50);
		list.print();
		
		
		// 삽입하기
		list.add(0, 1);
		
		
		// 출력하기
		list.print();

		// (index로)삭제하기
		list.remove(2);
		list.print();

		// 길이 구하기
		list.size();
		list.print();

		// (index로)값 꺼내오기
		for (int i = 0; i < list.size(); i++) System.out.print(list.get(i));

		// 특정 위치의 값 수정하기
		list.set(3, 4);
		list.print();
		
		// 모든 데이터를 제거하기
		list.clear();

	}

}
