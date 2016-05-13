/**
 * 
 */
package br.com.amil.jtpp.util

/**
 * @author Robson Martins
 * 
 *	FACTORY METHOD
 */
class Factory {

	public def newInstance(klass){
		def instance = klass.newInstance();
		instance
	}
}
