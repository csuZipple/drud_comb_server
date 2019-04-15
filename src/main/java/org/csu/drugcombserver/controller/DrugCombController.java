package org.csu.drugcombserver.controller;

import org.csu.drugcombserver.core.BaseController;
import org.csu.drugcombserver.service.DrugCombService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/combination")
public class DrugCombController extends BaseController {
    @Autowired
    private DrugCombService service;

}
