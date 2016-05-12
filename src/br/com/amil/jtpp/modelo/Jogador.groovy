/**
 * 
 */
package br.com.amil.jtpp.modelo

/**
 * @author Robson Martins
 *
 */
class Jogador extends Assassino{

	def  morto = 0
	def  quemMeMatou
	
	def morra(){
		this.morto+=1;
	}
	
	
}
