package hello.models;


public class Produs
{
	private int id;
	private String numeProdus;
	private int cantitate;
	private double pret;
	
	
	public Produs(int id,String numeProdus,int cantitate, double pret)
	{
		this.id = id;
		this.numeProdus = numeProdus;
		this.cantitate = cantitate;
		this.pret = pret;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumeProdus() {
		return numeProdus;
	}

	public void setNumeProdus(String numeProdus) {
		this.numeProdus = numeProdus;
	}

	public int getCantitate() {
		return cantitate;
	}

	public void setCantitate(int cantitate) {
		this.cantitate = cantitate;
	}

	public double getPret() {
		return pret;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}

	public int getId()
	{
		return id;
	}
	
	public void SchimbaNumeProdus(String numeProdus)
	{
		this.numeProdus = numeProdus;
	}
}
