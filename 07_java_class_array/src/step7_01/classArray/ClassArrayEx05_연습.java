package step7_01.classArray;

class Client{
	
	String name;
	int score; // 개수가 늘어나면 clientList[0].setData("김철수",100)에 괄호안에 , 만 넣고 옆에 작성할 수 있다. 
	
	void setData (String name, int score) {  
		this.name = name; 	    // name < 임시변수이름 다른 어떤 이름도 괜찮음. 
		this.score = score;		// 멤버변수에 파라메타로 넘어온 데이터를 대입
		// this가 객체를 가리키므로 각각 적지 않아도 된다. 
		// name이 반복되기때문에 this를 적어줌. 생략 가능 
	}
	
	void printData() {
		System.out.println(this.name  + " : " + this.score);
	}
	
}


public class ClassArrayEx05_연습 {

	public static void main(String[] args) {
		
		Client[] clientList = new Client[3]; // clintList 배열 3칸 만들기 
		
		for (int i = 0; i < clientList.length; i++) {
			clientList[i] = new Client(); // 채울 수 있는 자격을 줌 
		}
		
		clientList[0].setData("김철수",100); 
		clientList[1].setData("이만수",20);
		clientList[2].setData("박영희",70);
		
		for (int i = 0 ; i < clientList.length; i++) { 
			clientList[i].printData(); 
		}

	}

}
