package br.com.amil.jtpp.teste;

import static br.com.amil.jtpp.util.Log.info
import static org.junit.Assert.*

import org.junit.Test

import br.com.amil.jtpp.modelo.Arma
import br.com.amil.jtpp.modelo.Assassino
import br.com.amil.jtpp.modelo.Jogador
import br.com.amil.jtpp.modelo.Partida

class PartidaTest {

	@Test
	public void testObjetoPartida() {
		info "Testando objeto Partida simples"
		
		Assassino jogador = new Jogador()
		jogador.armas = ["M16" : 5, "AR15" : 10, "38" : 1, "Faca" : 2]
		jogador.award = 2
		jogador.quantidadeMortes = 18
		def nomeJogar = "Obama" 
		jogador.nome = nomeJogar
		jogador.dataHoraAssassinato = "11/05/2016 23:00:00"
		info jogador
		
		Assassino jogador2 = new Jogador()
		jogador2.setArmas(["M16" : 2])
		jogador2.setAward(0)
		jogador2.setQuantidadeMortes(5)
		def nomeJogar2 = 'Bin Laden' 
		jogador2.setNome(nomeJogar2)
		jogador2.setDataHoraAssassinato("11/05/2016 23:01:00")
		info jogador2
		
		Partida partida = new Partida()
		partida.setIdSessao("123456")
		partida.setDataHoraInicioPartida("11/05/2016 10:55:59")
		partida.setFimPartida("11/05/2016 23:55:59")
		partida.setAssassinos([nomeJogar : jogador, nomeJogar2 : jogador2])
		info partida
		
		Arma arma = new Arma()
		arma.nome = "M16"
		arma.quantidadeUsada = 1
		info arma
		
		jogador.usando(arma.nome).mate(jogador2);

		info jogador
		info jogador2
		
		assert true
	}

}
