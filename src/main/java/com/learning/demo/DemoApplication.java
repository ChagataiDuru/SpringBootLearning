package com.learning.demo;

import com.learning.demo.academic.AcademicRepository;
import com.learning.demo.academic.dao.ICourseRepository;
import com.learning.demo.user.UserDAO;
import com.learning.demo.user.entity.*;
import com.learning.demo.academic.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDAO userDAO, ICourseRepository iCourseRepository, AcademicRepository academicRepository){
		return runner -> {
			createThings(userDAO,iCourseRepository,academicRepository);
		};
	}

	public void createThings(UserDAO userDAO, ICourseRepository iCourseRepository, AcademicRepository academicRepository) {

		for(int i = 0; i < 5;i++){
			System.out.println("Creating new Student Object");
			User tempUser = new Student("Student"+ i,"A"+ i,"student@ozu.edu.tr","S029021");
			System.out.println("Saving Student...");
			userDAO.save(tempUser);
			System.out.println("Student with id" + tempUser.getId() + " saved");
		}
		for(int i = 0; i < 5;i++){
			System.out.println("Creating new Teacher Object");
			User tempUser = new Teacher("Teacher"+ i,"B"+ i,"instructor@ozyegin.edu.tr",34011);
			System.out.println("Saving Teacher...");
			userDAO.save(tempUser);
			System.out.println("Teacher with id" + tempUser.getId() + " saved");
			System.out.println("Creating new Course Object");
			Course tempCourse = new Course("Course"+i,tempUser);
			System.out.println("Saving Course...");
			iCourseRepository.save(tempCourse);
		}


		Optional<Course> res = iCourseRepository.findById(1);
		Course course;
		if (res.isPresent()){
			course = res.get();
		}else{
			throw new RuntimeException("Cant find the course id " + 1);
		}
		List<User> users = userDAO.findStudentsWithOzuEmail();
		academicRepository.registerStudents(course,users);

		for(int i = 0; i < 5;i++){
			System.out.println("Creating new Manager Object");
			User tempUser = new Manager("Manager"+ i,"C"+ i,"manager@ozyegin.edu.tr",246105);
			System.out.println("Saving Manager...");
			userDAO.save(tempUser);
			System.out.println("Manager with id" + tempUser.getId() + " saved");
		}

	}

}
