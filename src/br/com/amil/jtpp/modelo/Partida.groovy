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
	
	def idSessao
	def dataHoraInicioPartida
	def fimPartida
	def assassinos = [:]
	String toString() {
		"Partida [idSessao=" + idSessao + ", dataHoraInicioPartida=" + 
		dataHoraInicioPartida + ", fimPartida=" + fimPartida + ", assassinos=" + 
		assassinos + "]";
	}
	
	
}
