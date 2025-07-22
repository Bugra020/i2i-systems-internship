package org.example.hw_swagger;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class Controller {

    @PostMapping("/sendVoice")
    public String sendVoice(@RequestBody SendVoice sendVoice) {
        return String.format("A call was made from %s to %s for %d minutes in %s.",
                sendVoice.getaNumber(), sendVoice.getbNumber(), sendVoice.getDuration(), sendVoice.getLocation());
    }

    @PostMapping("/sendSms")
    public String sendSms(@RequestBody SendSms sendSms) {
        return String.format("A SMS was sent from %s to %s in %s.",
                sendSms.getaNumber(), sendSms.getbNumber(), sendSms.getLocation());
    }

    @PostMapping("/sendData")
    public String sendData(@RequestBody SendData sendData) {
        return String.format("Data of %dMB with RG %s was used by %s in %s.",
                sendData.getMb(), sendData.getRg(), sendData.getaNumber(), sendData.getLocation());
    }
}
