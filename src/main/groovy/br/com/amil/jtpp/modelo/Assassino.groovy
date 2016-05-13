/**
 * 
 */
package br.com.amil.jtpp.modelo

import br.com.amil.jtpp.util.Factory;

/**
 * @author Robson Martins
 *
 */
abstract class Assassino implements Comparator<Integer>{
	
	def nome
	def quantasVezesMatou = 0
	def armas = [:]
	def award =0
	def streak = 0
	def dataHoraAssassinato
	def podeMorrer = Boolean.TRUE
	
	Morte usando(nome){
		
		if(armas[nome]){
			armas[nome] = armas[nome] + 1
		}else{
			armas[nome] = 1
		}
		
		this.quantasVezesMatou+=1
		
		new Factory().newInstance(Morte)
	}
	
	def armaMaisUsada(){
		armas.max {it.value}
	}
	
	def qtdArmaMaisUsada(){
		armas.max {it.value}.value
	}
	
	int compare(a, b) {
		if (a.quantasVezesMatou < b.quantasVezesMatou) {
		  return -1;
		} else if (a.quantasVezesMatou > b.quantasVezesMatou) {
		  return 1;
		} else {
		  return 0;
		}
	  }
}
