
/**
 * 
 */
package br.com.amil.jtpp.servico

import static br.com.amil.jtpp.util.Constantes.*
import static br.com.amil.jtpp.util.Log.info
import static br.com.amil.jtpp.util.Log.erro
import java.io.File;
import br.com.amil.jtpp.util.Factory

/**
 * @author Robson Martins
 *
 */
abstract class LeitorLog {

	protected File arquivo = new File(NOME_ARQUIVO_LOG_JTPP)

	LeitorLog(){
		if(!arquivo.exists()){
			erro "Arquivo não encontrado"
			return null;
		}
	}

	abstract def carregaDadosParaOJava()
}
