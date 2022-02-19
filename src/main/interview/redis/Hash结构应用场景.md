# Hash结构应用场景
### 说明

- 对象缓存
  
1. HMSET user {userId}:name zhuge {userId}:balance 1888
1. HMSET user 1:name zhuge 1:balance 1888
1. HMGET user 1:name 1:balance

### 示例
- 电商购物车为例
1. 以用户id为key
2. 商品id为field
3. 商品数量为value

- 购物车操作
1. 添加商品:hset cart:1001 10088 1
2. 添加数量:hincrby cart:1001 10088 1
3. 商品总数:hlen cart:1001
4. 删除商品:hdel cart:1001 10088
5. 获取购物车所有商品:hgeall cart:1001