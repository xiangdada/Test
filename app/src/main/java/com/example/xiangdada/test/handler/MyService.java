package com.example.xiangdada.test.handler;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by xdd on 2019/3/10
 *
 * startSevice：onCreate()、onStartCommand()、onDestroy()
 * bindService：onCreate()、onBind()、onUnbind()、onDestroy()
 */
public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("测试","onCreate");
    }

    /**
     *
     * @param intent
     * @param flags
     * @param startId
     * @return
     * START_NOT_STICKY:如果系统在onStartCommand()方法返回之后杀死这个服务，那么直到接受到新的Intent对象，这个服务才会被重新创建。
     * 这是最安全的选项，用来避免在不需要的时候运行你的服务。\
     *
     * START_STICKY:如果系统在onStartCommand()返回后杀死了这个服务，系统就会重新创建这个服务并且调用onStartCommand()方法，
     * 但是它不会重新传递最后的Intent对象，系统会用一个null的Intent对象来调用onStartCommand()方法，在这个情况下，
     * 除非有一些被发送的Intent对象在等待启动服务。这适用于不执行命令的媒体播放器（或类似的服务），它只是无限期的运行着并等待工作的到来。
     *
     * START_REDELIVER_INTENT:使用这个返回值时，如果在执行完onStartCommand后，服务被异常kill掉，系统会自动重启该服务，并将Intent的值传入。
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("测试","onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * startSevice启动可以不用重写这个方法，
     * bindService启动必须返回一个IBinder接口的具体实现类
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("测试","onBind");

        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("测试","onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.e("测试","onDestroy");
        super.onDestroy();
    }

    public static class MyBinder extends Binder{
        public void action(){
            Log.e("测试","MyBinder action");
        }
    }
}
