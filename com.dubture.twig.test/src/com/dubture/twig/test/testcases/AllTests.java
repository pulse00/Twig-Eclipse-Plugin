package com.dubture.twig.test.testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TokenizerTest.class, TwigParserTest.class,
		TwigTextSequenceUtilitiesTest.class })
public class AllTests {

}
