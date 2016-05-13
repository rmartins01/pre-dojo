/**
 * 
 */
package br.com.amil.jtpp.util

import java.util.logging.Level;

/**
 * @author Robson Martins
 *
 */
@groovy.util.logging.Log
class Log {

	static def info(def msg){
		log.info " >>> "+msg +" <<< "
	}
	
	static def info2(def msg){
		println " * " + msg 
	}
	
	static def erro(def msg){
		log.log(Level.OFF, " ### "+msg+" ### ")
	}
}
