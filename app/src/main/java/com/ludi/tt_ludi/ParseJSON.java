package com.ludi.tt_ludi;

/**
 * Created by Salma on 03/04/16.
 */
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseJSON {
    public static String[] message;

    public static final String JSON_ARRAY = "result";
    public static final String KEY_MESSAGE = "message";

    private JSONArray users = null;

    private String json;

    public ParseJSON(String json) {
        this.json = json;
    }

    protected void parseJSON() {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            users = jsonObject.getJSONArray(JSON_ARRAY);

            message = new String[users.length()];

            for (int i = 0; i < users.length(); i++) {
                JSONObject jo = users.getJSONObject(i);
                message[i] = jo.getString(KEY_MESSAGE);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
