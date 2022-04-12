package step7_01.classArray;

class Member{
	
	String name;
	int num;
	
}


class MemberManager{

	Member[] memberList = new Member[3];

}


public class ClassArrayEx06_연습 {

	public static void main(String[] args) {

		// 해석해보기 // 객체나 배열이름은 가는 길을 명시 그 내용이 아님 
		
		MemberManager mg = new MemberManager();	
		Member m1 = new Member();
		mg.memberList[0] = m1;
		m1.name = "김철수";
		m1.num = 1001;           // 김철수,1001 < m1 = mg.memberList[0] = member 배열라인 < mg = memberManage 배열라인 
		
		m1 = new Member();     // 그 내용으로 가는 길을 끊고 다른 배열로 가는 길을 연결 
		mg.memberList[1] = m1; // 그 내용으로 가는 길 
		m1.name = "이만수";
		m1.num = 1002;          // 이만수,1002 < m1 = mg.memberList[1] = member 배열라인 < mg = memberManage 배열라인 
		
		m1 = new Member();
		mg.memberList[2] = m1;
		m1.name = "박영희";
		m1.num = 1003;         // 박영희,1003 < m1 = mg.memberList[2] = member 배열라인 < mg = memberManage 배열라인 
		
		for (int i = 0; i < mg.memberList.length; i++) {
			System.out.println("num : " + mg.memberList[i].num);
			System.out.println("name : " + mg.memberList[i].name);
			System.out.println();
		}
		
		Member temp = mg.memberList[1];
		System.out.println("num : " + temp.num);
		System.out.println("name : " +temp.name);

	}

}
