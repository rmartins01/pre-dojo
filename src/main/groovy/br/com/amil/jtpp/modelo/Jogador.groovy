/**
 * 
 */
package br.com.amil.jtpp.modelo

/**
 * @author Robson Martins
 *
 */
class Jogador extends Assassino{ 

	def quantasVezesMorreu = 0
	
	def morra(){
		this.quantasVezesMorreu+=1;
	}
	
	String toString() {(
		"Assassino [nome=" + nome + 
		", quantasVezesMatou=" + quantasVezesMatou + 
		", quantasVezesMorreu=" + quantasVezesMorreu +
		", armas=" + armas + 
		", award=" + award + 
		", streak=" + streak + 
		", dataHoraAssassinato=" + dataHoraAssassinato 
		+ "]")
	}
	
}
