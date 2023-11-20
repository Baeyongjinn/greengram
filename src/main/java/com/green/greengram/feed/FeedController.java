package com.green.greengram.feed;

import com.green.greengram.ResVo;
import com.green.greengram.feed.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/feed")
public class FeedController {

    private final FeedService service;

    @PostMapping
    public ResVo insFeed(@RequestBody FeedInsDto dto) {
        System.out.println(dto);
        return service.insFeed(dto);
    }

    @GetMapping
    public List<FeedSelVo> getFeed(int page, int iuser) {
        System.out.println(page);
        return service.getFeed(page, iuser,0);
    }

    @GetMapping("/{targetIuser}")
    public List<FeedSelVo> getProfileFeed(@PathVariable int targetIuser, int page, int loginedIuser) {
        return service.getFeed(page, loginedIuser,targetIuser);
    }

    @GetMapping("/{ifeed}/fav")
    public ResVo procFav(@PathVariable int ifeed, int iuser) {
        System.out.println("ifeed: " + ifeed);
        System.out.println("iuser: " + iuser);
        FeedFavProcDto dto = FeedFavProcDto.builder()
                .ifeed(ifeed)
                .iuser(iuser)
                .build();
        return service.procFav(dto);
    }

}
