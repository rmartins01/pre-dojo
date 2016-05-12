package br.com.amil.jtpp.servico

import static br.com.amil.jtpp.util.Log.info
import static org.junit.Assert.*

import org.junit.Test

import br.com.amil.jtpp.modelo.Arma
import br.com.amil.jtpp.modelo.Assassino
import br.com.amil.jtpp.modelo.Imortal;
import br.com.amil.jtpp.modelo.Jogador
import br.com.amil.jtpp.modelo.Partida

class PartidaTest {

	@Test
	public void testObjetoPartida() {
		info "Testando objeto Partida simples"
		
		Jogador jogador = new Jogador()
		jogador.armas = ["M16" : 5, "AR15" : 10, "38" : 1, "Faca" : 2]
		jogador.award = 2
		jogador.quantasVezesMorreu = 18
		jogador.quantasVezesMatou = 5
		def nomeJogar = "Obama" 
		jogador.nome = nomeJogar
		jogador.dataHoraAssassinato = "11/05/2016 23:00:00"
		info jogador
		
		Jogador jogador2 = new Jogador()
		jogador2.armas = ["M16" : 2]
		jogador2.award = 0
		jogador2.quantasVezesMorreu = 5
		jogador2.quantasVezesMatou = 18
		def nomeJogar2 = 'Bin Laden' 
		jogador2.nome = nomeJogar2
		jogador2.dataHoraAssassinato = "11/05/2016 23:01:00"
		info jogador2
		
		Partida partida = new Partida()
		partida.setIdSessao("123456")
		partida.setDataHoraInicioPartida("11/05/2016 10:55:59")
		partida.setFimPartida("11/05/2016 23:55:59")
		partida.setAssassinos([jogador, jogador2])
		info partida
		
		Arma arma = new Arma()
		arma.nome = "M16"
		info arma
		
		Arma arma2 = new Arma()
		arma2.nome = "FAL"
		info arma
		
		Arma armaWorld1 = new Arma()
		armaWorld1.nome = "DROWN"
		info armaWorld1
		
		Arma armaWorld2 = new Arma()
		armaWorld2.nome = "TRAP"
		info armaWorld2
		
		Arma armaWorld3 = new Arma()
		armaWorld3.nome = "FIRE PIT"
		info armaWorld3
		
		Imortal world = new Imortal()
		world.nome = "<WORLD>"
		
		jogador2.usando(arma.nome).mate(jogador);
		jogador2.usando(arma2.nome).mate(jogador);
		jogador.usando(arma.nome).mate(jogador2);
		jogador.usando(arma2.nome).mate(jogador2);

		world.usando(armaWorld1.nome).mate(jogador);
		world.usando(armaWorld2).mate(jogador2);
		world.usando(armaWorld3).mate(jogador2);

		info jogador
		info jogador2
		
		def armaMaisUsadaJogador2 =  jogador2.qtdArmaMaisUsada()
		
		new JogoTiroPrimeiraPessoaImpl().resumoPartida(partida);
		
		assert (jogador2.quantasVezesMorreu == 9 && jogador2.quantasVezesMatou == 20 
		&& jogador.armas[arma.nome] == 6)
	}

}
