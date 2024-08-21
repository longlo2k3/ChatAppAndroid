package com.example.myapplication.utilities;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.firestore.auth.FirebaseAuthCredentialsProvider;
import com.google.firebase.messaging.FirebaseMessagingService;

import java.util.HashMap;

public class Constants {
    public static final String KEY_TIMESTAMP_CHAT = "timestamp";
    public static final String KEY_COLLECTION_USER = "users";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "passwprd";
    public static final String KEY_PREFERENCE_NAME = "chatAppPreference";
    public static final String KEY_IS_SIGNED_IN = "issSignedIn";
    public static final String KEY_USER_ID = "userId";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_FCM_TOKEN = "fcmToken";
    public static final String KEY_USER = "user";
    public static final String KEY_COLLECTION_CHAT = "chat";
    public static final String KEY_SENDER_ID = "senderId";
    public static final String KEY_RECEIVER_ID = "receriverId";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_COLLECTION_CONVERSATIONS ="conversations";
    public static final String KEY_SENDER_NAME = "senderName";
    public static final String KEY_RECEIVER_NAME = "receriverName";
    public static final String KEY_SENDER_IMAGE = "senderImage";
    public static final String KEY_RECEIVER_IMAGE = "receriverImage";
    public static final String KEY_LAST_MESSAGE = "lastmessage";
    public static final String KEY_AVAILABILITY = "availability";
    public static final String REMOTE_MSG_AUTHORIZATION ="Authorization";
    public static final String REMOTE_MSG_CONTENT_TYPE = "Content-Type";
    public static final String REMOTE_MSG_DATA = "data";
    public static final String REMOTE_MSG_REGISTRATION_IDS = "registration_ids";
    public static  HashMap<String, String> remoteMsgHeaders = null;
    public static HashMap<String,String> getRemoteMsgHeaders(){
        if (remoteMsgHeaders == null){
            remoteMsgHeaders = new HashMap<>();
            remoteMsgHeaders.put(
                    REMOTE_MSG_AUTHORIZATION,
                    "key=AAAAJkQ-wfQ:APA91bHM_WZdekzxgooOikfryufkObEQOzgmFR_qvtph6YqIuPxJkv_OE8RnA0YDP5H5nud3YI3Jc2jLaz4HNGTlYsiARNPWGSa-4NCOobpYD5nwl0w4kRwGBY_OSjBmM6aqK9_EfbTu"
            );
            remoteMsgHeaders.put(
                    REMOTE_MSG_CONTENT_TYPE,
                    "application/json"
            );
        }
        return  remoteMsgHeaders;
    }

}
