package com.tmall.wireless;

import android.app.Application;

import com.tmall.wireless.jandfix.MethodReplaceProxy;
import com.tmall.wireless.test.Test1;
import com.tmall.wireless.test.Test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by jingchaoqinjc on 17/3/20.
 */

public class AndFixApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        try {
//            Class.forName("com.tmall.wireless.test.Test2", true, this.getClass().getClassLoader());


            Method method1 = Test1.class.getDeclaredMethod("string");
            Method method2 = Test2.class.getDeclaredMethod("string");
            MethodReplaceProxy.instance().replace(method1, method2);

            Constructor constructor1 = Test1.class.getConstructor();
            Constructor constructor2 = Test2.class.getConstructor();
            MethodReplaceProxy.instance().replace(constructor1, constructor2);

            Method staticMethod1 = Test1.class.getDeclaredMethod("staticString");
            Method staticMethod2 = Test2.class.getDeclaredMethod("staticString");
            MethodReplaceProxy.instance().replace(staticMethod1, staticMethod2);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
