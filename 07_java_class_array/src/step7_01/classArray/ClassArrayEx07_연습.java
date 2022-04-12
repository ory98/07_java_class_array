package step7_01.classArray;

//# 클래스 배열 응용

class Subject{
	
	String name;
	int score;
	
}


class Student{
	
	Subject[] subjects;	// Subject 객체를 담을 클래스 배열
	String name;
	
}


public class ClassArrayEx07_연습 {

	public static void main(String[] args) {

		Student[] studentList = new Student[3]; // 학생 배열을 3칸 만들어줌 
		
		studentList[0] = new Student(); // 과목(이름 + 성적) , 학생 이름 
		studentList[0].name = "학생0";  // 학생 이름  
		studentList[0].subjects = new Subject[3]; // 과목(이름 + 성적)배열을 3칸으로 나눠줌, 내용은 없음 
		
		for (int i = 0; i < 3; i++) {
			studentList[0].subjects[i] = new Subject(); // 내용을 채울 수 있는 자격을 줌 ( 가는 길을 알려줌)
			studentList[0].subjects[i].name = "학생0 과목" + i;
			studentList[0].subjects[i].score = 100;   // 학생0 과목0 , 100 / 학생0 과목1 , 100 / 학생0 과목2 , 100
		}
		
		studentList[1] = new Student(); // 과목(이름 + 성적) , 학생 이름
		studentList[1].name = "학생1";   // 학생 이름 
		studentList[1].subjects = new Subject[2]; // 과목(이름 + 성적) , 과목(이름 + 성적)배열을 2칸으로 나눠줌, 내용은 없음
		studentList[1].subjects[0] = new Subject(); // 내용을 채울 수 있는 자격을 줌 
		studentList[1].subjects[0].name = "학생1 과목0"; // 내용 채움 
		studentList[1].subjects[0].score = 100;
		
		studentList[1].subjects[1] = new Subject(); // 내용을 채울 수 있는 자격을 줌 
		studentList[1].subjects[1].name = "학생1 과목1";
		studentList[1].subjects[1].score = 100;
		
		studentList[2] = new Student(); // 과목(이름 + 성적) , 학생 이름
		studentList[2].name = "학생2"; // 학생 이름 
		studentList[2].subjects = new Subject[1]; // 과목(이름 + 성적)배열을 1칸으로 만들줌, 내용은 없음
		studentList[2].subjects[0] = new Subject(); // 내용을 채울 수 있는 자격을 줌
		studentList[2].subjects[0].name = "학생2 과목1"; // 내용 채움 
		studentList[2].subjects[0].score = 100;
		
		
		
		for (int i = 0; i < studentList.length; i++) {
			System.out.println("--- " + studentList[i].name + " ---");
			for (int j = 0; j < studentList[i].subjects.length; j++) {
				System.out.println(studentList[i].subjects[j].name  + " / " + studentList[i].subjects[j].score);
			}
			System.out.println();
		}
		
	}

}
