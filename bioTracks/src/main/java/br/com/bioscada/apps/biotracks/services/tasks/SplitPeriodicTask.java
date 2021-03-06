/*
 * Copyright 2010 Google Inc.
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

package br.com.bioscada.apps.biotracks.services.tasks;

import com.google.android.lib.mytracks.content.WaypointCreationRequest;

import br.com.bioscada.apps.biotracks.services.TrackRecordingService;

/**
 * A simple task to insert statistics markers periodically.
 * 
 * @author Sandor Dornbush
 */
public class SplitPeriodicTask implements PeriodicTask {

  @Override
  public void start() {}

  @Override
  public void run(TrackRecordingService trackRecordingService) {
    trackRecordingService.insertWaypoint(WaypointCreationRequest.DEFAULT_STATISTICS);
  }

  @Override
  public void shutdown() {}

  @Override
  public void setParams(String[] params) {
    throw new IllegalStateException("setParams on SplitPeriodicTask not supported");
  }
}
