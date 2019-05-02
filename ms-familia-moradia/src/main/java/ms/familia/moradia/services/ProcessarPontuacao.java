package ms.familia.moradia.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ms.familia.moradia.dict.TipoPessoas;
import ms.familia.moradia.models.Familias;
import ms.familia.moradia.models.FamiliasContempladas;
import ms.familia.moradia.models.Pessoas;
import ms.familia.moradia.models.Rendas;
import ms.familia.moradia.util.Datas;

public class ProcessarPontuacao {
		
	private static Integer qtdeDependentes;
	private static Integer qtdeCriterios;
	private static Integer pontuacao;
	
	private final static Logger log = LoggerFactory.getLogger(ProcessarPontuacao.class);

	public static List<FamiliasContempladas> processaFamilias(List<Familias> familias) {
		
		log.info("Iniciando processamento para {} familias.",familias.size());
		List<FamiliasContempladas> resultado = new ArrayList<FamiliasContempladas>();
		Date data = new Date();
		
		//percorrendo familia a familia
		for (Familias familia : familias) {
			log.info("Iniciando processamento para familia {}.",familia.getNome());
			FamiliasContempladas familiaProcessada = new FamiliasContempladas();
			Long rendaTotal = 0l;
			qtdeDependentes = 0;
			qtdeCriterios = 0;
			pontuacao = 0;
					
			//percorrendo pessoa a pessoa da familia 
			for (Pessoas pessoa : familia.getPessoas()) {
				
				processaDependentes(pessoa.getTipoPessoas(), pessoa.getDataNascimento());
				processaPretendentes(pessoa.getTipoPessoas(), pessoa.getDataNascimento());
											
				//percorrendo renda das pessoas
				for (Rendas renda : pessoa.getRendas()) {
					rendaTotal += renda.getValor();
				}
				
			}
			
			familiaProcessada.setData(data);			
			familiaProcessada.setIdFamilia(familia.getId());
			familiaProcessada.setPontos(calcularPontuacao(rendaTotal));
			familiaProcessada.setCriteriosAtendidos(qtdeCriterios);
			
			log.info("Finanlizando processamento para familia {} com {} critérios atendidos e {} pontos realizados.",familia.getNome(), qtdeCriterios, familiaProcessada.getPontos());
			
			resultado.add(familiaProcessada);
		}

		Collections.sort(resultado);
		return resultado;
	}
	
	private static Integer calcularPontuacao(Long rendaTotal) {
		Integer criterioRendaPontos = CriterioRenda.calcular(rendaTotal);
		Integer criterioDependentesPontos = CriterioDependentes.calcular(qtdeDependentes);
		
		if(criterioRendaPontos != 0)
			qtdeCriterios ++;
		if(criterioDependentesPontos != 0)
			qtdeCriterios ++;
		
		return criterioRendaPontos + criterioDependentesPontos + pontuacao;
	}

	private static void processaDependentes(TipoPessoas tipoPessoas, Date dataNascimento) {
		if (TipoPessoas.DEPENDENTE.equals(tipoPessoas)) {
			if (Datas.calcularIdade(dataNascimento) < 18) {
				qtdeDependentes++;
			}
		}
		
	}
	
	private static void processaPretendentes(TipoPessoas tipoPessoas, Date dataNascimento) {
		if (TipoPessoas.PRETENDENTE.equals(tipoPessoas)) {
			pontuacao += CriterioPretendentes.calcular(Datas.calcularIdade(dataNascimento));
			qtdeCriterios ++;
		}
		
	}
}