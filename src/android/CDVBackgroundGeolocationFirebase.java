package com.transistorsoft.cordova.bggeo;

import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.tsfirebaseproxy.TSFirebaseProxy;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;

import android.app.Activity;

public class CDVBackgroundGeolocationFirebase extends CordovaPlugin {
    public static final String TAG = "TSLocationManager";
    public static final String ACTION_CONFIGURE = "configure";

    private boolean isRegistered;

    @Override
    protected void pluginInitialize() {
        isRegistered = false;
    }

    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        boolean result = false;

        TSLog.logger.info(TSLog.info("[Firebase] $ " + action));

        if (ACTION_CONFIGURE.equalsIgnoreCase(action)) {
            result = true;
            configure(data.getJSONObject(0), callbackContext);
        }
        return result;
    }

    private void configure(JSONObject options, final CallbackContext callbackContext) throws JSONException {
        TSLog.logger.info(TSLog.info("[Firebase] - configure: " + options));
        Activity activity = cordova.getActivity();

        TSFirebaseProxy proxy = TSFirebaseProxy.getInstance(activity.getApplicationContext());

        if (options.has(TSFirebaseProxy.FIELD_LOCATIONS_COLLECTION)) {
            proxy.setLocationsCollection(options.getString(TSFirebaseProxy.FIELD_LOCATIONS_COLLECTION));
        }
        if (options.has(TSFirebaseProxy.FIELD_GEOFENCES_COLLECTION)) {
            proxy.setGeofencesCollection(options.getString(TSFirebaseProxy.FIELD_GEOFENCES_COLLECTION));
        }
        if (options.has(TSFirebaseProxy.FIELD_UPDATE_SINGLE_DOCUMENT)) {
            proxy.setUpdateSingleDocument(options.getBoolean(TSFirebaseProxy.FIELD_UPDATE_SINGLE_DOCUMENT));
        }
        proxy.save(activity.getApplicationContext());

        if (!isRegistered) {
            isRegistered = true;
            proxy.register(activity.getApplicationContext());
        }
        callbackContext.success();
    }
}
