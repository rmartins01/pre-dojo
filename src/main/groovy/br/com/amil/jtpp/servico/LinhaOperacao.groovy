

/**
 * 
 */
package br.com.amil.jtpp.servico

import br.com.amil.jtpp.modelo.Assassino;
import br.com.amil.jtpp.modelo.Jogador
import br.com.amil.jtpp.modelo.Partida

/**
 * @author Robson Martins
 *
 */
class LinhaOperacao extends Linha{
	
	def Partida partida
	def Boolean imortal
	
	LinhaOperacao(Partida partida){
		this.partida = partida
	}

	LinhaOperacao(Partida partida, Boolean imortal){
		this.partida = partida
		this.imortal = imortal
	}

	def carrega(String[] linha){
		
		def dataHoraAssassinato = linha[POSICAO_DATA] + " "+ linha[POSICAO_HORA]

		def nomeAssassino = linha[POSICAO_NOME_ASSASSINO]
		Assassino assassino = null
		
		if(imortal){
			assassino = partida.obtemImortal(nomeAssassino)
		}else{
			assassino = partida.obtemJogador(nomeAssassino)
		}
		
		assassino.dataHoraAssassinato = dataHoraAssassinato
		
		def nomeJogadorMorto = linha[POSICAO_MORTO]
		Jogador jogador = partida.obtemJogador(nomeJogadorMorto)
		jogador.setDataHoraAssassinato(dataHoraAssassinato)
		
		assassino.usando(linha[POSICAO_ARMA]).mate(jogador);
	}
	
}
