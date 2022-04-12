package step7_01.classArray;

class Account{
	
	String id; 
	int money;
	
}

public class ClassArrayEx03_연습 {

	public static void main(String[] args) {
		
		Account[] accountList = new Account[2]; // 2칸 만들어주기 
		
		for (int i=0; i<accountList.length; i++) {
			accountList[i] = new Account(); // 내용 넣는 자격 주기 
		}
		
		accountList[0].id = "qwer1234"; // 내용 넣어주기 
		accountList[0].money = 1000;
		
		accountList[1].id = "asdf1234";
		accountList[1].money = 2000;
		
		for (int i = 0; i < accountList.length; i ++) {
			System.out.println(accountList[i].id + " " + accountList[i].money);
		}
		
		Account temp = accountList[1]; // 임시 temp 배열은 1번의 배열 
		temp.id = "zxcv1234"; // 1번 배열의 아이디만 변경 
		System.out.println("=====================================");
		
		for (int i = 0; i < accountList.length; i ++) { // 특정 부분 변경해주기 
			System.out.println(accountList[i].id + " " + accountList[i].money); 
		}	
	
	}

}
