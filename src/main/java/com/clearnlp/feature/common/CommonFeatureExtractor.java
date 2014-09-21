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
package com.clearnlp.feature.common;

import java.io.InputStream;

import org.w3c.dom.Element;

import com.clearnlp.component.state.SeqState;
import com.clearnlp.dependency.DEPNode;
import com.clearnlp.feature.AbstractFeatureExtractor;

/**
 * @since 3.0.0
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public class CommonFeatureExtractor extends AbstractFeatureExtractor<CommonFeatureTemplate,CommonFeatureToken,SeqState>
{
	private static final long serialVersionUID = -3522042349865325347L;

	public CommonFeatureExtractor(InputStream in)
	{
		super(in);
	}
	
	@Override
	protected CommonFeatureTemplate createFeatureTemplate(Element eFeature)
	{
		return new CommonFeatureTemplate(eFeature);
	}

	@Override
	protected String getFeature(CommonFeatureToken token, SeqState state, DEPNode node)
	{
		switch (token.getField())
		{
		case f : return node.getWordForm();
		case f2: return node.getSimplifiedForm();
		case m : return node.getLemma();
		case p : return node.getPOSTag();
		case n : return node.getNamedEntityTag();
		case d : return node.getLabel();
		case b : return getBooleanFeatureValue(token, state, node);
		case ft: return node.getFeat((String)token.getValue());
		default: return null;
		}
	}
	
	@Override
	protected String[] getFeatures(CommonFeatureToken token, SeqState state, DEPNode node)
	{
		switch (token.getField())
		{
		case ds  : return toLabelArray(node.getDependentList());
		case ds2 : return toLabelArray(node.getGrandDependentList());
		case orth: return getOrthographicFeatures(state, node);
		default  : return null;
		}
	}
	
	private String getBooleanFeatureValue(CommonFeatureToken token, SeqState state, DEPNode node)
	{
		int field = (int)token.getValue();
		boolean b = false;
		
		switch (field)
		{
		case  0: b = state.isFirstNode(node); break;
		case  1: b = state.isLastNode(node);  break;
		default: throw new IllegalArgumentException("Unsupported feature: b"+token.getValue());
		}
		
		return b ? Integer.toString(field) : null;
	}
}
