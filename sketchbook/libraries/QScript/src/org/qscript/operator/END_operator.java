/*
 * Copyright (c) 2014 Peter Lager
 * <quark(a)lagers.org.uk> http:www.lagers.org.uk
 * 
 * This software is provided 'as-is', without any express or implied warranty.
 * In no event will the authors be held liable for any damages arising from
 * the use of this software.
 * 
 * Permission is granted to anyone to use this software for any purpose,
 * including commercial applications, and to alter it and redistribute it freely,
 * subject to the following restrictions:
 * 
 * 1. The origin of this software must not be misrepresented;
 * you must not claim that you wrote the original software.
 * If you use this software in a product, an acknowledgment in the product
 * documentation would be appreciated but is not required.
 * 
 * 2. Altered source versions must be plainly marked as such,
 * and must not be misrepresented as being the original software.
 * 
 * 3. This notice may not be removed or altered from any source distribution.
 */

package org.qscript.operator;

import org.qscript.Argument;
import org.qscript.FlowAction;
import org.qscript.Script;
import org.qscript.Token;
import org.qscript.Variable;
import org.qscript.errors.EvaluationException;

/** 
 * This class defines the END(value) is used to end the 
 * algorithm and return a value. <br>
 * 
 * Simple expressions will not need this but multi-expression scripts
 * can use this to terminate execution at any point in the algorithm. <br>
 * 
 * When executed the algorithm execution stops normally i.e. without
 * generating an error.
 * 
 * This operator requires a single parameter of any type which will be 
 * the 'result' of the expression.
 *  
 * @author Peter Lager
 *
 */
public class END_operator extends FlowOperator {

	public END_operator(String symbol, int nbrArgs, int priority, int type) {
		super(FlowOperatorType.END, symbol, nbrArgs, priority, type);
	}

	@Override
	public Argument resolve(Script script, Token token, Argument[] args, Object...objects) 
			throws EvaluationException {
		Argument a0 = args[0];
		if(a0.isVariable())
			a0 = script.getVariable((Variable)a0);
		return new FlowAction(FlowAction.END, a0);
	}
}
