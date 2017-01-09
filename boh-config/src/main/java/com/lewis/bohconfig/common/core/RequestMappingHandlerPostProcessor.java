package com.lewis.bohconfig.common.core;

import com.lewis.bohconfig.common.util.ListUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangminghua on 2017/1/9.
 */
public class RequestMappingHandlerPostProcessor implements BeanPostProcessor {

    private List<Class<HandlerMethodArgumentResolver>> removedArgumentResolvers = new ArrayList<Class<HandlerMethodArgumentResolver>>();

    private List<Class<HandlerMethodReturnValueHandler>> removedReturnValueHandlers = new ArrayList<Class<HandlerMethodReturnValueHandler>>();

    private List<Class<HandlerMethodReturnValueHandler>> addedReturnValueHandlers = new ArrayList<Class<HandlerMethodReturnValueHandler>>();
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof RequestMappingHandlerAdapter) {
            RequestMappingHandlerAdapter adapter = (RequestMappingHandlerAdapter) bean;
     /*       removeArgumentResolvers(adapter.getArgumentResolvers(), adapter);
            removeReturnValueHandlers(adapter.getReturnValueHandlers(), adapter);
            addReturnValueHandlers(adapter.getReturnValueHandlers(),adapter);*/
            removeArgumentResolvers(adapter.getArgumentResolvers().getResolvers(), adapter);
            removeReturnValueHandlers(adapter.getReturnValueHandlers().getHandlers(), adapter);
            addReturnValueHandlers(adapter.getReturnValueHandlers().getHandlers(),adapter);
        }
        return bean;
    }

    /**
     * 移除指定的系统默认加载ArgumentResolver
     *
     * @param argumentResolvers
     */
    private void removeArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers,
                                         RequestMappingHandlerAdapter adapter) {
        if (removedArgumentResolvers == null || removedArgumentResolvers.size() == 0)
            return;
        List<HandlerMethodArgumentResolver> resolvers = new ArrayList<HandlerMethodArgumentResolver>();
        for (HandlerMethodArgumentResolver argumentResolver : argumentResolvers) {
            if (removedArgumentResolvers.contains(argumentResolver.getClass())) {
                continue;
            }
            resolvers.add(argumentResolver);
        }
        adapter.setArgumentResolvers(resolvers);
    }

    /**
     * 移除指定的系统默认加载的MehtodReturnValueHandler
     *
     * @param returnValueHandlers
     */
    private void removeReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers,
                                           RequestMappingHandlerAdapter adapter) {
        if (removedReturnValueHandlers == null || removedReturnValueHandlers.size() == 0)
            return;
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList<HandlerMethodReturnValueHandler>();
        for (HandlerMethodReturnValueHandler returnValueHandler : returnValueHandlers) {
            if (removedReturnValueHandlers.contains(returnValueHandler.getClass())) {
                continue;
            }
            handlers.add(returnValueHandler);
        }
        adapter.setReturnValueHandlers(handlers);
    }

    private void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers,
                                           RequestMappingHandlerAdapter adapter) {
        if (ListUtil.isEmpty(addedReturnValueHandlers))
            return;
        List<HandlerMethodReturnValueHandler> handlers = new ArrayList<HandlerMethodReturnValueHandler>();
        if (ListUtil.isNotEmpty(returnValueHandlers)) {
            handlers.addAll(returnValueHandlers);
        }
        List<HandlerMethodReturnValueHandler> toAddedReturnValueHandlers = new ArrayList<HandlerMethodReturnValueHandler>();
        for (Class<HandlerMethodReturnValueHandler> addedReturnValueHandler : addedReturnValueHandlers) {
            try {
                toAddedReturnValueHandlers.add(addedReturnValueHandler.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        handlers.addAll(toAddedReturnValueHandlers);
        adapter.setReturnValueHandlers(handlers);
    }

    public List<Class<HandlerMethodArgumentResolver>> getRemovedArgumentResolvers() {
        return removedArgumentResolvers;
    }

    public void setRemovedArgumentResolvers(List<Class<HandlerMethodArgumentResolver>> removedArgumentResolvers) {
        this.removedArgumentResolvers = removedArgumentResolvers;
    }

    public List<Class<HandlerMethodReturnValueHandler>> getRemovedReturnValueHandlers() {
        return removedReturnValueHandlers;
    }

    public void setRemovedReturnValueHandlers(List<Class<HandlerMethodReturnValueHandler>> removedReturnValueHandlers) {
        this.removedReturnValueHandlers = removedReturnValueHandlers;
    }

    public List<Class<HandlerMethodReturnValueHandler>> getAddedReturnValueHandlers() {
        return addedReturnValueHandlers;
    }

    public void setAddedReturnValueHandlers(List<Class<HandlerMethodReturnValueHandler>> addedReturnValueHandlers) {
        this.addedReturnValueHandlers = addedReturnValueHandlers;
    }
}
