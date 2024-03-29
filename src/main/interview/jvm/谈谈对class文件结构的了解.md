# 谈谈对class文件结构的了解

### 说明

- Class文件是一组以8个字节为基础单位的二进制流，各个数据项目严格按照顺序紧凑地排列在文件之中，中间没有添加任何分隔符，这使得整个Class文件中存放的内容几乎全部是程序运行的必要数据，没有空隙存在。
- Class文件格式采用一种类似于C语言结构体的伪结构来存储数据，这种伪结构中只有两种数据类型：**无符号数**和**表**
- 无符号数属于基本的数据类型，以u1、u2、u4、u8来分别表示1个字节、2个字节、4个字节和8个字节的无符号数，无符号数可以用来描述数字、索引引用、数量值或者按照UTF-8编码构成字符串值
- 表是由多个无符号数或者其他表作为数据项构成的复合数据类型，为了便于区分，所有表的命令都习惯用'_info'结尾。表用于描述有层次关系的复合机构的数据，整个Class文件本质上也可以看做是一张表。