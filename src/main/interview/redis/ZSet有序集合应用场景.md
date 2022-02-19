# ZSet有序集合应用场景
### 示例

- 排行榜应用
1. 点击新闻
    - ZINCRBY hotNews:20200819 1 总理记者会
2. 展示当日排行前十
    - ZREVRANGE hotNews:20200819 0 9 WITHSCORES
3. 七日搜索榜单计算
    - ZUNIONSTORE hotNews:20200813-20200819 7
   - hotNews:20200813 hotNews:20200814 ... hotNews:20200819
4. 展示七日排行前十
    - ZREVRANGE hotNews:202008130-20200819 0 9 WITHSCORES
