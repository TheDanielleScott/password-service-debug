/*
 *  Copyright 2024 CNM Ingenuity, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package edu.cnm.deepdive.passwordservice.service;

public interface AbstractPasswordService {

  /**
   * Generates and returns a randomly generated password (the source of randomness is not provided
   * here, but is assumed to be present in the implementation) of {@code length} code points, drawn
   * (with replacement) from {@code pool}.
   *
   * @param pool {@link String} from which random code points are drawn.
   * @param length Number of code points to include in generated password.
   * @return Generated password.
   */
  String randomPassword(String pool, int length);

}
