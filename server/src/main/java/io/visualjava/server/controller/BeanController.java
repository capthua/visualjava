package io.visualjava.server.controller;

import io.visualjava.common.response.ObjectResponse;
import io.visualjava.spring.bean.Bean;
import io.visualjava.spring.bean.BeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author CaptHua
 * Web apis about spring beans
 */
@RestController
@RequestMapping("spring/beans")
public class BeanController {

    @Autowired
    BeanService beanService;

    @GetMapping
    public ObjectResponse<List<Bean>> listBeans() {
        ObjectResponse<List<Bean>> res = new ObjectResponse<>();
        res.setData(beanService.listBeans());
        return res;
    }

}
