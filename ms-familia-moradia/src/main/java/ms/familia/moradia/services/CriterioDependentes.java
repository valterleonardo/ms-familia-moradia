package ms.familia.moradia.services;

public class CriterioDependentes {

	public static Integer calcular(Integer valor) {
		
		if ( valor >= 3 ) {
			return 3;			
		}else if ( valor > 0 ) {
			return 2;
		}else {
			return 0;
		}	
	}
}
