package org.haxe.h5;

import android.util.Log;
import android.content.Intent;
import org.haxe.extension.Extension;
import org.haxe.lime.HaxeObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CordovaExtension extends Extension {

	public static final String EXTRA_URL = "CordovaExtension.EXTRA_URL";
	public static final String EXTRA_HTML = "CordovaExtension.EXTRA_HTML";
	public static final String EXTRA_FLOATING = "CordovaExtension.EXTRA_FLOATING";
	public static final String EXTRA_URL_WHITELIST = "CordovaExtension.EXTRA_URL_WHITELIST";
	public static final String EXTRA_URL_BLACKLIST = "CordovaExtension.EXTRA_URL_BLACKLIST";
	public static final String EXTRA_USE_WIDE_PORT = "CordovaExtension.EXTRA_USE_WIDE_PORT";
	public static final String EXTRA_MEDIA_PLAYBACK_REQUIRES_USER_GESTURE = "CordovaExtension.EXTRA_MEDIA_PLAYBACK_REQUIRES_USER_GESTURE";
	public static boolean active = false;

	public static HaxeObject callback;

	public static void open(String json) {

		try {

			JSONObject obj = new JSONObject(json);
			String url = obj.getString("url");
			/*
			boolean floating = obj.getBoolean("floating");

			JSONArray jsonUrlWhitelist = obj.getJSONArray("urlWhitelist");
			String[] urlWhitelist = new String[jsonUrlWhitelist.length()];
			for (int i=0; i<jsonUrlWhitelist.length(); ++i) {
				urlWhitelist[i] = jsonUrlWhitelist.getString(i);
			}

			JSONArray jsonUrlBlacklist = obj.getJSONArray("urlBlacklist");
			String[] urlBlacklist = new String[jsonUrlBlacklist.length()];
			for (int i=0; i<jsonUrlBlacklist.length(); ++i) {
				urlBlacklist[i] = jsonUrlBlacklist.getString(i);
			}

			boolean useWideViewPort = obj.getBoolean("useWideViewPort");
			boolean mediaPlaybackRequiresUserGesture = obj.getBoolean("mediaPlaybackRequiresUserGesture");
			*/
			Intent intent = new Intent(mainActivity, CordovaWebViewPlus.class);

			intent.putExtra(EXTRA_URL, url);
			/*intent.putExtra(EXTRA_FLOATING, floating);
			intent.putExtra(EXTRA_URL_WHITELIST, urlWhitelist);
			intent.putExtra(EXTRA_URL_BLACKLIST, urlBlacklist);
			intent.putExtra(EXTRA_USE_WIDE_PORT, useWideViewPort);
			intent.putExtra(EXTRA_MEDIA_PLAYBACK_REQUIRES_USER_GESTURE, mediaPlaybackRequiresUserGesture);
			*/
			mainActivity.startActivity(intent);
			active = true;

		} catch (JSONException e) {
			Log.d("JSONException", e.toString());
		}

	}
 

	public static boolean isActive(){
		return active;
	}

	public static void setCallback(final HaxeObject _callback) {
		callback = _callback;
	}

}
