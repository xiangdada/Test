package com.example.xiangdada.test.dagger2.qualifier;

import dagger.Component;

/**
 * Created by xdd on 2019/3/3
 */
@Component(modules = Person2Module.class)
public interface Person2Component {

    void inject(Qualifier qualifier);
}
