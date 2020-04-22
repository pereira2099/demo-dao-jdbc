package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("=== TEST 1: department insert ===");
		Department newDepartment = new Department(null, "Music");
		departmentDao.insert(newDepartment);
		System.out.println("Insterted! New id = " + newDepartment.getId());
		
		System.out.println("=== TEST 2: department delete ===");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted!");
		
		System.out.println("=== TEST 3: department findById ===");
		System.out.print("Enter id for findById test: ");
		id = sc.nextInt();
		Department department = departmentDao.findById(id);
		System.out.println(department);
		
		System.out.println("=== TEST 4: department findAll ===");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 5: seller update ===");
		department = departmentDao.findById(1);
		department.setName("Cars");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		sc.close();
	}
}
