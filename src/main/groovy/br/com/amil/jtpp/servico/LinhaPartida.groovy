

/**
 * 
 */
package br.com.amil.jtpp.servico

import br.com.amil.jtpp.modelo.Partida;

/**
 * @author Robson Martins
 *
 */
class LinhaPartida extends Linha{
	
	def carrega(String[] linha){
		
		Partida partida = new Partida()
		partida.setData(obtemData(linha))
		partida.setIdSessao(linha[POSICAO_ID_SESSAO])
		
		partida
	}
	
	def carregaFinal(String[] linha){
		
		Partida partida = new Partida()
		partida.setData(obtemData(linha))
		partida.setIdSessao(linha[POSICAO_ID_SESSAO_FINAL])
		partida
	}
}
