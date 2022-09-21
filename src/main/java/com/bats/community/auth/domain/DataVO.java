package com.bats.community.auth.domain;

import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author HuiBBao
 * @create 2022/4/18 20:22
 * 用于返回数据的泛型类
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DataVO<T> {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 状态信息
     */
    private String message;
    /**
     * 数据
     */
    private T data;

    /**
     * 有数据返回构造
     * @param pair
     */
    public DataVO(Pair<Integer, String> pair, T data) {
        this.code = pair.getKey();
        this.message = pair.getValue();
        this.data = data;
    }

    /**
     * 无数据返回构造
     * @param pair
     */
    public DataVO(Pair<Integer, String> pair) {
        this.code = pair.getKey();
        this.message = pair.getValue();
        this.data = null;
    }

}
