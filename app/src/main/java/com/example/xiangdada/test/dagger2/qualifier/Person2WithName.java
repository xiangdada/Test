package com.example.xiangdada.test.dagger2.qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by xdd on 2019/3/3
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface Person2WithName {
}
