package com.mine.learn.source;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * moke
 *
 * @author liutao
 * @version 2018-07-29 下午10:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MokeDTO {
    private String id;
    private String name;
    private String sex;
}
