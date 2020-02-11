package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class ExeTimeAspect {
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable{
		long start = System.nanoTime();
		try {
			Object result = joinPoint.proceed();
			return result;
		}
		finally {
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();//호출되는 메서드의 정보를 구한다.
			System.out.printf("%s, %s(%s) 실행시간 : %d ns\n",
					joinPoint.getTarget(/*대상 객체를 반환*/).getClass().getSimpleName(),
					sig.getName(/*메서드의 이름반환*/),
					Arrays.toString(joinPoint.getArgs()/*파라미터의 목록을 구함*/),
					(finish - start));
		}
	}
}
