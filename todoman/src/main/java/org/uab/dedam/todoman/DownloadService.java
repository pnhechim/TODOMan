package org.uab.dedam.todoman;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class DownloadService extends Service {
    public DownloadService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
        //Si no implementás este método, por defecto se usará START_NOT_STICKY
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void play() {

    }

    public class ServiceBinder extends Binder {
        DownloadService getService() {
            return DownloadService.this;
        }
    }
}
