package io.visualjava.spring.bean;

import io.visualjava.common.util.ReflectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author CaptHua
 */
@Service
public class BeanService implements BeanFactoryAware {

    private BeanFactory beanFactory;

    public List<Bean> listBeans() {
        if (beanFactory instanceof DefaultListableBeanFactory) {
            Map<String, BeanDefinition> beanDefinitionMap = (Map<String, BeanDefinition>) ReflectionUtils
                    .getFieldValue(DefaultListableBeanFactory.class, "beanDefinitionMap", beanFactory);
            assert beanDefinitionMap != null;
            for(Map.Entry<String,BeanDefinition> entry : beanDefinitionMap.entrySet()){
                BeanDefinition definition=entry.getValue();
//                definition.get
            }
        }
        return new ArrayList<Bean>();
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
