package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1: department findById ====");
		Department department = departmentDao.findById(3);
		System.out.println(department);
		
		System.out.println("\n==== TEST 2: department findAll ====");
		List<Department> list = departmentDao.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST 3: department Insert ====");
		Department newDepartment = new Department(null, "Glasses");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("\n==== TEST 4: department Update ====");
		department = departmentDao.findById(6);
		department.setName("Cosmetics");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("\n==== TEST 5: department Delete ====");
		System.out.print("Enter id for delete test: ");
		int id = scanner.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		scanner.close();
	}

}
