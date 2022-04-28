package step7_01.classArray;

/*

# 제네릭(Generic)

- 클래스 내부에서 사용하는 데이터의 타입(Type)을 
  클래스의 인스턴스를 생성할 때 결정하는 것을 의미한다.
  
- 객체의 타입을 컴파일 시점에 체크하기 때문에 
  타입 안정성을 높이고 형 변환의 번거로움을 줄일 수 있다.

*/

class Employee {}
class Manager {}
class Supervisor {}

class GenericEx<T> {
	
	Object[] arr = new Object[3];
	int idx = 0;
	
	void add(T data) {
		arr[idx] = data;
		idx++;
	}
	
	T get(int index) {
		return (T)arr[index];
	}
	
}


public class ClassArrayEx11 {

	public static void main(String[] args) {
		
		GenericEx<Employee> employeeList = new GenericEx<Employee>();
		GenericEx<Manager> managerList = new GenericEx<Manager>();
		GenericEx<Supervisor> supervisorList = new GenericEx<Supervisor>();
		
		employeeList.add(new Employee());
		// employeeList.add(new Manager());
		// employeeList.add(new Supervisor());
		
		// managerList.add(new Employee());
		managerList.add(new Manager());
		// managerList.add(new Supervisor());
	
		// supervisorList.add(new Employee());
		// supervisorList.add(new Manager());
		supervisorList.add(new Supervisor());
		
		System.out.println(employeeList.get(0));
		System.out.println(managerList.get(0));
		System.out.println(supervisorList.get(0));
		
		
	}

}
