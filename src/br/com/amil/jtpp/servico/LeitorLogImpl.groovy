/**
 * 
 */
package br.com.amil.jtpp.servico

import static br.com.amil.jtpp.util.Constantes.*
import static br.com.amil.jtpp.util.Log.info
import static br.com.amil.jtpp.util.Log.erro
import static br.com.amil.jtpp.modelo.Partida.PARTIDA_EM_ANDAMENTO;
import br.com.amil.jtpp.modelo.Arma;
import br.com.amil.jtpp.modelo.Assassino;
import br.com.amil.jtpp.modelo.Jogador;
import br.com.amil.jtpp.modelo.Partida;
import br.com.amil.jtpp.util.Factory


/**
 * @author Robson Martins
 *
 */
class LeitorLogImpl extends LeitorLog{
	
	def carregaDadosParaOJava(){
		
		info "Iniciando leitura do arquivo: "+NOME_ARQUIVO_LOG_JTPP
		
		def Partida partida = null;
		arquivo.eachLine { linha, nb ->
			
			//Ignora mais de uma partida ao mesmo tempo
			if(linha.contains(NEW_MATCH) && linha.contains(HAS_STARTED) && !PARTIDA_EM_ANDAMENTO){
				PARTIDA_EM_ANDAMENTO = Boolean.TRUE
				info "Identificado nova partida"
				
				partida = criaPartida(linha.split(DELIMITADOR_ARQUIVO_LOG_JTPP))
				
			}else if(linha.contains(KILLED) && linha.contains(USING) && PARTIDA_EM_ANDAMENTO){
				
				if(partida != null){
					
					//Com uma partida em andamento, adiciona jogadores e suas operações
					partida.getAssassinos().put(carregaLinhaOperacao(linha.split(DELIMITADOR_ARQUIVO_LOG_JTPP)))
				}
				
			}else if(linha.contains(MATCH) && linha.contains(HAS_ENDED) && PARTIDA_EM_ANDAMENTO){ //Finaliza o carregamento do Log
				
				Partida partidaFinal = criaPartida(linha.split(DELIMITADOR_ARQUIVO_LOG_JTPP))
				
				//Verifica se está encerrando a partida em andamento, caso contrário continua
				if(partidaFinal.getIdSessao().equals(partida.getIdSessao()){
					
					//Fim da partida, retorna o carregamento
					return partida
				}
				
			}
		}
		
		return partida
	}
	
	Assassino carregaLinhaOperacao(String[] linhaPartida){

		def dataHoraAssassinato = linhaPartida[POSICAO_DATA] + " "+ linhaPartida[POSICAO_HORA]
		
		Jogador assassino = factory.newInstance(Jogador)
		assassino.setNome(linhaPartida[POSICAO_NOME_ASSASSINO])
		assassino.setDataHoraAssassinato(dataHoraAssassinato)
		
		Jogador jogador = factory.newInstance(Jogador)
		jogador.setNome(linhaPartida[POSICAO_MORTO])
		jogador.setQuemMeMatou(assassino)
		jogador.setDataHoraAssassinato(dataHoraAssassinato)
		
		assassino.usando(linhaPartida[POSICAO_ARMA]).mate(jogador);

		return assassino
	}
	
	Partida criaPartida(String[] linhaPartida){
		Partida partida = factory.newInstance(Partida)
		partida.setDataHoraInicioPartida(linhaPartida[POSICAO_DATA] + " "+ linhaPartida[POSICAO_HORA])
		partida.setIdSessao(linhaPartida[POSICAO_ID_SESSAO])
		
		return partida
	}
	
	Factory factory = new Factory()
}
