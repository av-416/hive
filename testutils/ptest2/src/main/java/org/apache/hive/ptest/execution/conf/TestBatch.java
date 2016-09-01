/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.hive.ptest.execution.conf;

import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.annotations.VisibleForTesting;

public abstract class TestBatch {

  private static final AtomicInteger BATCH_ID_GEN = new AtomicInteger(1);

  private final int batchId;

  public TestBatch() {
    this.batchId = BATCH_ID_GEN.getAndIncrement();
  }

  public abstract String getTestArguments();

  // TODO Get rid of this.
  public abstract String getTestClass();

  public abstract String getName();

  public abstract boolean isParallel();

  public abstract String getTestModuleRelativeDir();

  public abstract int getNumTestsInBatch();

  public final int getBatchId() {
    return batchId;
  }

  @VisibleForTesting
  public static void resetBatchCoutner() {
    BATCH_ID_GEN.set(1);
  }
}
