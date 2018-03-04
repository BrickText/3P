package org.elsys.P.trip;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/trip")
public class TripController {

    @RequestMapping(value="/t", method= RequestMethod.GET)
    public String test() {
        return "Test";
    }
}
