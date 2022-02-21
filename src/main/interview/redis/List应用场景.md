#List应用场景
### 说明

- 常用数据结构
  - Stack(栈) = LPUSH +  LPOP  = FILO
  - Queue(队列) = LPUSH + RPOP  = FIFO
  - locking MQ(阻塞队列) = LPUSH + BRPOP


### 示例
微博和微信公众号消息流为例：
用户A关注了用户B，用户C等大V
1. B发微博，消息ID为10018
   - LPUSH msg:{A-ID} 10018 
   
2. C发微博，消息ID为10086
   - LPUSH msg:{A-ID} 10086 
   
3. A查看最新微博消息
   - LRANGE msg:{A-ID} 0 4
    
- 内部编码
  - 双端链表(Linkedlist)
  - 压缩表(Ziplist)  