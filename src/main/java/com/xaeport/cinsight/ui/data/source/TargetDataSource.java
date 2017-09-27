package com.xaeport.cinsight.ui.data.source;


import java.lang.annotation.*;

/**
 * Created by xcp on 2017/4/7.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetDataSource {
    String value();
}
