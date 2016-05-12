/**
 * 
 */
package br.com.amil.jtpp.modelo

/**
 * @author Robson Martins
 *
 */
class Morte {

	def mate(Jogador jogador){
		jogador.setQuantidadeMortes(jogador.getQuantidadeMortes()+1)
		jogador.morra()
	}
}
