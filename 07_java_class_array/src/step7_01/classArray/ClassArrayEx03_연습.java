package step7_01.classArray;

class Account{
	
	String id; 
	int money;
	
}

public class ClassArrayEx03_연습 {

	public static void main(String[] args) {
		
		Account[] accountList = new Account[2];
		
		for (int i=0; i<accountList.length; i++) {
			accountList[i] = new Account();
		}
		
		accountList[0].id = "qwer1234";
		accountList[0].money = 1000;
		
		accountList[1].id = "asdf1234";
		accountList[1].money = 2000;
		
		for (int i = 0; i < accountList.length; i ++) {
			System.out.println(accountList[i].id + " " + accountList[i].money);
		}
		
		Account temp = accountList[1];
		temp.id = "zxcv1234";
		System.out.println("=====================================");
		
		for (int i = 0; i < accountList.length; i ++) {
			System.out.println(accountList[i].id + " " + accountList[i].money);
		}	
	
	}

}
