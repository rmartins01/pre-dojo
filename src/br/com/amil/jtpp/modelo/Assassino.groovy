/**
 * 
 */
package br.com.amil.jtpp.modelo

import br.com.amil.jtpp.util.Factory;

/**
 * @author Robson Martins
 *
 */
abstract class Assassino {
	
	def nome
	def quantidadeMortes = 0
	def armas = [:]
	def award =0
	def dataHoraAssassinato
	
	Morte usando(nome){
		
		if(armas){
			armas[nome] = armas[nome] + 1
		}else{
			armas[nome] = 1
		}

		new Factory().newInstance(Morte)
	}

	String toString() {
		"Assassino [nome=" + nome + ", quantidadeMortes=" + 
		quantidadeMortes + ", armas=" + armas + ", award=" + 
		award + ", dataHoraAssassinato=" + dataHoraAssassinato + "]"
	}
	
}
