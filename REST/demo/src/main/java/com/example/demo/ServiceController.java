package com.example.demo;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/Service")
    public char sendEmail(@RequestParam(value="_url") String _url,@RequestParam(value = "_sub") String _sub,@RequestParam(value = "_payload") String _payload) {
        return Service.sendEmail(_url,_sub,_payload);
    }

}
