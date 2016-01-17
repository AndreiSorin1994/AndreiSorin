package hello;

import hello.models.ContBancar;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;
@CrossOrigin


@RestController
public class ContBancarController
{
	private List<ContBancar> conturi = new ArrayList<ContBancar>();

	public ContBancarController()
	{
		
		ContBancar cont1 = new ContBancar(1,100.0);
		ContBancar cont2 = new ContBancar(2,250.0);
		ContBancar cont3 = new ContBancar(3,400.0);

		conturi.add(cont1);
		conturi.add(cont2);
		conturi.add(cont3);
	}
	
	@RequestMapping(value = "/cont", method = RequestMethod.GET)	
	public List<ContBancar> index3()
	{
		return this.conturi;
	}
	
	@RequestMapping(value = "/cont/{id}",method = RequestMethod.GET)
	public ResponseEntity show3(@PathVariable("id") int id)
	{
		for(ContBancar c : this.conturi)
		{
			if(c.getId() == id)
			{
				return new ResponseEntity<ContBancar>(c,new HttpHeaders(),HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>(null,new HttpHeaders(),HttpStatus.NOT_FOUND);
	}


	@RequestMapping(value="/cont/{id}", method = RequestMethod.DELETE)
  	public ResponseEntity remove3(@PathVariable("id") int id) 
	{
    		for(ContBancar c : this.conturi) 
		{
     			if(c.getId() == id) 
			{
        			this.conturi.remove(c);
        			return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      			}
    		}
    		return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  	}
	
	@RequestMapping(value="/cont/{id}",method = RequestMethod.PUT)
	public ResponseEntity update3(@PathVariable("id") int id, @RequestParam("suma") double suma)
	{
		for(ContBancar c : this.conturi)
		{
			if(c.getId() == id)
			{
				c.AdaugaBani(suma);
				return new ResponseEntity<ContBancar>(c,new HttpHeaders(),HttpStatus.OK);
			}
		}
		return new ResponseEntity<String>(null,new HttpHeaders(),HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/cont",method = RequestMethod.POST)
	public ResponseEntity show3(@RequestParam("id") int id, @RequestParam("suma") double suma)
	{
		ContBancar c = new ContBancar(id, suma);
		this.conturi.add(c);
			return new ResponseEntity<ContBancar>(c,new HttpHeaders(),HttpStatus.OK);
	}
  }