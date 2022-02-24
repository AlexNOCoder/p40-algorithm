# class文件的方法表存储什么信息

### 说明
Class文件存储格式中对方法的描述和对字段的描述采用了几乎完全一致的方式，方发表的结构如同字段表一样。
依次包括访问标志(access_flags)、名称索引(name_index)、描述符索引(descriptor_index)、属性表集合(attributes)