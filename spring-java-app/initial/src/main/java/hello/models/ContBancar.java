package hello.models;
import java.util.List;
import java.util.ArrayList;

public class ContBancar
{
	private int id;
	private double suma;
	
	public ContBancar()
	{
		id = 0;
		suma = 0;
	}
	
	public ContBancar(int inputId,double inputSuma)
	{
		id = inputId;
		suma = inputSuma;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSuma() {
		return suma;
	}

	public void setSuma(double suma) {
		this.suma = suma;
	}

	public int getId()
	{
		return id;
	}
	
	public double ReturnSuma()
	{
		return suma;
	}

	public void AdaugaBani(double inputSuma)
	{
		suma += inputSuma;
	}
	
	public void ScoateBani(double inputSuma)
	{
		suma -= inputSuma;
	}
}
	