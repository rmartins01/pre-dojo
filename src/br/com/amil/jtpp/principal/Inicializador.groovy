package br.com.amil.jtpp.principal

import static br.com.amil.jtpp.util.Constantes.*
import static br.com.amil.jtpp.util.Log.info
import groovy.util.logging.Log;
import br.com.amil.jtpp.servico.JogoTiroPrimeiraPessoa;
import br.com.amil.jtpp.servico.JogoTiroPrimeiraPessoaImpl;
import br.com.amil.jtpp.servico.LeitorLog
import br.com.amil.jtpp.servico.LeitorLogImpl
import br.com.amil.jtpp.util.Factory;

class Inicializador {
	
	static main(args) {
		new Factory().newInstance(JogoTiroPrimeiraPessoaImpl).iniciaPartida();
	}

}
