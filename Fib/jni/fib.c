#include "com_cisco_fib_FibLib.h"

jlong fib(jlong n) {
	if (n == 0)
		return 0;
	if (n == 1)
		return 1;
	return fib(n - 1) + fib(n - 2);
}

JNIEXPORT jlong JNICALL Java_com_cisco_fib_FibLib_fibN(JNIEnv *env,
		jclass clazz, jlong n) {
	return fib(n);
}

JNIEXPORT jlong JNICALL Java_com_cisco_fib_FibLib_fibNI(JNIEnv *env,
		jclass clazz, jlong n) {
	jlong previous = -1;
	jlong result = 1;
	jlong i;
	for (i = 0; i <= n; i++) {
		jlong sum = result + previous;
		previous = result;
		result = sum;
	}
	return result;

}
