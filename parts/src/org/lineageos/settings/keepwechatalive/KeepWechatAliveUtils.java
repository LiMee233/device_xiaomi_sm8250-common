/*
 * Copyright (C) 2019 The LineageOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.lineageos.settings.wechat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.UserHandle;
import android.preference.PreferenceManager;

public class KeepWechatAliveUtils {

    private static final String WECHAT_FOREGROUND_SERVICE_ENABLE_KEY = "wechat_foreground_service_enable";
    private static final boolean WECHAT_FOREGROUND_SERVICE_ENABLE_DEFAULT_VALUE = false;

    public static void startWechatService(final Context context) {
        SharedPreferences mSharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        boolean wechatForegroundServiceEnabled = mSharedPrefs.getBoolean(
            WECHAT_FOREGROUND_SERVICE_ENABLE_KEY, WECHAT_FOREGROUND_SERVICE_ENABLE_DEFAULT_VALUE);
        if(wechatForegroundServiceEnabled) {
            Intent service = new Intent();
            service.setClassName("com.tencent.mm", "com.tencent.mm.booter.CoreService");
            context.startForegroundService(service);
        }
    }
}
