package com.develop.pets_care.services;
import android.util.Log;
import com.develop.pets_care.util.NotificationUtils;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import org.json.JSONObject;
import com.google.gson.Gson;

public class UserService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        /*JSONObject object = new JSONObject(remoteMessage.getData());
        Gson gson = new Gson();
        Message message = gson.fromJson(object.toString(),Message.class);
        Log.e(">>>","Pues aquí llego");
        NotificationUtils.createNotification(this,message.getBody());*/
    }


}
