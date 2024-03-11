//package cn.yuanfunc.openai_proxy;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.client.RestTemplate;
//
//@RestController
//@RequestMapping("/api")
//public class ProxyController {
//
//    private final RestTemplate restTemplate;
//
//    @Autowired
//    public ProxyController(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    @PostMapping("/proxy")
//    public ResponseEntity<String> proxyToOpenAI(@RequestBody String body, @RequestHeader HttpHeaders headers) {
//        // 移除不必要的头信息
//        headers.remove(HttpHeaders.HOST);
//
//        // OpenAI API URL，这里使用Completions API作为示例
//        String openAiUrl = "https://api.openai.com/v1/completions";
//
//        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
//        return restTemplate.exchange(openAiUrl, HttpMethod.POST, requestEntity, String.class);
//    }
//}
package cn.yuanfunc.openai_proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders; // Add this import
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ProxyController {

    private final RestTemplate restTemplate;

    @Autowired
    public ProxyController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/proxy")
    public ResponseEntity<String> proxyToOpenAI(@RequestBody String body, @RequestHeader HttpHeaders headers) {
        // 移除不必要的头信息
        headers.remove(HttpHeaders.HOST);

        // OpenAI API URL，这里使用Completions API作为示例
        String openAiUrl = "https://api.openai.com/v1/completions";

        HttpEntity<String> requestEntity = new HttpEntity<>(body, headers);
        return restTemplate.exchange(openAiUrl, HttpMethod.POST, requestEntity, String.class);
    }
}
