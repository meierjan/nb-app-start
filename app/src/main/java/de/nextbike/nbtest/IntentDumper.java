package de.nextbike.nbtest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by meier on 10.01.16.
 */
public class IntentDumper {
    private static final String TAG = IntentDumper.class.getSimpleName();

    public static void dump(Intent intent) {
        try {
            Bundle bundle = intent.getExtras();
            for (String key : bundle.keySet()) {
                Object value = bundle.get(key);
                try {
                    Log.d("IntentDumper",
                            String.format("%s %s (%s)",
                                    key,
                                    value.toString(),
                                    value.getClass().getName()
                            ));
                } catch (NullPointerException npe) {
                    Log.e("IntentDumper", "Cant print out value.", npe);
                }
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
