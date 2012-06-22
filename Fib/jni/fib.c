#include "com_cisco_fib_FibLib.h"

JNIEXPORT jlong JNICALL Java_com_cisco_fib_FibLib_fibN
  (JNIEnv *env, jclass clazz, jlong n) {
	return fib(n);
}

jlong fib(jlong n) {
	if(n==0) return 0;
	if(n==1) return 1;
	return fib(n-1)+fib(n-2);
}
