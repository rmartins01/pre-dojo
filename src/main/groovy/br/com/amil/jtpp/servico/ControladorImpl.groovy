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
 */
class ControladorImpl implements Controlador{
	
	def iniciaPartida(){
		info ">>>>>>>====I N I C I A N D O  J O G O /T P P\\====<<<<<<<"
		
		LeitorLog leitor = factory.newInstance(LeitorLogImpl)
		Partida partida = leitor.carregaDadosParaOJava()
		resumoPartida(partida)
		terminaPartida()
	}

	def resumoPartida(Partida partida){
		
		info2 "*********************J O G O /T P P\\*********************"
		info2 "Parida: " + partida.idSessao
		info2 "Início: " + partida.data
		info2 "Fim: " + partida.fimPartida
		
		if(!partida.assassinos){
			info2 "---------------------NÃO HOUVE MORTES---------------------"
			return
		}
		
		def vencedor = partida.assassinos.sort { it.quantasVezesMatou }[partida.assassinos.size()-1]
		info2 "---------------------RESUMO DA PARTIDA--------------------"
		info2 "Vencedor: " + vencedor.nome
		info2 "Matou: " + vencedor.quantasVezesMatou
		info2 "Morreu: " + vencedor.quantasVezesMorreu
		info2 "Arma mais utilizada: " + vencedor.armaMaisUsada() +" vez(es)"
		info2 "Awards: " + vencedor.award
		info2 "Streak: " + vencedor.streak
		info2 "*****************************************************"
		
		info2 "-------------------------RESULTADO------------------------"
		partida.assassinos.each { 			
			
			if(it.podeMorrer){
				info2 "Jogador: " + it.nome
				info2 "Morreu: " + it.quantasVezesMorreu
				if(it.armas){
					info2 "Matou: " + it.quantasVezesMatou
					info2 "Arma mais utilizada: " + it.armaMaisUsada() +" vez(es)"
					info2 "Awards: " + it.award
					info2 "Streak: " + it.streak
				}
			}else{
				info2 "Imortal: " + it.nome
				info2 "Matou: " + it.quantasVezesMatou
				if(it.armas){
					info2 "Arma mais utilizada: " + it.armaMaisUsada() +" vez(es)"
				}
			}
			
			info2 "*****************************************************"
		}
	}
	
	def terminaPartida() {
		PARTIDA_EM_ANDAMENTO = Boolean.FALSE
		info ">>>>>>>====F I M  DO  J O G O  /T P P\\====<<<<<<<"
	}
	
	Factory factory = new Factory()
}
