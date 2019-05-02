package ms.familia.moradia.services;

public class CriterioRenda {

	public static Integer calcular(Long valor) {
		
		if ( valor <= 900 ) {
			return 5;			
		}else if ( valor <= 1500 ) {
			return 3;
		}else if ( valor <= 2000) {
			return 1;
		}else {
			return 0;
		}
	}
}
