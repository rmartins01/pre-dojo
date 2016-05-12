/**
 * 
 */
package br.com.amil.jtpp.servico

import static br.com.amil.jtpp.util.Constantes.*
import static br.com.amil.jtpp.util.Log.info
import static br.com.amil.jtpp.util.Log.info2
import static br.com.amil.jtpp.modelo.Partida.PARTIDA_EM_ANDAMENTO;
import br.com.amil.jtpp.modelo.Arma;
import br.com.amil.jtpp.modelo.Partida;
import br.com.amil.jtpp.util.Factory


/**
 * @author Robson Martins
 *
 *	Contem as regras de negócio e controla o fluxo de trabalho do jogo TPP
 */
class JogoTiroPrimeiraPessoaImpl implements JogoTiroPrimeiraPessoa{
	
	def iniciaPartida(){
		info ">>>>>>>====I N I C I A N D O  J O G O /T P P\\====<<<<<<<"
		
		LeitorLog leitor = factory.newInstance(LeitorLogImpl)
		Partida partida = leitor.carregaDadosParaOJava()
		resumoPartida(partida)
		terminaPartida()
	}

	def terminaPartida() {
		PARTIDA_EM_ANDAMENTO = Boolean.FALSE
		info ">>>>>>>====F I M  DO  J O G O  /T P P\\====<<<<<<<"
	}
	
	def resumoPartida(Partida partida){
		
		def assassino = partida.assassinos.sort { it.quantasVezesMatou }[partida.assassinos.size()-1]
		
		info2 "*****************************************************"
		info2 "Parida: " + partida.idSessao
		info2 "Início: " + partida.dataHoraInicioPartida
		info2 "Fim: " + partida.fimPartida
		
		info2 "---------------------RESUMO DA PARTIDA--------------------"
		info2 "Vencedor: " + assassino.nome
		info2 "Matou: " + assassino.quantasVezesMatou
		info2 "Morreu: " + assassino.quantasVezesMorreu
		info2 "Arma que ele mais utilizou: " + assassino.armaMaisUsada() +" vez(es)"
		info2 "Awards: " + assassino.award
		info2 "*****************************************************"
		
		info2 "----------------TODOS OS PARTICIPANTES---------------"
		partida.assassinos.each { 			
			
			info2 "Jogador: " + it.nome
			info2 "Matou: " + it.quantasVezesMatou
			info2 "Morreu: " + it.quantasVezesMorreu
			info2 "Arma que ele mais utilizou: " + it.armaMaisUsada() +" vez(es)"
			info2 "Awards: " + it.award
			
			info2 "*****************************************************"
		}
		
	}
	
	Factory factory = new Factory()
}
