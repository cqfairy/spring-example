package com.xx.spring.core.example.resources;

import org.junit.Test;

import static org.junit.Assert.*;

/*
 * Copyright (c) 天畅伟业科技有限公司 2017
 * 本著作物的著作权归天畅伟业有限公司所有。
 * -----------------------------------------------
 * 修改记录 :
 * 日 期          版本          修改人         修改内容
 *
 */public class ResourceTest {
    @Test
    public void classpath() throws Exception {
        Resource resource = new Resource();
        resource.classpath();
    }

}