package com.cisco.fib;

public class FibLib {

	public static long fibJ(long n) {
		if(n==0) return 0;
		if(n==1) return 1;
		return fibJ(n-1)+fibJ(n-2);
	}
	
    public static long fibJI(long n) {
        long previous = -1;
        long result = 1;
        for (long i = 0; i <= n; i++) {
            long sum = result + previous;
            previous = result;
            result = sum;
        }
        return result;
    }


	static { System.loadLibrary("fib"); }
	public static native long fibN(long n);
	public static native long fibNI(long n);

}
