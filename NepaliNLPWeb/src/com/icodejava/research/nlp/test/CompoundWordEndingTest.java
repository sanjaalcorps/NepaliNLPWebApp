package com.icodejava.research.nlp.test;
import static org.hamcrest.CoreMatchers.is;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.icodejava.research.nlp.domain.CompoundWordEnding;

public class CompoundWordEndingTest {

	/**
	 * This test makes sure that we do not have duplicate entries in the CompoundWordEnding enumeration
	 */
	@Test
	public void test() {
		Map<String, String> cweMap = new HashMap<String, String>();
		int count=0;
		for(CompoundWordEnding cwe: CompoundWordEnding.values()) {
			
			
			cweMap.put(cwe.getNepaliWordEnding(), cwe.getNepaliWordEnding());
			
			System.out.println(cwe.getNepaliWordEnding() + " " + (++count) + " " + cweMap.size());
		}
		
		Assert.assertThat(CompoundWordEnding.values().length, is(cweMap.size()));
	}

}
