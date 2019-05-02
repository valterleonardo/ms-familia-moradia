package ms.familia.moradia.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ms.familia.moradia.dict.StatusFamilias;
import ms.familia.moradia.dict.TipoPessoas;
import ms.familia.moradia.interfaces.Dependente;
import ms.familia.moradia.interfaces.IdadeDependente;
import ms.familia.moradia.interfaces.IdadePretendente;
import ms.familia.moradia.interfaces.Pretendente;
import ms.familia.moradia.interfaces.QuantidadeDependentes;
import ms.familia.moradia.interfaces.Renda;
import ms.familia.moradia.models.Familias;
import ms.familia.moradia.models.FamiliasContempladas;
import ms.familia.moradia.models.Pessoas;
import ms.familia.moradia.models.Rendas;
import ms.familia.moradia.repository.TodasFamilias;
import ms.familia.moradia.services.rules.Dependentes0;
import ms.familia.moradia.services.rules.Dependentes1a2;
import ms.familia.moradia.services.rules.Dependentes3;
import ms.familia.moradia.services.rules.EhDependente;
import ms.familia.moradia.services.rules.EhPretendente;
import ms.familia.moradia.services.rules.Idade18;
import ms.familia.moradia.services.rules.Idade30;
import ms.familia.moradia.services.rules.Idade30a44;
import ms.familia.moradia.services.rules.Idade45;
import ms.familia.moradia.services.rules.Renda1501a2000;
import ms.familia.moradia.services.rules.Renda900;
import ms.familia.moradia.services.rules.Renda901a1500;
import ms.familia.moradia.util.Datas;

public class ProcessarPontuacaoPattern {
		
	private static Integer qtdeDependentes;
	private static Integer qtdeCriterios;
	private static Integer pontuacao;
	
	//IniciarRegras
	private static Renda rendaRule = iniciarRegraRenda();
	private static QuantidadeDependentes qtdeDepRule = iniciarRegraQtdeDep();
	private static Dependente depRule = iniciarRegraDep();
	private static Pretendente pretRule = iniciarRegraPret();
	private static IdadeDependente idadeDepRule = iniciarRegraIdadeDep();
	private static IdadePretendente idadePretRule = iniciarRegraIdadePret();
	
	@Autowired
	private static TodasFamilias todasFamilias;
	
	private final static Logger log = LoggerFactory.getLogger(ProcessarPontuacaoPattern.class);

	public static List<FamiliasContempladas> processaFamilias(List<Familias> familias) {
		
		log.info("Chain: Iniciando processamento para {} familias.",familias.size());
		List<FamiliasContempladas> resultado = new ArrayList<FamiliasContempladas>();
		Date data = new Date();	
		
		//percorrendo as familias
		for (Familias familia : familias) {
			log.info("Iniciando processamento para familia {}.",familia.getNome());
			FamiliasContempladas familiaProcessada = new FamiliasContempladas();
			Long rendaTotal = 0l;
			qtdeDependentes = 0;
			qtdeCriterios = 0;
			pontuacao = 0;
					
			//percorrendo pessoas da familia 
			for (Pessoas pessoa : familia.getPessoas()) {
				
				contarDependentes(pessoa.getTipoPessoas(), pessoa.getDataNascimento());
				pontuarPretendente(pessoa.getTipoPessoas(), pessoa.getDataNascimento());

				//percorrendo renda das pessoas
				for (Rendas renda : pessoa.getRendas()) {
					rendaTotal += renda.getValor();
				}
				
			}
			
			pontuarDependentes(qtdeDependentes);
			pontuarRenda(rendaTotal);
			
			
			
			familiaProcessada.setData(data);			
			familiaProcessada.setIdFamilia(familia.getId());
			familiaProcessada.setPontos(pontuacao);
			familiaProcessada.setCriteriosAtendidos(qtdeCriterios);
			
			log.info("Chain: Finanlizando processamento para familia {} com {} critérios atendidos e {} pontos realizados.",familia.getNome(), qtdeCriterios, familiaProcessada.getPontos());
			
			resultado.add(familiaProcessada);
			familia.setStatus(StatusFamilias.CONTEMPLADA.ordinal());		
		}

		Collections.sort(resultado);
		
		
		return resultado;
	}
	
	private static void pontuarRenda(Long rendaTotal) {
		
		Integer pontuacaoRenda = rendaRule.processar(rendaTotal);
		if(pontuacaoRenda > 0) {
			pontuacao += pontuacaoRenda;
			qtdeCriterios++;
		}		
	}

	private static void pontuarDependentes(Integer qtdeDependentes2) {
		 
		Integer pontuacaoDep = qtdeDepRule.processar(qtdeDependentes);
		if(pontuacaoDep > 0) {
			pontuacao += pontuacaoDep;
			qtdeCriterios++;
		}
	}

	private static void pontuarPretendente(TipoPessoas tp, Date dt) {
		
		if (pretRule.processar(tp)) {
			pontuacao += idadePretRule.processar(Datas.calcularIdade(dt));
			qtdeCriterios++;
		}
		
	}

	private static void contarDependentes(TipoPessoas tp, Date dt) {

		if (depRule.processar(tp) &&
				idadeDepRule.processar(Datas.calcularIdade(dt))) {
			qtdeDependentes++;
		}
	}

	private static IdadePretendente iniciarRegraIdadePret() {
		IdadePretendente iPret1 = new Idade45();
		IdadePretendente iPret2 = new Idade30a44();
		IdadePretendente iPret3  = new Idade30();
		iPret1.setNext(iPret2);
		iPret2.setNext(iPret3);
		
		return iPret1;
	}

	private static Pretendente iniciarRegraPret() {
		Pretendente pret = new EhPretendente();
		return pret;
	}

	private static IdadeDependente iniciarRegraIdadeDep() {		
		IdadeDependente idep = new Idade18();
		return idep;
	}

	private static Dependente iniciarRegraDep() {		
		Dependente dep = new EhDependente();		
		return dep;
	}

	private static Renda iniciarRegraRenda() {
		
		Renda renda1 = new Renda900();
		Renda renda2 = new Renda901a1500();
		Renda renda3 = new Renda1501a2000();
		renda1.setNext(renda2);
		renda2.setNext(renda3);		
		return renda1;		
	}
	
	private static QuantidadeDependentes iniciarRegraQtdeDep() {
		
		QuantidadeDependentes dep1 = new Dependentes0();
		QuantidadeDependentes dep2 = new Dependentes1a2();
		QuantidadeDependentes dep3 = new Dependentes3();
		dep1.setNext(dep2);
		dep2.setNext(dep3);
		
		return dep1;		
	}
}