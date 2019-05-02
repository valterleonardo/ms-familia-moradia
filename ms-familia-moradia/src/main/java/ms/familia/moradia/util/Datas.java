package ms.familia.moradia.util;

import java.util.Calendar;
import java.util.Date;

public class Datas {

	public static Integer calcularIdade(Date data) {
		
		Calendar dataNascimento = Calendar.getInstance();  
	    dataNascimento.setTime(data); 
	    Calendar hoje = Calendar.getInstance();  

	    int idade = hoje.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR); 

	    if (hoje.get(Calendar.MONTH) < dataNascimento.get(Calendar.MONTH)) {
	    	idade--;  
	    } else if (hoje.get(Calendar.MONTH) == dataNascimento.get(Calendar.MONTH) &&
	    		hoje.get(Calendar.DAY_OF_MONTH) < dataNascimento.get(Calendar.DAY_OF_MONTH)) {
	            
	    	idade--; 
	    }	   
	    
		return idade;
	}
}
