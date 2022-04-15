package step7_01.classArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class StudentEx{ // 아이디와 비밀번호 
	
	String id = "";
	String pw = "";
	
	void printData() {
		System.out.println("이름 : " + id + " 비밀번호 : " + pw);
		
	}
	
}

class Controller {
	
	StudentEx[] list = null; // ******
	int stdCnt = 0; // 학생수 
	
	void addStudentEx(StudentEx st) { // 입력값이 있고 결과값이 없는경우 > st는 void 안에서만 사용한다. 
		
		if (stdCnt == 0) { // 학생수가 0명일 경우 
			list = new StudentEx[1]; // 리스트 배열 1칸 만들어줌 
		}
		else if (stdCnt > 0) { // 0명 아닐 경우 
			StudentEx[] temp = list; // 임시 배열 만들어줌 임시 배열에 new StudentEx[1] 의 길을 넣어줌 
			list = new StudentEx[stdCnt + 1]; // list에는 (기존 배열칸+ 1)개의 칸으로 가는 길을 만들어줌 
			for (int i = 0; i < stdCnt; i++) { // i가 기존 배열의 기준으로 조건을 가져야 내용을 복사할 수 있음. 
				list[i] = temp[i]; // 템프 내용을 list에 넣어줌  
			}
			temp = null; // 임시 배열 비우기 
		}
		list[stdCnt] = st; // *********
		stdCnt++; 
		
	}
	
	
	
	StudentEx removeStudentEx (int index) { // 제거 인덱스
		
		StudentEx del_st = list[index]; // 이름 설정 
		if (stdCnt == 1) { // 학생이 한명일 경우 
			list = null; // 비워짐  
		}
		else if (stdCnt > 1) { // 한명 이상일 경우 
			StudentEx [] temp = list; // 
			list = new StudentEx[stdCnt -1]; // list에 [학생수-1]개수의 배열을 새로 넣음 
			for (int i = 0; i < index; i++) { // 
				list[i] = temp[i];
			}
			for (int i = index; i < stdCnt -1; i++) { // 자리를 옮긴다의 의미,,?*******
				list[i] = temp[i + 1];
			}
			temp = null;
		}
		stdCnt--;
		
		return del_st;  // 굳이 return을 안해주고 데이터만 삭제해주어도 되는데
						// 타 언어의 pop()메서드와 같이 삭제하는 데이터를 return하는 방식처럼 구현해본 예시
		
	}
	
	
	
	int checkId(StudentEx st) { // list[stdCnt] = st; 입력값도 있고 결과값도 있음. 
		
		int check = -1; 
		for (int i = 0; i < stdCnt; i++) {
			if (list[i].id.equals(st.id)) { // list[i]의 아이디와 st.id의 아이디를 비교하여 같을 경우 
				check = i; // check 는 i다 
				break; 
			}
		}
		return check; // 밑에 check값 대입 
		
	}
	
	
	
	void printStudentEx() { //  학생의 내용 복사,,?
		
		for (int i = 0; i < stdCnt ;i++) { // 범위에 있을때 
			list[i].printData(); // [i]번째 학생의 데이터를 복사해온다. 
		}
		
	}	
	
	
	
	String outData() { // 출력데이터 
		
		String data = ""; // 한글로 쓸 수 있게 해줌
		if (stdCnt == 0){ // 수가 없을 때 
			return data; // 입력한 데이터를 그대로 보냄 
		}
		data += stdCnt; // 데이터는 사람수만큼 출력 
		data += "\n"; // 한줄씩 띄어쓰기 
		for (int i = 0; i < stdCnt; i++) { // 범위안에 있을 경우
			data += list[i].id;  
			data += ",";
			data += list[i].pw;  // 아이디, 비밀번호 > 이렇게 출력 
			if (stdCnt - 1 != i) { // (학생 수-1) 이 i와 다를 경우 
				data += "\n"; // ***************
			}
		}
		return data; // 데이터 리턴 
		
	}
	
	
	
	void sortData() { // 정렬데이터 
		
		for (int i = 0; i < stdCnt; i++) { 
			for (int n= 0; n < stdCnt ; n++) { 
				if (list[i].id.compareTo(list[n].id) > 0) { // 아이디의 첫번째 글자들 기준으로 비교하여 나열 
					StudentEx temp = list[i]; // 임시배열에 [i]옮기고
					list[i] = list[n]; // [n] > [i] 자리에 옮기고 
					list[n] = temp; // [n] > [i] 옮기고 
				}
			}
		}
		
	}
	
	
	
	void loadStudentEx (StudentEx[] temp , int count) { //**********
		
		this.stdCnt = count; // 학생수는 열  
		this.list = temp;  
		
	}
	
}


