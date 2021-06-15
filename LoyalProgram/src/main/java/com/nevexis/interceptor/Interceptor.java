package com.nevexis.interceptor;

import com.nevexis.models.Sale;

public interface Interceptor {
	public abstract Interceptor getNextInterceptor();

	public abstract void setNextInterceptor(Interceptor nextInterceptor);

	public abstract boolean hasNext();

	public abstract void process(Sale sale);
	
	public abstract void invoke(Sale sale);
}
