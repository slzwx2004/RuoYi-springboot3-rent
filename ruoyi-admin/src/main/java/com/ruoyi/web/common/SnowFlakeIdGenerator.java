package com.ruoyi.web.common;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

/**
 * @author llj
 * @description 雪花算法id生成器
 * @create 2022/6/23 16:58
 *
 *     类的ID参考以下写法
 *     @Id
 *     @GeneratedValue(generator = "snowFlakeId")
 *     @GenericGenerator(name = "snowFlakeId", strategy = "com.ruoyi.web.common.SnowFlakeIdGenerator")
 *     @Column(length = 32)
 *     @ColumnComment("主键ID")
 *
 */
public class SnowFlakeIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
        return snowflake.nextIdStr();
    }
}
