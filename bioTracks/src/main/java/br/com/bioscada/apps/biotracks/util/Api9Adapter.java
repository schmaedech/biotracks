/*
 * Copyright 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package br.com.bioscada.apps.biotracks.util;

import android.annotation.TargetApi;
import android.content.SharedPreferences.Editor;
import android.location.Geocoder;
import android.os.StrictMode;
import android.util.Log;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.util.Arrays;

/**
 * API level 9 specific implementation of the {@link ApiAdapter}.
 *
 * @author Rodrigo Damazio
 */
@TargetApi(9)
public class Api9Adapter extends Api8Adapter {
  
  private static final String TAG = Api9Adapter.class.getSimpleName();
  
  @Override
  public void applyPreferenceChanges(Editor editor) {
    // Apply asynchronously
    editor.apply();
  }

  @Override
  public void enableStrictMode() {
    Log.d(TAG, "Enabling strict mode");
    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
        .detectAll()
        .penaltyLog()
        .build());
    StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
        .detectAll()
        .penaltyLog()
        .build());
  }

  @Override
  public byte[] copyByteArray(byte[] input, int start, int end) {
    return Arrays.copyOfRange(input, start, end);
  }

  @Override
  public HttpTransport getHttpTransport() {
    return new NetHttpTransport();
  }

  @Override
  public boolean isGeoCoderPresent() {
    return Geocoder.isPresent();
  }
  
  @Override
  public boolean revertMenuIconColor() {
    return false;
  }
}
