package step7_01.classArray;
import java.util.Scanner;

class Subject8{
	
	String name;
	int score;

}


class Student8{
	
	Subject8[] subjects;
	String name;

}


public class ClassArrayEx08_연습 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// # 학생 추가 삭제 컨트롤러
		//   => 컨트롤러를 완성해 아래 3개의 정보를 추가하시오.
		//   김철수 : 과목3개 수학 50 국어 50 영어 60 
		//   이만수 : 과목2개 수학 20 국어 30 
		//   이영희 : 과목1개 수학 100
		
		Student8[] studentList = new Student8[3]; // 학생을 가르키는 배열을 세칸 만듬 
		int studentCnt = 0;	// 학생 수
		
		while (true) {
			
			for (int i = 0; i < studentCnt; i++) {
				System.out.println("[" + (i+1) + "]" + studentList[i].name + "학생>>>");
				if (studentList[i].subjects != null) { // 저 배열이 비어있지 않으면 
					for (int j = 0; j < studentList[i].subjects.length; j++) {
						System.out.println("[" + (j+1) + "]" + studentList[i].subjects[j].name + "과목 = " + studentList[i].subjects[j].score + "점");
					}
				}
				System.out.println();
			}
			
			System.out.println("[1]학생 추가하기");		// 이름 입력받아 추가
			System.out.println("[2]과목 추가하기");		// 이름과 과목 입력받아 추가
			System.out.println("[3]성적 추가하기");		// 이름과 과목 그리고 성적 입력받아 추가
			System.out.println("[4]종료하기");
			int choice = scan.nextInt();
			
			if (choice == 1) {
				
				System.out.print("이름 입력 : ");
				String name = scan.next();
				
				studentList[studentCnt] = new Student8(); // 새로운 배열을 채울 수 있는 자격을 줌 
				studentList[studentCnt].name = name;
				studentCnt++; 
				
			}
			else if (choice == 2) { // 과목 추가하기 
				
				for (int i = 0; i < studentCnt; i++) { // 학생들 다 보여주기 
					System.out.println("[" + (i+1) + "]" + studentList[i].name);
				}
				System.out.print("학생 선택 : "); 
				int select = scan.nextInt();
				select--;  // 선택한 숫자와 배열의 인덱스가 차이가 -1 차이가 남으로 하나를 빼준다. 
				
				System.out.print("과목 입력 : "); 
				String subject = scan.next(); 
				
				if (studentList[select].subjects == null) { // 학생 배열이 아무것도 없으면 
					
					studentList[select].subjects = new Subject8[1]; // 학생 리스트 배열의 새로운 배열 추가 
					
					studentList[select].subjects[0] = new Subject8(); // 내용을 넣을 수 있는 자격 주기  
					studentList[select].subjects[0].name = subject; // 과목 입력 
					
				}
				else { // 1개 이상일 경우 
					
					int size = studentList[select].subjects.length; // 과목 배열 라인 길이 size로 설정 
					
					Subject8[] temp = studentList[select].subjects; // 임시 배열 만들기 
					studentList[select].subjects = new Subject8[size + 1]; // 임시 배열의 사이즈 하나 늘려주기 
					
					for(int i = 0; i < size; i++) { 
						studentList[select].subjects[i] = temp[i]; // 임시 배열을 그 배열의 i번째에 넣어주기 
					}
					
					studentList[select].subjects[size] = new Subject8(); // 바뀐 배열의 내용 넣을 수 있는 자격 주기
					studentList[select].subjects[size].name = subject; // 과목 이름 입력 
					
					temp = null; // 임시 배열 삭제 
					
				}
			}
			else if (choice == 3) { // 성적 추가하기 
				
				for (int i = 0; i < studentCnt; i++) { 
					System.out.println("[" + (i+1) + "]" + studentList[i].name); // [i] 학생 이름 
				}
				System.out.print("학생 선택 : "); 
				int select = scan.nextInt();
				select--;  // 선택한 숫자와 배열의 인덱스가 차이가 -1 차이가 남으로 하나를 빼준다.
				
				if (studentList[select].subjects != null) { // 내용이 비어있지 않으면 
					for (int i = 0; i < studentList[select].subjects.length; i++) {
						System.out.println("[" + (i+1) + "]" + studentList[select].subjects[i].name); // [i] 과목 이름 나타내기 
					}
				}
				
				System.out.print("과목 선택 : "); 
				int num = scan.nextInt();
				num--;  // 선택한 숫자와 배열의 인덱스가 차이가 -1 차이가 남으로 하나를 빼준다.
				
				System.out.print("성적 입력 : ");
				int score = scan.nextInt();  // 선택이 아닌 입력이기 때문에 빼주지 않는다.
				
				studentList[select].subjects[num].score = score; // 배열 자리에 숫자 넣어주기 
				
			}
			else if (choice == 4) {
				System.out.println("종료");
				break;
			}
		
		}

		scan.close();

	}

}
