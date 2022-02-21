# Set结构应用场景
### 说明

SINTER set1 set2 set3 交集
SUNION set1 set2 set3 并集
SDIFF set1 set2 set 3 差集


### 示例

- 微信抽奖小程序为例
1. 点击参与抽奖加入集合
   - SADD key {userID}
2. 查看参与抽奖所有用户
    - SMEMBERS key
3. 抽取count名中奖者
    - SRANDMEMBER key [count]  放回
   - SPOP key [count]  不放回

- 微信微博点赞，收藏，标签
1. 点赞
    - SADD like:{消息ID} {用户ID}
2. 取消点赞
    - SREM like:{消息ID} {用户ID}
3. 检查用户是否点赞
    - SISMEMBER like:{消息ID} {用户ID}
4. 获取点赞的用户列表
    - SMEMBERS like:{消息ID}
5. 获取点赞用户数
    - SCARD like:{消息ID}

- 集合操作实现微博微信关注模型
1. a关注的人
    - aSet -> {b,c,e}
2. b关注的人
    - bSet -> {a,c,e,f}
3. c关注的人
    - cSet ->{b,c,f}
4. a和b共同关注的人
    - SINTER aSet bSet -> {c,e}
5. a关注的人也关注了b
    - SISMEMBER cSet b
   - SISMEMBER eSet b
6. a可能认识的人
    - SDIFF bSet aSet ->{f}


- 内部编码
   - 整型集合(intset)
   - 哈希表(Hashtable)