package com.nevexis.interceptor;

import com.nevexis.models.Sale;

public class InterceptorChainImpl implements InterceptorChain {

	private Interceptor firstInterceptor;

	public InterceptorChainImpl(Interceptor... interceptors) {
		if (interceptors.length < 1) {
			throw new Error("No interceptor passed");
		}

		firstInterceptor = interceptors[0];

		for (int i = 0; i + 1 < interceptors.length; i++) {
			interceptors[i].setNextInterceptor(interceptors[i + 1]);
		}
	}

	@Override
	public void invoke(Sale sale) {
		firstInterceptor.invoke(sale);
	}
}
