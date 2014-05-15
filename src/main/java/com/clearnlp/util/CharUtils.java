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
package com.clearnlp.util;


/**
 * @since 3.0.0
 * @author Jinho D. Choi ({@code jdchoi77@gmail.com})
 */
public class CharUtils
{
	private CharUtils() {}
	
	/**
	 * @param start inclusive
	 * @param end inclusive
	 */
	public static boolean isRange(char c, int start, int end)
	{
		return start <= c && c <= end; 
	}
	
	/** {@code tIndex + sc.length <= tc.length}. */
	public static boolean regionMatches(char[] source, char[] target, int sIndex)
	{
		if (source.length < sIndex+target.length) return false;
		int i, len = target.length;
		
		for (i=0; i<len; i++)
		{
			if (source[sIndex+i] != target[i])
				return false;
		}
		
		return true;
	}
	
//	----------------------------------- Alphabet -----------------------------------	
	
	/** {@link CharUtils#isWhiteSpace(char)} */
	public static boolean isWhiteSpace(char c)
	{
		return c == ' ' || c == '\t' || c == '\n' || c == '\r' || c == '\f' || c == '\u00A0' || c == '\u2028' || c == '\u2029';
	}
	
	public static boolean isAlphabet(char c)
	{
		return isUpperCase(c) || isLowerCase(c);
	}
	
	public static boolean isUpperCase(char c)
	{
		return isRange(c, 'A', 'Z');
	}
	
	public static boolean isLowerCase(char c)
	{
		return isRange(c, 'a', 'z');
	}
	
//	----------------------------------- Symbols -----------------------------------
	
	/** Punctuation in the standard ASCII. */
	public static boolean isPunctuation(char c)
	{
		return isRange(c, '!', '/') || isRange(c, ':', '@') || isRange(c, '[', '`') || isRange(c, '{', '~');	
	}
	
	/** Unicode: 2000 ~ 206F. */
	public static boolean isGeneralPunctuation(char c)
	{
		return isRange(c, '\u2000', '\u206F');
	}
	
	/** Unicode: '$', 00A2 ~ 00A5, 20A0 ~ 20CF. */
	public static boolean isCurrency(char c)
	{
		return (c == '$') || isRange(c, '\u00A2', '\u00A5') || isRange(c, '\u20A0', '\u20CF');
	}
	
	/** Unicode: 2190 ~ 21FF, 27F0 ~ 27FF, 2900 ~ 297F. */
	public static boolean isArrow(char c)
	{
		return isRange(c, '\u2190', '\u21FF') || isRange(c, '\u27F0', '\u27FF') || isRange(c, '\u2900', '\u297F');
	}
	
	/** Unicode: 3001 ~ 3003, 3008 ~ 301F. */
	public static boolean isCJKSymbol(char c)
	{
		return isRange(c, '\u3001', '\u3003') || isRange(c, '\u3008', '\u301F'); 
	}
	
	public static boolean isHyphen(char c)
	{
		return c == '-' || c == '~' || c == '\u2027' || isRange(c, '\u2010', '\u2015'); 
	}
	
	public static boolean isListMark(char c)
	{
		return c == '-' || c == '\u2022' || c == '\u2023' || c == '\u203B' || c == '\u2043';
	}
	
	public static boolean isFinalMark(char c)
	{
		return c == '.' || c == '?' || c == '!' || c == '\u203C' || isRange(c, '\u2047', '\u2049');
	}
	
	public static boolean isSeparatorMark(char c)
	{
		return c == ',' || c == ';' || c == ':' || c == '|' || c == '/' || c == '\\';
	}
	
	public static boolean isQuotationMark(char c)
	{
		return c == '`' || c == '\'' || c == '"' || isRange(c, '\u2018', '\u201F');
	}
	
//	----------------------------------- Bracket -----------------------------------
	
	public static boolean isBracket(char c)
	{
		return isLeftBracket(c) || isRightgBracket(c);
	}
	
	public static boolean isLeftBracket(char c)
	{
		return c == '(' || c == '{' ||c == '[';
	}
	
	public static boolean isRightgBracket(char c)
	{
		return c == ')' || c == '}' ||c == ']';
	}
	
//	----------------------------------- Digit -----------------------------------
	
	public static boolean isDigit(char c)
	{
		return 48 <= c && c <= 57;
	}
	
	public static boolean isPreDigitSymbol(char c)
	{
		return c == '.' || c == '-' || c == '+' || c == '\u00B1' ||	isRange(c, '\u2212', '\u2213') || isRange(c, '\u221A', '\u221C');
	}
	
	public static boolean containsOnlyDigits(String s)
	{
		return containsOnlyDigits(s.toCharArray());
	}
	
	public static boolean containsOnlyDigits(char[] cs)
	{
		for (char c : cs)
		{
			if (!isDigit(c))
				return false;
		}
		
		return true;
	}
}
