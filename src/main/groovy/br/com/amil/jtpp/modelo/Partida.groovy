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
	def data
	def fimPartida
	def assassinos = []

	Jogador obtemJogador(String nome){
		Jogador jogador = this.assassinos.find{it.nome ==nome}
		if(jogador==null){
			jogador = new Jogador()
			jogador.nome = nome
			this.assassinos.add(jogador)
		}
		jogador
	}

	Imortal obtemImortal(String nome){
		Imortal imortal = this.assassinos.find{it.nome ==nome}
		if(imortal==null){
			imortal = new Imortal()
			imortal.nome = nome
			this.assassinos.add(imortal)
		}
		imortal
	}
	
	String toString() {
		("Partida [idSessao=" + idSessao + ", data=" + 
		data + ", fimPartida=" + fimPartida + ", assassinos=" + 
		assassinos + "]");
	}
	
	
}
