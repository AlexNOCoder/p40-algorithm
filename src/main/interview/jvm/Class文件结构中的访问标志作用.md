# Class文件结构中的访问标志作用
### 说明

在常量池结束之后，紧接着的2个字节代表访问标志(access_flags)，这个标志用于识别一些类或者接口层次的访问信息，包括：这个Class是类还是接口；是否定义为public类型，是否定义为abstract类型；如果是类的话，是否被声明为final等。