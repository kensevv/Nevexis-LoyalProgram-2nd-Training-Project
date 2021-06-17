package com.nevexis.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InterceptorsHolder {
	@Autowired
	@Qualifier("ageBonusInterceptor")
	public AgeBonusInterceptor ageBonusInterceptor;
	@Autowired
	@Qualifier("addPointsInterceptor")
	public AddPointsInterceptor addPointsInterceptor;
	@Autowired
	@Qualifier("usePointsInterceptor")
	public UsePointsInterceptor usePointsInterceptor;
}
