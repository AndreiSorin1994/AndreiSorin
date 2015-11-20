package hello.models;
import java.util.List;
import java.util.ArrayList;

public class Student
{
	private int id = 0;
	private String nume;
 	private int varsta;
	private String hobby;

	public Student()	{}
	public Student(int inputId,String inputNume,int inputVarsta,String inputHobby)
	{
		nume = inputNume;
		varsta = inputVarsta;
		id = inputId;
		hobby = inputHobby;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String ReturnNume()
	{
		return this.nume;
	}
	
	public int ReturnVarsta()
	{
		return this.varsta;
	}
	public String ReturnHobby()
	{
		return this.hobby;
	}
	public int getId()
	{
		return this.id;
	}
	public void ChangeHobby(String hobby){
		this.hobby = hobby;
	}

			
}
