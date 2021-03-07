/*
 * Copyright 2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance
 * with the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0/
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package com.virajmavani.Bifrost.controller;


import com.virajmavani.Bifrost.model.Query;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@EnableWebMvc
public class SearchController {
    @CrossOrigin(origins = "*")
    @GetMapping("/bifrost")
    public String helloWorld() {
        return "Heimdall! Open the bifrost!";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/bifrost/search")
    public ResponseEntity<String> search(@RequestBody Query query) {
        List<String> targets = query.getTargets();
        String search_str = query.getSearch_str();
        StringBuilder url = new StringBuilder();
        url.append(search_str);
        url.append(" ");
        String filter = String.join(" OR ", targets);
        url.append(filter);
        String final_url = Globals.GOOGLESEARCH + url.toString().replace(" ", "%20");
        return ResponseEntity.ok(final_url);
    }

}
