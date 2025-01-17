package poa.poa_demo.POA;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SaludadorPointCut {

    @Pointcut("execution(* poa.poa_demo.Services.ISaludadorService.*(..))")
    public void saludadorLoggerPointCut(){}

}
