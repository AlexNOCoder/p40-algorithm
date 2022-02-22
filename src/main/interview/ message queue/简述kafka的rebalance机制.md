# 简述kafka的rebalance机制
### 说明
- consumer group中的消费者与topic下的partition重新匹配的过程
### 何时会产生rebalance
- consumer group 中的成员个数发生变化
- consumer消费超时
- group订阅的topic个数发生变化
- group订阅的topic的分区数发生变化

- coordinator：通常是partition的leader节点所在的broker，负责监控group中consumer的存活，consumer维持到coordinator的心跳，判断consumer的消费超时
  1. corrdinator通过心跳返回通知consumer进行rebalance
  1. consumer请求coordinator加入组，coordinator选举产生leader consumer
  1. leader consumer从coordinator获取所有的consumer，发送syncGroup(分配消息)给到coordinator
  1. coordinator通过心跳机制将syncGroup下发给consumer
  1. 完成rebalance
- leader consumer监控topic的变化，通知coordinator触发rebalance

### 额外问题 
- 如果C1消费消息超时，触发rebalance，重新分配后、该消息会被其他消费者消费，此时C1消费者完成提交offset，导致错误
- 解决办法：
  - coordinator每次rebalance，会标记一个Generation给consumer，每次rebalance该Generation会+1，consumer提交offset时，coordinator会对比Generation，不一致则拒绝提交