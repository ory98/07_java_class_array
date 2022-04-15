package step7_01.classArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

class StudentVO{ // 객체(학생의 id+pw) 만들기 
	
	String id;
	String pw;
	
	void printData() {
		System.out.println("이름 : " + this.id + " 비밀번호 : " + this.pw);
	}
	
}


class StudentManager{ // 객체 만들기 
	
	ArrayList<StudentVO> studentList = new ArrayList<StudentVO>(); // 어레이리스트 사용하기 
	
	void addStudent(StudentVO st) { // st의 학생 추가하기 
		studentList.add(st);
	}
	
	
	StudentVO removeStudent(int index) { // index를 사용하여 학생 제거하기 
		StudentVO del_st = studentList.get(index); // 삭제한 내용을 보여주기 위해 del_st에 담는다. (다른 언어에서 사용되기 때문에 연습) 
		studentList.remove(index); // 그 인덱스를 삭제 
		return del_st; // 삭제한 학생을 돌려줌 
	}
	
	
	int checkId(StudentVO st) { // st로 인해 id확인하기 
		int check = -1; 
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).id.equals(st.id)) { // 입력한 아이디와 st의 아이디가 같을 경우 
				check = i; // 둘은 같다 
				break; // 멈춤 
			}
		}
		return check; //check를 반환 
	}
	
	
	void printStudent() { // 학생 출력 
		for (int i = 0; i < studentList.size() ;i++) { // 범위 안에 있을 대 
			studentList.get(i).printData(); // printData의 형식으로 리스트 다 출력 
		}
	}	
	
	
	String outData() { // 다른 파일에 출력 데이터 
		String data = "";
		int count = studentList.size(); // 개수는 리스트의 사이즈 
		if (count == 0){ // 하나도 없을 경우 
			return data; // 데이터 반환 
		}
		data += count; // 데이터를 하나씩 증가 
		data += "\n"; 
		for (int i = 0; i < count; i++) {
			data += studentList.get(i).id;
			data += ",";
			data += studentList.get(i).pw; // id , pw 의 형식으로 출력이 됨. 
			if (count - 1 != i) { // 범위의 순서가 끝에서 첫번째가 아닐 때 
				data += "\n"; // 한줄 띄어쓰기 반복 
			}
		}
		return data; // 데이터를 반환 
	}
	
	
	void sortData() { // 데이터 정렬 *****************
		 
//		for(int i = 0; i < studentList.size(); i++) {
//			for (int n = 0; n < studentList.size(); n++) {
//				if (studentList.get(i).id.compareTo(studentList.get(n).id) > 0) {
//					StudentEx temp = studentList.get(i);
//					studentList.get(i) = studentList.get(n);
//					studentList.get(n) = temp;
//			
//				}
//			}
//		}
//			
	}
	
	
	void loadStudent(ArrayList<StudentVO> temp ) {
		studentList = temp;
	}	
	
	
	int getSize() { // 길이 출력 
		return studentList.size();
	}
	
}

public class ClassArrayEx14_연습 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		StudentManager manager = new StudentManager(); // 어레이리스트 사용가능 
		
		while (true) { 
			
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
			int sel = scan.nextInt();
			
			if (sel == 1) { // 가입 
				
				StudentVO temp = new StudentVO(); // 새로운 객체를 만들어 사용 가능 
				System.out.println("[가입] id 를 입력하세요 >>> "); 
				temp.id = scan.next();			
				int check =  manager.checkId(temp); // 비교 
				
				if (check == -1) { // 같지 않을 경우 
					System.out.println("[가입] pw 를 입력하세요 >>> ");
					temp.pw = scan.next(); 
					manager.addStudent(temp); // 학생 추가 	
					System.out.println(temp.id + "님 가입을 환영합니다.");
				}
				else { // 같을 경우
					System.out.println("중복아이디 입니다.");
				}	
				
			}
			else if (sel == 2) { // 탈퇴 
				
				manager.printStudent(); // 학생 리스트 다 출력 
				
				StudentVO temp = new StudentVO(); // 새로운 객체 생성 
				
				System.out.println("[탈퇴] id 를 입력하세요 >>> ");
				temp.id = scan.next();	
				
				int check = manager.checkId(temp); // 인덱스 비교 
				if (check == -1) { // 없을 경우 
					System.out.println("없는 아이디입니다.");
				}
				else { // 있을 경우 
					StudentVO del_st = manager.removeStudent(check); // 누가 탈퇴되었는지 보여주기 위해 작성  
					System.out.println(del_st.id + "님 탈퇴 되었습니다.");
				}
				
			}
			else if (sel == 3) { // 정렬 
				
				manager.sortData();
				manager.printStudent();
				
			}
			else if (sel == 4) { // 출력 
				
				manager.printStudent();
				
			}
			else if (sel == 5) { // 파일에 저장 

				FileWriter fw = null;
				
                if (manager.getSize() == 0) continue; 
				
                try { 
					
                	fw = new FileWriter("student_manager_studentList.txt");
					String data = manager.outData(); // 리턴 받는 데이터 
					
					if (!data.equals("")) {
						fw.write(data);
						System.out.println(data);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
                finally {
                	try {fw.close();} catch (IOException e) {e.printStackTrace();}	
                }
			}
			else if (sel == 6) { // 로드 (불러오기)
				
				FileReader fr = null;
				BufferedReader br = null;
				try {
					
					File file = new File("student_manager_studentList.txt");
					
					if (file.exists()) {
						
						fr = new FileReader(file);
						br = new BufferedReader(fr);
						ArrayList<StudentVO> studentList = new ArrayList<StudentVO>();
						
						String line = br.readLine();
						int count = Integer.parseInt(line);
						
						for (int i = 0; i < count; i++) {
							StudentVO temp = new StudentVO();
							line = br.readLine();
							String value[] = line.split(",");
							temp.id = value[0];
							temp.pw = value[1];
							studentList.add(temp);
						}
						manager.loadStudent(studentList);
						
					}
					manager.printStudent();
					
				}
				catch (Exception e) {e.printStackTrace();}
				finally {
					try {br.close();} catch (IOException e) {e.printStackTrace();}
					try {fr.close();} catch (IOException e) {e.printStackTrace();}
				}
									
			}
			else if (sel == 7) {  // 종료 
				System.out.println("종료");
				break;
			}
		}
		
		scan.close();

	}

}
