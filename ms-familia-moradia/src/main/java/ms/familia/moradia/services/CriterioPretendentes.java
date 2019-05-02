package ms.familia.moradia.services;

public class CriterioPretendentes {

	public static Integer calcular(Integer valor) {
		
		if ( valor >= 45 ) {
			return 3;			
		}else if ( valor >= 30 ) {
			return 2;
		}else {
			return 1;
		}
	}
}
