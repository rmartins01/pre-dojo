/**
 * 
 */
package br.com.amil.jtpp.servico

/**
 * @author Robson Martins
 *
 */
abstract class Linha {
	
	static final POSICAO_DATA = 0
	static final POSICAO_HORA = 1
	static final POSICAO_HIFEN = 2
	static final POSICAO_NEW = 3
	static final POSICAO_MATCH = 4
	static final POSICAO_ID_SESSAO = 5
	static final POSICAO_ID_SESSAO_FINAL = 4
	static final POSICAO_NOME_ASSASSINO = 3
	static final POSICAO_KILLED = 4
	static final POSICAO_MORTO = 5
	static final POSICAO_ID_PARTIDA = 5
	static final POSICAO_USING = 6
	static final POSICAO_ARMA = 7
	
	abstract def carrega(String[] linha)
	
	def obtemData(String[] linha){
		linha[POSICAO_DATA] + " "+ linha[POSICAO_HORA]
	}
}
