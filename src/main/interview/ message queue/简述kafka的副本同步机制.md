# 简述kafka的副本同步机制

### 相关词条

- LEO:下一条待写入位置
- firstUnstableOffset：第一条未提交数据
- LastStableOffset：最后一条已提交数据
- LogStartOffset：起始位置
- ISR:如果一个follower落后leader不超过某个时间阈值，则放在ISR中，否则放在OSR中

### 副本同步
- 当isolation.level = read_committed：只能消费到LastStableOffset，read_committed可以消费到HW的上一条
- 一个parttition对应的ISR中最小的LEO作为分区的HW，consumer最多只能消费到HW所在的位置
- leader收消息会更新本地的LEO，leader还会维护follower的LEO即remote LEO，follower发出fetch同步数据请求时(携带自身的LEO)、leader会更新remote LEO，更新分区的HW，然后将数据响应给follower、follower更新自身HW(取响应中的HW和自身的LEO中的较小值)，LEO+1
- 同步副本时，follower获取leader的LEO和LogstartOffset，与本地对比，如果本地的LogStartOffset超出了leader的值，则超过这个值的数据删除，在进行同步，如果本地的小于leader的，则直接同步