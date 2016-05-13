package br.com.amil.jtpp;

import static br.com.amil.jtpp.util.Log.info
import static org.junit.Assert.*

import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestName

import br.com.amil.jtpp.modelo.Arma
import br.com.amil.jtpp.modelo.Imortal
import br.com.amil.jtpp.modelo.Jogador
import br.com.amil.jtpp.modelo.Partida
import br.com.amil.jtpp.servico.ControladorImpl;

class PartidaTest  {

	@Test
	public void testObjetoPartida() {
		info "Testando objeto Partida simples"
		
		Jogador obama = new Jogador()
		obama.armas = ["M16" : 5, "AR15" : 10, "38" : 1, "Faca" : 2]
		obama.award = 2
		obama.quantasVezesMorreu = 18
		obama.quantasVezesMatou = 5
		def nomeJogar = "Obama" 
		obama.nome = nomeJogar
		obama.dataHoraAssassinato = "11/05/2016 23:00:00"
		info obama
		
		Jogador binLaden = new Jogador()
		binLaden.armas = ["M16" : 2]
		binLaden.award = 5
		binLaden.streak = 1
		binLaden.quantasVezesMorreu = 5
		binLaden.quantasVezesMatou = 18
		def nomeJogar2 = 'Bin Laden' 
		binLaden.nome = nomeJogar2
		binLaden.dataHoraAssassinato = "11/05/2016 23:01:00"
		info binLaden
		
		Jogador fioDoZoto = new Jogador()
		fioDoZoto.armas = ["Oitao" : 10]
		fioDoZoto.award = 4
		fioDoZoto.streak = 2
		fioDoZoto.quantasVezesMorreu = 1
		fioDoZoto.quantasVezesMatou = 8
		def nomeJogar3 = 'Fio do Zoto'
		fioDoZoto.nome = nomeJogar3
		fioDoZoto.dataHoraAssassinato = "11/05/2016 23:02:00"
		info fioDoZoto
		
		Partida partida = new Partida()
		partida.setIdSessao("123456")
		partida.data = "11/05/2016 10:55:59"
		partida.setFimPartida("11/05/2016 23:55:59")
		partida.setAssassinos([obama, binLaden, fioDoZoto])
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
		
		binLaden.usando(arma.nome).mate(obama);
		binLaden.usando(arma2.nome).mate(obama);
		obama.usando(arma.nome).mate(binLaden);
		obama.usando(arma2.nome).mate(binLaden);

		world.usando(armaWorld1.nome).mate(obama);
		world.usando(armaWorld2).mate(binLaden);
		world.usando(armaWorld3).mate(binLaden);
		world.usando(armaWorld3).mate(fioDoZoto);

		info obama
		info binLaden
		
		new ControladorImpl().resumoPartida(partida);
		
		assert binLaden.quantasVezesMorreu == 9
		assert binLaden.quantasVezesMatou == 20 
		assert binLaden.armas[arma.nome] == 3
		assert binLaden.qtdArmaMaisUsada() == 3
		assert binLaden.armaMaisUsada().key == "M16"
		assert binLaden.award == 5

		assert obama.quantasVezesMorreu == 21
		assert obama.quantasVezesMatou == 7 
		assert obama.armas[arma.nome] == 6
		assert obama.qtdArmaMaisUsada() == 10
		assert obama.armaMaisUsada().key == "AR15"
		assert obama.award == 2
		
		assert fioDoZoto.quantasVezesMorreu == 2
		assert fioDoZoto.quantasVezesMatou == 8
		assert fioDoZoto.armas[arma.nome] == null
		assert fioDoZoto.qtdArmaMaisUsada() == 10
		assert fioDoZoto.armaMaisUsada().key == "Oitao"
		assert fioDoZoto.award == 4

	}

}
