/**
 * 
 */
package br.com.amil.jtpp.modelo

/**
 * @author Robson Martins
 *
 */
class Jogador extends Assassino{

	Integer morto = 0
	Assassino quemMeMatou
	
	def morra(){
		this.morto+=1;
	}
	
	
}
