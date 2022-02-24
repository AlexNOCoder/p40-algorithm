# 简述kafka架构设计
### 说明

- Consumer Group:消费者组，消费者组内每个消费者负责消费不同分区的数据，提高消费能力。逻辑上的一个订阅者。
- Topic：可以理解为一个队列，Topic将消息分类，生产者和消费者面向的是同一个Topic。
- Partition：为了实现扩展，提高并发能力，一个Topic以多个Partition的方式分布到多个Broker上，每个Partition是一个有序队列。一个Topic的每个Partition都有若干个副本(Replica)，一个Leader和若干个Follower。生产者发送数据的对象，以及消费者消费数据的对象，都是Leader。Follower负责实时从Leader中同步数据，保持和Leader数据的同步。Leader发生故障时，某个Follower还会成为新的Leader。