package poa.poa_demo.POA;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class Saludador2Aspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(* poa.poa_demo.Services.ISaludadorService.*(..))")//indicamos antes de q metodo de q clase se va a ejecutar si ponemos * y en vez de la clase la interfaz se va a ejecutar en todos los metodos de esta
    public void loggerBefore(JoinPoint jPoint){//se inyecta de forma automatica, es el punto de union.Une la ejecucion de un aspectocon la llamada a un metodo 
        String m = jPoint.getSignature().getName();
        String args =Arrays.toString(jPoint.getArgs());

        logger.info("antes en el primer order... "+m+" los argumentos son "+args);
    }
}
