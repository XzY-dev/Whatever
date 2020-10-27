package com.xzy.cloud.authorization.entity;

import com.xzy.cloud.common.web.entity.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author XZY
 * @version V1.0
 * @Package com.xzy.cloud.authorization.entity
 * @date 2020/10/25 15:15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class Role extends BasePo {
    private String code;
    private String name;
    private String description;
}
