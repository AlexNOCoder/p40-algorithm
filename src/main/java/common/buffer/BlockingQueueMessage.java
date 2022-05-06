package common.buffer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 消息队列
 * @date 2022-05-05 17:48:48
 */
public class BlockingQueueMessage {
    public static BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
}
