package com.gec.hazardous.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class APageController {
    /**
     * 一级路径
     */

    @GetMapping("{url}.html")
    public String module1(@PathVariable("url") String url) {
        return url;
    }

    /**
     * 二级路径
     */
    @GetMapping("{module}/{url}.html")
    public String module2(@PathVariable("module") String module, @PathVariable("url") String url) {
        return module + "/" + url;
    }

    /**
     * 三级路径
     */
    @GetMapping("{module}/{classify}/{url}.html")
    public String module3(@PathVariable("module") String module,
                          @PathVariable("classify") String classify,
                          @PathVariable("url") String url) {
        return module + "/" + classify + "/" + url;
    }


     /**
      * 四季*/
    @GetMapping("{module}/{classify}/{san}/{url}.html")
    public String module4(@PathVariable("module") String module,
                          @PathVariable("classify") String classify,
                          @PathVariable("san") String san,
                          @PathVariable("url") String url) {
        return module + "/" + classify + "/" + san + "/" + url;
    }

}
