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
package edu.cnm.deepdive.passwordservice.controller;

import edu.cnm.deepdive.passwordservice.service.AbstractPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordController {

  private static final String DEFAULT_LENGTH_PARAM_VALUE = "12";

  private final AbstractPasswordService service;

  @Autowired
  public PasswordController(AbstractPasswordService service) {
    this.service = service;
  }

  @GetMapping(value = "/password", produces = MediaType.APPLICATION_JSON_VALUE)
  public String get(
      @RequestParam(required = true) String pool,
      @RequestParam(required = false, defaultValue = DEFAULT_LENGTH_PARAM_VALUE) int length
  ) {
    return service.randomPassword(pool, length);
  }

}
