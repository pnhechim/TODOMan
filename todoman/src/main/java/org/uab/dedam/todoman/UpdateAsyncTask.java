package org.uab.dedam.todoman;

import android.os.AsyncTask;

public class UpdateAsyncTask extends AsyncTask<String, Integer, Boolean> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        int a = 3 + 5;
        publishProgress(new Integer[] {5, 8});
        return a == 8;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}
