package hello;

import hello.models.Student;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController

public class StudentController
{
	private List<Student> students = new ArrayList<Student>();
	
	public StudentController()
	{
		Student s1 = new Student(1,"Andrei",21,"Fotbal");
		Student s2 = new Student(2,"Sorin",23,"Soccer");
		Student s3 = new Student(3,"Cosmin",30,"Painting");
		Student s4 = new Student(4,"George",25,"Baseball");
		
		

		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public List<Student> index()
	{
		return this.students;
	}
	
	@RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
	public ResponseEntity show(@PathVariable("id") int id)
	{
		for(Student s : this.students)
		{
			if(s.getId() == id)
			{
				return new ResponseEntity<Student>(s,new HttpHeaders(),HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>(null,new HttpHeaders(),HttpStatus.NOT_FOUND);
	}


	@RequestMapping(value="/student/{id}", method = RequestMethod.DELETE)
  	public ResponseEntity remove(@PathVariable("id") int id)
	{
    		for(Student s : this.students) 
		{
     			if(s.getId() == id) 
			{
        			this.students.remove(s);
        			return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      			}
    		}
    		return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  	}
	
	@RequestMapping(value="/student/{id}",method = RequestMethod.PUT)
	public ResponseEntity update(@PathVariable("id") int id, @RequestParam("hobby")String hobby)
	{
		for(Student s : this.students)
		{
			if(s.getId() == id)
			{
				s.ChangeHobby(hobby);
				return new ResponseEntity<Student>(s,new HttpHeaders(),HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>(null,new HttpHeaders(),HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/student",method = RequestMethod.POST)
	public ResponseEntity show(@RequestParam("id") int id,@RequestParam("nume") String nume, @RequestParam("varsta") int varsta,@RequestParam("hobby") String hobby )
	{
		Student s = new Student(id,nume,varsta,hobby);
		this.students.add(s);
			return new ResponseEntity<Student>(s,new HttpHeaders(),HttpStatus.OK);
	}
  }


	
	