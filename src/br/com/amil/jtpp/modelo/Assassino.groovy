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
	
	String nome
	Integer quantidadeMortes = 0
	Map armas = [:]
	Integer award =0
	String dataHoraAssassinato
	
	Morte usando(nome){
		
		if(this.armas.empty){
			this.armas.put(nome, 1)
		}else{
		
			if(this.armas.get(nome) != null)
				this.armas.put(nome, this.armas.get(nome) + 1) 
		}

		new Factory().newInstance(Morte)
	}
	
}
