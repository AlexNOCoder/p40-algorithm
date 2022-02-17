# spring如何处理线程并发问题
### 解决方式

1. 修改scope为多例 prototype
2. 将成员变量放在ThreadLocal当中（注意ThreadLoca线程安全问题，tomcat也是用的线程池，用完记得清空）
3. 同步锁 加入sychronized 会影响服务器的吞吐量
4. 变量放在方法内