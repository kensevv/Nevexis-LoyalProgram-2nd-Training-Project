package com.nevexis.interceptor;

import com.nevexis.models.Sale;

public abstract class InterceptorImpl implements Interceptor {
	private Interceptor nextInterceptor;
	
	
	@Override
	public Interceptor getNextInterceptor() {
		return this.nextInterceptor;
	}

	@Override
	public void setNextInterceptor(Interceptor nextInterceptor) {
		this.nextInterceptor = nextInterceptor;
	}

	@Override
	public boolean hasNext() {
		return this.nextInterceptor != null;
	}

	@Override
	public void invoke(Sale sale) {
		process(sale);
		if(hasNext()) {
			getNextInterceptor().invoke(sale);
		}
	}

	@Override
	public abstract void process(Sale sale);
}
