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

import java.util.Random;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;

public class PasswordService implements AbstractPasswordService {

  private final Random random;

  @Autowired
  public PasswordService(Random random) {
    this.random = random;
  }

  @Override
  public String randomPassword(String pool, int length) {
    int[] points = pool
        .codePoints();
    int[] generated = IntStream
        .generate(() -> points[random.nextInt(length)])
        .limit(pool.length())
        .toArray();
    return new String(generated, 0, generated.length);
  }

}
