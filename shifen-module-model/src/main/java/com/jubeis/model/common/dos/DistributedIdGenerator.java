package com.jubeis.model.common.dos;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 分布式id生成器，本地生成算法--雪花算法实现
 *
 * @author shawn
 */
@Slf4j
public class DistributedIdGenerator implements IdentifierGenerator {
    /**
     * 时间起始标记点，作为基准，一般取系统的最近时间（一旦确定不能变动）
     */
    private static final long INITIAL_TIMESTAMP = 1576156217L;
    /**
     * 服务标识位数
     */
    private static final long SERVICE_ID_BITS = 5L;
    /**
     * 实例标识位数
     */
    private static final long INSTANCE_ID_BITS = 5L;
    /**
     * 服务ID最大值
     */
    private static final long MAX_SERVICE_ID = (-1L ^ (-1L << SERVICE_ID_BITS)) + 1;
    /**
     * 实例ID最大值
     */
    private static final long MAX_INSTANCE_ID = (-1L ^ (-1L << INSTANCE_ID_BITS)) + 1;
    /**
     * 毫秒内序列号自增位
     */
    private static final long SEQUENCE_BITS = 12L;
    /**
     * 实例ID偏左移12位
     */
    private static final long INSTANCE_ID_SHIFT = SEQUENCE_BITS;
    /**
     * 服务ID左移17位
     */
    private static final long SERVICE_ID_SHIFT = SEQUENCE_BITS + INSTANCE_ID_BITS;
    /**
     * 时间毫秒左移22位
     */
    private static final long TIMESTAMP_SHIFT = SEQUENCE_BITS + SERVICE_ID_BITS + INSTANCE_ID_BITS;

    private static final long SEQUENCE_MASK = (-1L ^ (-1L << SEQUENCE_BITS)) + 1;
    /* 上次生产id时间戳 */
    private static long lastTimestamp = -1L;

    private long sequence = 0L;

    /**
     * 服务id部分
     */
    private long serviceId;
    /**
     * 实例id部分
     */
    private long instanceId;

    private ReentrantLock lock = new ReentrantLock();

    /**
     * @param serviceId  服务ID
     * @param instanceId 实例ID
     */
    public DistributedIdGenerator(long serviceId, long instanceId) {
        if (serviceId > MAX_SERVICE_ID || serviceId < 0) {
            throw new IllegalArgumentException(
                    String.format("Service Id can't be greater than %d or less than 0", MAX_SERVICE_ID));
        }
        if (instanceId > MAX_INSTANCE_ID || instanceId < 0) {
            throw new IllegalArgumentException(
                    String.format("Instance Id can't be greater than %d or less than 0", MAX_INSTANCE_ID));
        }
        this.serviceId = serviceId;
        this.instanceId = instanceId;
    }

    public Long nextId() {
        return nextId(new Object());
    }

    /**
     * 获取下一个ID
     *
     * @return
     */
    @Override
    public Long nextId(Object object) {
        lock.lock();
        try {
            long timestamp = currentTimestamp();
            // 闰秒
            if (timestamp < lastTimestamp) {
                long offset = lastTimestamp - timestamp;
                if (offset <= 5) {
                    try {
                        wait(offset << 1);
                        timestamp = currentTimestamp();
                        if (timestamp < lastTimestamp) {
                            throw new RuntimeException(
                                    String.format(
                                            "Clock moved backwards.  Refusing to generate id for %d milliseconds",
                                            offset));
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    throw new RuntimeException(
                            String.format(
                                    "Clock moved backwards.  Refusing to generate id for %d milliseconds", offset));
                }
            }
            if (lastTimestamp == timestamp) {
                // 相同毫秒内，序列号自增
                sequence = (sequence + 1) % SEQUENCE_MASK;
                // 序列号用尽，等待下一秒
                if (sequence == 0) {
                    // 当前毫秒内计数满了，则等待下一秒
                    timestamp = tilNextMillis(timestamp);
                }
            } else {
                sequence = 1;
            }
            lastTimestamp = timestamp;
            // 时间戳部分 | 服务id部分 | 实例id标识部分 | 序列号部分
            long nextId =
                    ((timestamp - INITIAL_TIMESTAMP) << TIMESTAMP_SHIFT)
                            | (serviceId << SERVICE_ID_SHIFT)
                            | (instanceId << INSTANCE_ID_SHIFT)
                            | sequence;
            return nextId;
        } finally {
            lock.unlock();
        }
    }

    private long tilNextMillis(final long lastTimestamp) {
        long timestamp = this.currentTimestamp();
        while (timestamp <= lastTimestamp) {
            timestamp = this.currentTimestamp();
        }
        return timestamp;
    }

    private long currentTimestamp() {
        return Instant.now().toEpochMilli();
    }
}
