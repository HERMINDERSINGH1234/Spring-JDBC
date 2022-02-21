package com.spring.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "My Program Started" );
        // spring jdbc-> JDBC Template
      //  ApplicationContext context= new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
        
        ApplicationContext context= new AnnotationConfigApplicationContext(JdbcConfig.class);
      //JdbcTemplate template= context.getBean("jdbcTemplate",JdbcTemplate.class);
      // insert query
     // String query="insert into student(id,name,city) values(?,?,?) ";
      
      // fire the query;
      // int result= template.update(query,343,"Manish Saxena","Kanpur");
      // System.out.println("number of record inserted.." + result);
        
      StudentDao studentDao= context.getBean("studentDao",StudentDao.class);
      // Insert
       Student student= new Student();
       student.setId(4342);
       student.setName("Sumit Singh");
       student.setCity("Lucknow");
       
       int result = studentDao.insert(student);
       System.out.println("number of record inserted.." + result);
        
        // for update 
//      Student student= new Student();
//      student.setId(343);
//      student.setName("Raj kumar");
//      student.setCity("Lucknow");
//      int result = studentDao.change(student);
//      System.out.println("number of record changed.." + result);
      
      // for Delete
      
       //int result = studentDao.delete(666);
       //System.out.println("number of record deleted.." + result);
      //DELETE DATA
//      Scanner sc=new Scanner(System.in);
//     
//      System.out.println("Enter the Student ID you want to Delete:");
//      int id=sc.nextInt();
//      
//      sc.close();
//      
//      int result=studentDao.delete(id);
//      System.out.println("No of Record deleted"+result);
      
      // select the single data
//      Student student = studentDao.getStudent(222);
//      System.out.println(student);
      
      List<Student> allStudents = studentDao.getAllStudents();
      for(Student s: allStudents) {
    	  System.out.println(s);
      }
    }
}
