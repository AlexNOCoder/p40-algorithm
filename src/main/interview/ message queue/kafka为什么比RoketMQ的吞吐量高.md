# kafka为什么比RoketMQ的吞吐量高
### 说明
Kafka的生产者采用的是异步发送消息机制，当发送一条消息时，消息并没有发送到Broker而是缓存起来，然后直接向业务返回成功，当缓存的消息达到一定数量时再批量发送到Broker。这种做法减少了网络IO，从而提高了消息发送的吞吐量，但是如果消息生产者宕机，会导致消息丢失，业务出错，所以理论上kafka利用此机制提高了性能却降低了可靠性。