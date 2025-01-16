package poa.poa_demo.POA;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SaludadorAspect{
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Before("execution(String poa.poa_demo.Services.SaludadorService.Saludar(..))")//indicamos antes de q metodo de q clase se va a ejecutar si ponemos * y en vez de la clase la interfaz se va a ejecutar en todos los metodos de esta
    public void loggerBefore(JoinPoint jPoint){//se inyecta de forma automatica, es el punto de union.Une la ejecucion de un aspectocon la llamada a un metodo 
        String m = jPoint.getSignature().getName();
        String args =Arrays.toString(jPoint.getArgs());

        log.info("antes... "+m+" los argumentos son "+args);
    }

    @After("execution(* poa.poa_demo.Services.ISaludadorService.*(..))")//ponemos * y en vez de la clase la interfaz se va a ejecutar en todos los metodos de esta
    public void loggerAfter(JoinPoint jPoint){//se inyecta de forma automatica, es el punto de union.Une la ejecucion de un aspectocon la llamada a un metodo 
        String m = jPoint.getSignature().getName();
        String args =Arrays.toString(jPoint.getArgs());

        log.info("despues... "+m+" los argumentos son "+args);
    }

    @AfterReturning("execution(* poa.poa_demo.Services.ISaludadorService.*(..))")//ponemos * y en vez de la clase la interfaz se va a ejecutar en todos los metodos de esta
    public void afterReturning(JoinPoint jPoint){//se inyecta de forma automatica, es el punto de union.Une la ejecucion de un aspectocon la llamada a un metodo 
        String m = jPoint.getSignature().getName();
        String args =Arrays.toString(jPoint.getArgs());

        log.info("el retorno... "+m+" los argumentos son "+args);
    }

    @AfterThrowing("execution(* poa.poa_demo.Services.ISaludadorService.*(..))")//ponemos * y en vez de la clase la interfaz se va a ejecutar en todos los metodos de esta
    public void afterThrowing(JoinPoint jPoint){//se inyecta de forma automatica, es el punto de union.Une la ejecucion de un aspectocon la llamada a un metodo 
        String m = jPoint.getSignature().getName();
        String args =Arrays.toString(jPoint.getArgs());

        log.info("expecionando... "+m+" los argumentos son "+args);
    }

    @Around("execution(* poa.poa_demo.Services.ISaludadorService.*(..))")
    public Object aroundMtd(ProceedingJoinPoint pjp){
        String m = pjp.getSignature().getName();
        String args =Arrays.toString(pjp.getArgs());
        try { //vamos a capturar lo q devuelve el metodo q estamos envolviendo
            log.info("envolviendo... "+m+" los argumentos son "+args);
            Object capturaObject = pjp.proceed();
            return capturaObject;
        } catch (Throwable t) {
            t.getMessage();
        }
        return null;
    }
}
