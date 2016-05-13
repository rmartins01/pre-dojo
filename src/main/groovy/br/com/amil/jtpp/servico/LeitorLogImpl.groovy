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
		
		arquivo.eachLine { linha, nb ->
			
			//Analisa uma partida por vez
			if(linha.contains(NEW_MATCH) && linha.contains(HAS_STARTED) && !PARTIDA_EM_ANDAMENTO){
				PARTIDA_EM_ANDAMENTO = Boolean.TRUE
				info "Identificado nova partida"
				
				partida = factory.newInstance(LinhaPartida).carrega(linha.split(DELIMITADOR_ARQUIVO_LOG_JTPP))
				
			}else if(linha.contains(KILLED) && linha.contains(USING) && PARTIDA_EM_ANDAMENTO){
				
				if(partida != null){
					
					//Com uma partida em andamento, adiciona jogadores e suas operações
					new LinhaOperacao(partida).carrega(linha.split(DELIMITADOR_ARQUIVO_LOG_JTPP))
				}
				
			}else if(linha.contains(WORLD) && linha.contains(KILLED) && PARTIDA_EM_ANDAMENTO){
				
				if(partida != null){
					new LinhaOperacao(partida, Boolean.TRUE).carrega(linha.split(DELIMITADOR_ARQUIVO_LOG_JTPP))
				}
			}else if(linha.contains(MATCH) && linha.contains(HAS_ENDED) && PARTIDA_EM_ANDAMENTO){ //Finaliza o carregamento do Log
				
				Partida partidaFinal = factory.newInstance(LinhaPartida).carregaFinal(linha.split(DELIMITADOR_ARQUIVO_LOG_JTPP))
				
				//Verifica se está encerrando a partida em andamento, caso contrário continua
				if(partidaFinal.idSessao == partida.idSessao){
					
					partida.fimPartida = partidaFinal.data
					
					//Fim da partida, retorna o carregamento
					return partida
				}
			}
		}
		
		partida
	}
}
