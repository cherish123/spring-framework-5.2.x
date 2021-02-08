package org.example.lambda07;

import java.util.function.Predicate;

public class Test07 {
	public static void main(String[] args) {
		String something = "舌苔润";
		String something1 = "舌苔薄";
		//todo lambda表达式 predicate
		boolean healthy = predicate("花斑舌",(String some)->{
			return something.equals(some);
		});
		System.out.println("舌苔是否正常: "+healthy);
		//todo lambda表达式 predicate and
		boolean healthyAnd = andPredicate("",some->something.equals(some),some->something1.equals(some));
		System.out.println("舌苔是否正常And: "+healthyAnd);
		//todo lambda表达式 predicate or
		boolean healthyOr = orPredicate("",some->something.equals(some),some->something1.equals(some));
		System.out.println("舌苔是否正常Or: "+healthyOr);
		//todo lambda表达式 predicate negate
		boolean healthyNeg = negPredicate("花斑舌",some->something.equals(some));
		System.out.println("舌苔是否正常neg: "+healthyNeg);
	}

	private static boolean predicate(String something, Predicate<String> predicate){
		return predicate.test(something);
	}

	private static boolean andPredicate(String something, Predicate<String> predicate1, Predicate<String> predicate2){
		return predicate1.and(predicate2).test(something);
	}

	private static boolean orPredicate(String something, Predicate<String> predicate1, Predicate<String> predicate2){
		return predicate1.or(predicate2).test(something);
	}

	private static boolean negPredicate(String something, Predicate<String> predicate){
		return predicate.negate().test(something);
	}

}
