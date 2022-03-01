# 64位JVM，new Object()新创建的对象在Java中占用多少内存

### 说明

markword 8字节，因为java 默认使用了classPointer压缩，classpointer 4字节，对象实例0字节，padding 4字节，因此是16字节
如果没开启classpointer默认压缩，markword 8 字节，classpointer 8 字节，对象实例0字节，padding 0字节也是16字节。