/*
  Copyright (c) 2024, Oracle and/or its affiliates.

  This software is dual-licensed to you under the Universal Permissive License
  (UPL) 1.0 as shown at https://oss.oracle.com/licenses/upl or Apache License
  2.0 as shown at http://www.apache.org/licenses/LICENSE-2.0. You may choose
  either license.

  Licensed under the Apache License, Version 2.0 (the "License");
  you may not use this file except in compliance with the License.
  You may obtain a copy of the License at

     https://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS,
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  See the License for the specific language governing permissions and
  limitations under the License.
*/

package com.oracle.dev.jdbc.utils;

public enum OracleDistanceType {

  COSINE("COSINE"), DOT("DOT"), EUCLIDEAN("EUCLIDEAN"), EUCLIDEAN_SQUARED(
      "EUCLIDEAN_SQUARED"), HAMMING("HAMMING"), MANHATTAN("MANHATTAN");

  private final String distanceType;

  private OracleDistanceType(String distanceType) {
    this.distanceType = distanceType;

  }

  public String distanceType() {
    return distanceType;
  }

}
