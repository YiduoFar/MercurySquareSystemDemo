package com.bats.community.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author HuiBBao
 * @create 2022/4/23 11:37
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ArticleQuery {
    int sortType; // 排序 0-推荐 1-热门 2-最新
    String keyWord; // 关键字
    int timeSlot; // 时间 0-不限 1-最近一天 2-最近一周 3-最近三月
}
