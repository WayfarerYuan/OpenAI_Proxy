package cn.yuanfunc.openai_proxy;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class CacheController {
//
//    private final CacheService cacheService;
//
//    @Autowired
//    public CacheController(CacheService cacheService) {
//        this.cacheService = cacheService;
//    }
//
////    @GetMapping("/cache/{key}")
//    @GetMapping("/{key}")
//    public String getCachedResponse(@PathVariable String key) {
//        return cacheService.getResponse(key);
//    }
//
//    // 假设有一个方法来缓存数据，例如通过另一个API端点
//}

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache") // 确保Controller级别的路径定义正确
public class CacheController {

    private final CacheService cacheService;

    public CacheController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    @PostMapping("/{key}") // 对应POST请求的路径
    public ResponseEntity<?> cacheData(@PathVariable String key, @RequestBody String value) {
        cacheService.cacheResponse(key, value);
        return ResponseEntity.ok().build();
    }

    // 处理GET请求的方法
    @GetMapping("/{key}")
    public ResponseEntity<String> getCachedValue(@PathVariable String key) {
        String value = cacheService.getResponse(key);
        if (value != null) {
            return ResponseEntity.ok(value);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

