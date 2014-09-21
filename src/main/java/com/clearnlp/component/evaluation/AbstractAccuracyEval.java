/**
 * Copyright 2014, Emory University
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.clearnlp.component.evaluation;


/**
 * @since 3.0.0
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
abstract public class AbstractAccuracyEval<LabelType> extends AbstractEval<LabelType>
{
	protected int n_total;
	protected int n_correct;
	
	public AbstractAccuracyEval()
	{
		clear();
	}
	
	@Override
	public void clear()
	{
		n_total   = 0;
		n_correct = 0; 
	}
	
	@Override
	public double[] getScores()
	{
		return new double[]{getScore()};
	}
	
	@Override
	public double getScore()
	{
		return 100d * n_correct / n_total;
	}
	
	@Override
	public String toString()
	{
		return String.format("ACC: %5.2f (%d/%d)", getScore(), n_correct, n_total);
	}
}
