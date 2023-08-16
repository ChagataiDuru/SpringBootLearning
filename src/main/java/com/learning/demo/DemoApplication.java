package com.learning.demo;

import com.learning.demo.user.UserDAO;
import com.learning.demo.user.entity.Student;
import com.learning.demo.user.entity.Teacher;
import com.learning.demo.user.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDAO userDAO){
		return runner -> {
			createStudent(userDAO);
		};
	}

	private void createStudent(UserDAO userDAO) {
		System.out.println("Creating new Student Object");
		User tempStudent = new Student("Deneme","Soyad","student2@ozu.edu.tr","S029021");
		User temp2Student = new Student("Deneme","Soyad","student2@ozu.edu.tr","S029021");
		User temp3Student = new Teacher("Hoca","Test","hoca@ozu.edu.tr",246104);

		System.out.println("Saving Student...");
		userDAO.save(tempStudent);
		userDAO.save(temp2Student);
		userDAO.save(temp3Student);

		System.out.println("Student with id" + tempStudent.getId() + " saved");
	}

}
