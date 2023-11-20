package com.green.greengram.feed;

import com.green.greengram.feed.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {

    int insFeed(FeedInsProcDto pDto);

    //t_feed_pics
    int insFeedPic(FeedPicsInsProcDto fDto);

    List<FeedSelVo> selFeed(FeedSelDto dto);

    List<FeedPicsVo> selFeedPics(List<Integer> list);

    int delFeedFav(FeedFavProcDto fDto);

    int insFeedFav(FeedFavProcDto dto);
}
