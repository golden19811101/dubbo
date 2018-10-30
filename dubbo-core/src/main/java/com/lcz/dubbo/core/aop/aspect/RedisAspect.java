package com.lcz.dubbo.core.aop.aspect;

import com.lcz.dubbo.core.exception.CCException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Redis切面处理类
 *
 * @author luchunzhou
 */
@Aspect
@Component
public class RedisAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
    //是否开启redis缓存  true开启   false关闭
    @Value("${cc.redis.open: false}")
    private boolean open;

    @Around("execution(* com.lcz.dubbo.core.util.DistributedLockUtil.*(..))")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object result = null;
        if(open){
            try{
                result = point.proceed();
            }catch (Exception e){
                logger.error("Redis服务异常", e);
                throw new CCException("Redis服务异常");
            }
        }
        return result;
    }
}
