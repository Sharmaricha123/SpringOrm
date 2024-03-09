package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "welcome to spring orm project" );
        
        ApplicationContext context=new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
        StudentDao studentDao=context.getBean("studentDao",StudentDao.class);
        
//        Student student=new Student(2324,"Rich Sharma","Delhi");
//        int r=studentDao.insert(student);
//        System.out.println(r);
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        boolean go=true;
        while(go) {
        System.out.println("PRESS 1 for add new student");
        System.out.println("PRESS 2 for display all students");
        System.out.println("PRESS 3 for get detail of single student");
        System.out.println("PRESS 4 for delete students");
        System.out.println("PRESS 5 for update students");
        System.out.println("PRESS 6 for exit");
        
        try {
        	
        	int input=Integer.parseInt(br.readLine());
        	switch (input) {
			case 1:
//				insert student
				System.out.println("Enter user id");
				int uid=Integer.parseInt(br.readLine());
				System.out.println("Enter user name");
				String uName=br.readLine();
				System.out.println("Enter user city");
				String city=br.readLine();
				
				Student s=new Student();
				s.setStudentId(uid);
				s.setStudentName(uName);
				s.setStudentCity(city);
				
				int r=studentDao.insert(s);
				System.out.println(r + "student added");
				System.out.println("**************************************");
				System.out.println();
				break;
				
			case 2:
//				display all student
				System.out.println("***************************************");
				List<Student> students=studentDao.getAllStudents();
				for(Student st:students)
				{
				System.out.println(st);	
				}
				System.out.println("***************************************");
				break;
			case 3:
//				get single student
				System.out.println("***************************************");
				System.out.println("Enter user id");
				int userId=Integer.parseInt(br.readLine());
				Student student=studentDao.getStudent(userId);
				System.out.println(student);
				System.out.println("***************************************");
				break;
			case 4:
//				delete student
				System.out.println("***************************************");
				System.out.println("Enter user id");
				int id=Integer.parseInt(br.readLine());
				studentDao.deleteStudent(id);
				System.out.println("student deleted");
				
				
				System.out.println("***************************************");
				break;
			case 5:
//				update student
				System.out.println("***************************************");
				
				System.out.println("Enter user id:");
                int updateId = Integer.parseInt(br.readLine());
                Student existingStudent = studentDao.getStudent(updateId);
                if (existingStudent != null) {
                    System.out.println("Enter new user name:");
                    String newName = br.readLine();
                    System.out.println("Enter new user city:");
                    String newCity = br.readLine();

                    // Update student information
                    existingStudent.setStudentName(newName);
                    existingStudent.setStudentCity(newCity);
                    studentDao.updateStudent(existingStudent);
                    System.out.println("Student updated successfully");
                } else {
                    System.out.println("Student with ID " + updateId + " not found");
                }
				
				System.out.println("***************************************");
				break;
			
			case 6:
//				exit
				go=false;
				break;

			}
        }
        catch(Exception ex)
        {
        	System.out.println("Invalid Input!!!!!");
        	System.out.println(ex.getMessage());
        }
    }
        System.out.println("thankyou for using my application!!!!!");
    }
}
