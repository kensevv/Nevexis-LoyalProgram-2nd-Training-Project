package com.nevexis.interceptor;

import com.nevexis.models.Sale;

public interface InterceptorChain {

	public abstract void invoke(Sale sale);
}