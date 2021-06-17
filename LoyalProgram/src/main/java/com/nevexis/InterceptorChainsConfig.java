package com.nevexis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nevexis.interceptor.AddPointsInterceptor;
import com.nevexis.interceptor.AgeBonusInterceptor;
import com.nevexis.interceptor.InterceptorChainImpl;
import com.nevexis.interceptor.UsePointsInterceptor;

@Configuration
public class InterceptorChainsConfig {
	
	@Bean("usePointsInterceptorChain")
	public InterceptorChainImpl usePointsInterceptorChain() {
		AgeBonusInterceptor ageBonusInterceptor = new AgeBonusInterceptor();
		AddPointsInterceptor addPointsInterceptor = new AddPointsInterceptor();
		UsePointsInterceptor usePointsInterceptor = new UsePointsInterceptor();

		return new InterceptorChainImpl(ageBonusInterceptor, addPointsInterceptor, usePointsInterceptor);
	}

	@Bean("dontUsePointsInterceptorChain")
	public InterceptorChainImpl dontUsePointsInterceptorChain() {
		AgeBonusInterceptor ageBonusInterceptor = new AgeBonusInterceptor();
		AddPointsInterceptor addPointsInterceptor = new AddPointsInterceptor();

		return new InterceptorChainImpl(ageBonusInterceptor, addPointsInterceptor);
	}
}
