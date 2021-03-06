package Network;

/**
 * Created by misconstructed on 2018. 8. 23..
 */

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by choisunpil on 2018. 5. 31..
 */

public class PostResendSheet {

    private Response response;
    private RequestBody formBody;
    private Request request;
    private OkHttpClient client = new OkHttpClient();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String post(String url, String token, String id, String name, String date, String data, String chord) throws IOException, TimeoutException {
        Log.v("resend", data);
        client = new OkHttpClient();
        formBody = new FormBody.Builder()
                .add("token", token)
                .add("ID", id)
                .add("name", name)
                .add("date", date)
                .add("data", data)
                .add("chord", chord)
                .build();
        request = new Request.Builder()
                .url(url)
                .post(formBody)
                .build();
        try {
            Log.v("body", request.url().toString());
            response = client.newCall(request).execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(response==null)
            return null;
        //    Log.v("aaa","NULL");
        return response.body().string();
    }
}