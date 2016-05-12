/**
 * 
 */
package br.com.amil.jtpp.modelo

/**
 * @author Robson Martins
 *
 */
class Partida {
	
	static def PARTIDA_EM_ANDAMENTO = Boolean.FALSE
	
	String idSessao
	String dataHoraInicioPartida
	String fimPartida
	Map assassinos
}
