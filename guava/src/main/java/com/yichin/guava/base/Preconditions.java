package com.yichin.guava.base;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.base.Stopwatch;

public class Preconditions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// checkNotNull
		// throw NPE
		/*
		Car badCar = new Car(null);
		badCar.drive();
		*/
		
		// checkArguement, checkState
		/*
		Car car = new Car(new HashMap<String, String>());
		// throw illegalArguementException
		//car.drive();
		
		car.speed = 22.0;
		// throw illegalStateException
		//car.drive();
		
		car.isRunning = true;
		car.drive();
		*/
		
		/*
		Preconditions p = new Preconditions();
		p.stringHelper();
		*/
		
		// Stopwatch
		/*
		Stopwatch sw = Stopwatch.createStarted();
		long mills = sw.elapsed(TimeUnit.MICROSECONDS);
		long nano = sw.elapsed(TimeUnit.NANOSECONDS);
		System.out.println(mills);
		System.out.println(nano);
		*/
		
		// Splitter
		/*
		System.out.println(
				Splitter.on(',')
				.omitEmptyStrings()
				.trimResults()
				.split(" foo\t\n, \t\n , \n\tbar, \t\nquux,")
		);
		*/
		
		// String Joiner
		/*
		// empty string is still there
		System.out.println(
				Joiner.on(',').skipNulls().join("yoy", null , "aa", "", "b")
				);
		System.out.println(
				Joiner.on(',').useForNull("shit").join("yoy", null , "aa", "", "b")
				);		
		*/
		
		// CharMatcher
		/*
		// scrub a user id
		String userId = "abc1-23456de--fg789";
		// 保留數字跟-兩種狀況only
		System.out.println( CharMatcher.DIGIT.or(CharMatcher.is('-')).retainFrom(userId) );
		// remove跟retain剛好相反
		System.out.println( CharMatcher.anyOf("ab").removeFrom("abcdbaggbbaaa") );
		System.out.println( CharMatcher.ANY.matches('a') );
		System.out.println( CharMatcher.INVISIBLE.matchesAllOf("\n \t ") );
		// 要先大寫再大寫
		System.out.println((int) ('A'));
		System.out.println((int) ('Z'));
		System.out.println((int) ('a'));
		System.out.println((int) ('z'));
		System.out.println( CharMatcher.inRange('A', 'z').matchesAnyOf("123456") );
		System.out.println( CharMatcher.anyOf("ab").trimTrailingFrom("abacatbab") );
		System.out.println( CharMatcher.anyOf("ab").trimFrom("abacatbab") );
		
		// 從後面開始查  走到d發現不match d前面那個b就被保留住了
		System.out.println( CharMatcher.anyOf("ab").trimFrom("abacatbdab") );
		System.out.println( CharMatcher.anyOf("ab").trimLeadingFrom("abacatbab") );
		
		// return 第一個match
		System.out.println( CharMatcher.anyOf("ab").indexIn("abcdbagg") );
		System.out.println( CharMatcher.anyOf("ab").countIn("abcdbaggbbaaa") );
		
		System.out.println( CharMatcher.anyOf("ab").collapseFrom("abcdbaggbbaaa", 'Z') );
		// 多個match只會被一個取代
		System.out.println( CharMatcher.anyOf("ab").replaceFrom("abcdbaggbbaaa", 'Z') );
		// 最前面跟最後面的match會被trim掉
		System.out.println( CharMatcher.anyOf("ab").trimAndCollapseFrom("abcdbaggbtbaaa", 'Z') );
		*/
		
	}
	
	public void stringHelper(){
		System.out.println(Objects.toStringHelper(this.getClass()).add("cat", "BigCat").add("age", 5).omitNullValues().toString());
		
	}
}
