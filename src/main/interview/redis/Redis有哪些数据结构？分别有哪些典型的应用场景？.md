# Redis有哪些数据结构？分别有哪些典型的应用场景？

### 说明
Redis的数据结构有：
- 字符串：可以用来做最简单的数据缓存，可以缓存某个简单的字符串，也可以缓存某个json格式的字符串，Redis分布式锁实现就利用了这种数据结构，还包括可以实现计数器、Session共享、分布式ID
- 哈希表：可以用来存储一些key-value对，更适合用来存储对象
- 列表：Redis列表通过命令的组合，既可以当做栈，也可以当做队列来使用，可以用来缓存类似微信公众号、微博等信息流数据
- 集合：和列表类似，也可以存储多个元素，但是不能重复，集合可以进行交集、并集、差集操作，从而可以实现雷士，我和某人共同关注的人、朋友圈点赞等功能
- 有序集合：集合是无序的，有序集合可以设置顺序，可以用来实现排行榜功能