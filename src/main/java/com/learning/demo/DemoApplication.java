package com.learning.demo;

import com.learning.demo.academic.dao.ICourseRepository;
import com.learning.demo.academic.service.CourseService;
import com.learning.demo.academic.service.ICourseService;
import com.learning.demo.user.UserDAO;
import com.learning.demo.user.entity.*;
import com.learning.demo.academic.entity.*;
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
	public CommandLineRunner commandLineRunner(UserDAO userDAO,ICourseRepository iCourseRepository){
		return runner -> {
			createThings(userDAO,iCourseRepository);
		};
	}

	private void createThings(UserDAO userDAO,ICourseRepository iCourseRepository) {

		for(int i = 0; i < 5;i++){
			System.out.println("Creating new Student Object");
			User tempUser = new Student("Student"+Integer.toString(i),"A"+Integer.toString(i),"student@ozu.edu.tr","S029021");
			System.out.println("Saving Student...");
			userDAO.save(tempUser);
			System.out.println("Student with id" + tempUser.getId() + " saved");
		}
		for(int i = 0; i < 5;i++){
			System.out.println("Creating new Teacher Object");
			User tempUser = new Teacher("Teacher"+Integer.toString(i),"B"+Integer.toString(i),"instructor@ozyegin.edu.tr",34011);
			System.out.println("Saving Teacher...");
			userDAO.save(tempUser);
			System.out.println("Teacher with id" + tempUser.getId() + " saved");
			System.out.println("Creating new Course Object");
			Course tempCourse = new Course("Course"+i,tempUser);
			System.out.println("Saving Course...");
			iCourseRepository.save(tempCourse);
		}
		for(int i = 0; i < 5;i++){
			System.out.println("Creating new Manager Object");
			User tempUser = new Manager("Manager"+Integer.toString(i),"C"+Integer.toString(i),"manager@ozyegin.edu.tr",246105);
			System.out.println("Saving Manager...");
			userDAO.save(tempUser);
			System.out.println("Manager with id" + tempUser.getId() + " saved");
		}

	}

}
