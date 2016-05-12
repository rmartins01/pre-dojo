/**
 * 
 */
package br.com.amil.jtpp.servico

import static br.com.amil.jtpp.util.Constantes.*
import static br.com.amil.jtpp.util.Log.info
import static br.com.amil.jtpp.modelo.Partida.PARTIDA_EM_ANDAMENTO;
import br.com.amil.jtpp.util.Factory


/**
 * @author Robson Martins
 *
 *	Contem as regras de negócio e controla o fluxo de trabalho do jogo TPP
 */
class JogoTiroPrimeiraPessoaImpl implements JogoTiroPrimeiraPessoa{
	
	def iniciaPartida(){
		info(">>>>>>>====I N I C I A N D O  J O G O /T P P\\====<<<<<<<")
		
		LeitorLog leitor = factory.newInstance(LeitorLogImpl)
		leitor.carregaDadosParaOJava()
		
		

		terminaPartida()
	}

	
	def terminaPartida() {
		PARTIDA_EM_ANDAMENTO = Boolean.FALSE
		info(">>>>>>>====F I M  DO  J O G O  /T P P\\====<<<<<<<")
		
//		apresentaResumoDaPartida()
	}
	
	Factory factory = new Factory()
}
