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

package com.oracle.dev.jdbc.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.embedding.EmbeddingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.oracle.dev.jdbc.services.OracleDatabaseVectorService;

@Controller
public class OracleDatabaseController {

  private final OracleDatabaseVectorService vectorService;
  private static final Logger logger = LoggerFactory
      .getLogger(OracleDatabaseController.class);

  @Autowired
  public OracleDatabaseController(EmbeddingClient embeddingClient,
      @Qualifier("openAiChatClient") ChatClient chatClient,
      OracleDatabaseVectorService vectorService) {
    this.vectorService = vectorService;    
  }

  @GetMapping("/ragpage")
  public String ragForm(Model model) {
    return "rag";
  }

  @GetMapping("/direct")
  public String directForm(Model model) {
    return "direct";
  }

  @PostMapping("/rag23aivectorstore")
  public String rag(@RequestParam(value = "query") String query, Model model) {
    String answer = this.vectorService.rag(query);
    logger.info(answer);
    model.addAttribute("answer", answer);
    return "result";
  }

  @PostMapping("/directopenaicall")
  public String completion(@RequestParam String database,
      @RequestParam String question, Model model) {
    String answer = this.vectorService.getAnswer(database, question);
    System.out.println(answer);
    model.addAttribute("answer", answer);
    return "result";
  }

}
