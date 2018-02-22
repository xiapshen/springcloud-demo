package com.cloud.provider;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * The type Http cache controller.
 */
@RestController
public class HttpCacheController {

    /**
     * Cache response entity.
     * Ctrl+F5强制刷新，直接ifModifiedSince为null
     * 只能在浏览器中测试，可以基于Chrome
     *
     * @param ifModifiedSince the if modified since
     * @return the response entity
     * @throws ExecutionException the execution exception
     */
    @GetMapping(value = "/cache")
    public ResponseEntity<String> cache(@RequestHeader(value = "If-Modified-Since", required = false)
                                        Date ifModifiedSince) throws ExecutionException {
        DateFormat gmtDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        //文档最后修改时间（去掉毫秒数)(为了方便测试，每10秒生成一个)
        long lastModifiedMillis = getLastModified() / 1000 * 1000;

        //当前系统时间（去掉毫秒数）
        long now = System.currentTimeMillis() / 1000 * 1000;
        //文档可以在浏览器端/proxy上缓存多久（单位：秒）
        long maxAge = 20;

        //判断内容是否修改了，此处使用等值来判断
        if (ifModifiedSince != null && ifModifiedSince.getTime() == lastModifiedMillis) {
            MultiValueMap<String, String> headers = new HttpHeaders();
            //当前时间
            headers.add("Date", gmtDateFormat.format(now));
            //Expires和Cache-Control共存的话，第二个优先级高于第一个
            //过期时间，http1.0支持
            headers.add("Expires", gmtDateFormat.format(new Date(now + maxAge * 1000)));
            //文档生存时间 http1.1支持
            headers.add("Cache-Control", "max-age=" + maxAge);
            return new ResponseEntity<>(headers, HttpStatus.NOT_MODIFIED);
        }
        String body = "<a href=''>点击访问当前链接</a>";
        MultiValueMap<String, String> headers = new HttpHeaders();
        //当前时间
        headers.add("Date", gmtDateFormat.format(now));
        //文档修改时间
        headers.add("Last-Modified", gmtDateFormat.format(new Date(lastModifiedMillis)));
        //过期时间，http1.0支持
        headers.add("Expires", gmtDateFormat.format(new Date(now + maxAge * 1000)));
        //文档生存时间 http1.1支持
        headers.add("Cache-Control", "max-age=" + maxAge);

        return new ResponseEntity<>(body, headers, HttpStatus.OK);
    }

    /**
     * The Last modified cache.
     */
    Cache<String, Long> lastModifiedCache = CacheBuilder.newBuilder()
            .expireAfterWrite(10, TimeUnit.SECONDS).build();

    /**
     * Gets last modified.
     *
     * @return the last modified
     * @throws ExecutionException the execution exception
     */
    public long getLastModified() throws ExecutionException {
        return lastModifiedCache.get("lastModified", () -> {
           return System.currentTimeMillis();
        });
    }
}