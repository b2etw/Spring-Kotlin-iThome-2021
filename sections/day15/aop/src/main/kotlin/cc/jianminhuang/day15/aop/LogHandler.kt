package cc.jianminhuang.day15.aop

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.Arrays

@Aspect
@Component
class LogHandler {

    private val logger = LoggerFactory.getLogger(javaClass)

    @Pointcut("execution(* cc.jianminhuang.day15.web.controller..*(..))")
    fun pointCut() {
    }

    @Before("pointCut()")
    fun log(joinPoint: JoinPoint) {
        logger.info("log handler args: ${Arrays.toString(joinPoint.args)}")
    }
}