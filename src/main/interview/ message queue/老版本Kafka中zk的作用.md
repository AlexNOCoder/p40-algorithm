# 老版本Kafka中zk的作用
### 说明

- /broker/ids:临时节点，保持所有broker节点信息，存储broker的物理地址，版本信息，启动时间等，节点名称为brokerID，broker定时发送心跳到zk，如果断开则该brokerID会被删除

- /borker/topics:临时节点，节点保存broker节点下所有的topic信息，每一个topic节点下包含一个固定的partitions节点，partitions的子节点就是topic的分区，每个分区下保存的一个state节点，保存着当前leader分区和ISR的brokerID，state节点由leader创建，若leader宕机该节点会被删除，直到有新的leader选举产生、重新生成state节点。

- /consumers/[group_id]/owners/[topic]/[broker_id-partition_id]：维护消费者和分区的注册关系
- /consumers/[group_id]/offsets/[topic]/[broker_id-partition_id]: 分区消息的消费进度offset

- client通过topic找到topic树下的state节点。获取leader的brokerID，到broker树种找到broker的物理地址，但是client不会直连zk，而是通过配置的broker获取到zk的信息。