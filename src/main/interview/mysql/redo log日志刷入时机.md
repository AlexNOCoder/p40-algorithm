# redo log日志刷入磁盘时机

1. 写入redo log buffer的日志已经占了redo log buffer总容量的一半，会把他们全部刷入磁盘
1. 一个事务提交的时候，会把这个事务的redo log所在的redo log bolck都刷入到磁盘文件中，只有这样，当事务提交之后，才能保证数据不丢失（事务提交时，redo log写入磁盘也是先进入os cache的，进入os的文件缓冲去里，是否提交事务就强行把redo log刷入物理磁盘，需要设置对应参数）
1. 后台线程定时刷新，有一个后台线程每隔1秒就会把redo log buffer里的redo log block刷到磁盘文件里
1. mysql 关闭的时候，redo log block都会刷入到磁盘里去