public class ClassArrayEx09_연습해석 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Controller controller = new Controller(); // 이 안에서 컨트롤러를 쓸수 있다..? *******
		
		
		while (true) { // 반복적인 행위 > while 
			
			System.out.println("1.가입 2.탈퇴 3.정렬 4.출력 5.저장 6.로드 7.종료");
			int sel = scan.nextInt(); 
			
			if (sel == 1) { // 가입 
				
				StudentEx temp = new StudentEx(); // 내용을 넣을 수 있음 , temp > id, pw 
				System.out.println("[가입] id 를 입력하세요 >>> "); 
				temp.id = scan.next();	
				int check =  controller.checkId(temp); // 매서드 연결  ***************
				
				if (check == -1) { // 비어있다를 의미 ??********
					System.out.println("[가입] pw 를 입력하세요 >>> "); 
					temp.pw = scan.next(); 
					controller.addStudentEx(temp);	// 배열의 내용을 넣어주는 메서드  
					System.out.println(temp.id + "님 가입을 환영합니다."); 
				}
				else { //***********
					System.out.println("중복아이디 입니다.");
				}	
				
			}
			else if (sel == 2) { // 탈퇴 
				
				controller.printStudentEx(); // 입력된 학생의 배열 다 불러오기 
				StudentEx temp = new StudentEx(); // 임시 배열에 내용 넣을 수 있는 권한을 줌 
				System.out.println("[탈퇴] id 를 입력하세요 >>> "); 
				temp.id = scan.next();	// 아이디 입력 
				int check = controller.checkId(temp); // 
				
				if (check == -1) { // 그 인서트에 있는 정보가 없음 
					System.out.println("없는 아이디입니다.");
				}
				else { // 비어있지 않을 경우 
					StudentEx del_st = controller.removeStudentEx(check); // ***********
					System.out.println(del_st.id + "님 탈퇴 되었습니다."); 
				}
				
			}
			else if (sel == 3) { // 정렬 
				
				controller.sortData(); // 정렬 나열 
				controller.printStudentEx(); // 출력
 				
			}
			else if (sel == 4) { // 출력 > 정렬하기 전 출력하면 입력순으로 출력 , 정렬 후 출력하면 알파벳 순으로 출력 
				
				controller.printStudentEx(); // 출력 
				
			}
			else if (sel == 5) { // 저장 (파일에 저장)  
				
                if (controller.stdCnt == 0) continue; // 학생이 0명일 때 계속 진행 ? *******
				
                FileWriter fw = null; // 파일 생성 비우기 
                
                try { 
                	
					fw = new FileWriter("StudentEx_manager.txt"); // 텍스트 파일 저장 
					String data = controller.outData(); // 리턴 받은 데이터 
					if (!data.equals("")) { // 데이터가 비어있지 않을 경우 *************
						fw.write(data); // 파일에 데이터를 입력 
						System.out.println(data); // 화면에 데이터를 입력 
					}
					
				} catch (Exception e) { // 모든 에러 대응 
					e.printStackTrace();  // 나타내기 
				}
                finally { // 파일 닫기  
                	try {fw.close();} catch (IOException e) {e.printStackTrace();}	
                }
                
			}
			else if (sel == 6) { // 로드 (불러오기) 
				
				FileReader fr = null; // 파일을 불러오는 개체 
				BufferedReader br = null; // 텍스트를 불러오는 개체  
				
				try {
					
					File file = new File("StudentEx_manager.txt"); // ?? ***********
					
					if (file.exists()) { // 파일이 존재한다면 true 
						
						fr = new FileReader(file); 
						br = new BufferedReader(fr);
						
						String line = br.readLine(); // 한줄씩 불러오기 
						int count = Integer.parseInt(line); // 줄 개수를 글자 행으로 바꾸기..?**********
						StudentEx [] temp = new StudentEx[count]; // 임시 배열에 갯수 만큼의 배열을 넣기  
						
						for (int i = 0; i < count; i++) {
							temp[i] = new StudentEx(); // 내용넣기
							line = br.readLine(); // 텍스트를 한줄씩 가지오기 
							String[] value = line.split(","); // , 로 나누기 
							temp[i].id = value[0]; // 아이디는 0 배열에 넣기
							temp[i].pw = value[1]; // 비번은 1 배열에 넣기 
						}
						
						controller.loadStudentEx(temp , count);
						
					}
					
					controller.printStudentEx();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				finally {
					try {br.close();} catch (IOException e) {e.printStackTrace();}
					try {fr.close();} catch (IOException e) {e.printStackTrace();}
				}
									
			}
			else if (sel == 7) { // 종료 
				System.out.println("종료");
				break;
			}
			
		}

		scan.close();
		
	}

}
