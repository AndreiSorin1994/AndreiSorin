package hello;

import hello.models.Produs;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;

@RestController

public class ProdusController
{
	private List<Produs> produse = new ArrayList<Produs>();

	public ProdusController()
	{
		
		Produs p1 = new Produs(1,"Lion",50,2.5);
		Produs p2 = new Produs(2,"Snickers",50,3.0);

		produse.add(p1);
		produse.add(p2);
	}
	
	@RequestMapping(value = "/produs", method = RequestMethod.GET)
	public List<Produs> index()
	{
		return this.produse;
	}
	
	@RequestMapping(value = "/produs/{id}",method = RequestMethod.GET)
	public ResponseEntity show(@PathVariable("id") int id)
	{
		for(Produs p : this.produse)
		{
			if(p.getId() == id)
			{
				return new ResponseEntity<Produs>(p,new HttpHeaders(),HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>(null,new HttpHeaders(),HttpStatus.NOT_FOUND);
	}


	@RequestMapping(value="/produs/{id}", method = RequestMethod.DELETE)
  	public ResponseEntity remove(@PathVariable("id") int id)
	{
    		for(Produs p : this.produse) 
		{
     			if(p.getId() == id) 
			{
        			this.produse.remove(p);
        			return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      			}
    		}
    		return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  	}
	
	@RequestMapping(value="/produs/{id}",method = RequestMethod.PUT)
	public ResponseEntity update(@PathVariable("id") int id, @RequestParam("nume") String nume)
	{
		for(Produs p : this.produse)
		{
			if(p.getId() == id)
			{
				p.SchimbaNumeProdus(nume);
				return new ResponseEntity<Produs>(p,new HttpHeaders(),HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>(null,new HttpHeaders(),HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/produs",method = RequestMethod.POST)
	public ResponseEntity show(@RequestParam("id") String id, @RequestParam("nume") String nume, @RequestParam("cantitate") int cantitate, @RequestParam("pret") double pret)
	{
		Produs p = new Produs(200,"Borsec",2000,2.5);
		this.produse.add(p);
			return new ResponseEntity<Produs>(p,new HttpHeaders(),HttpStatus.OK);
	}
  }