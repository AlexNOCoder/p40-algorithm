package common.string_match;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: BM算法
 * @date 2022-03-02 21:20:36
 */
public class BoyerMoore {
    private static final int SIZE = 256;
    private static void generateDict(char[]b,int m,int[]dc){
        for(int i=0;i<SIZE;++i){
            dc[i] = -1;
        }
        // 将模式串中的字符写入到字典中
        for(int i=0;i<m;i++){
            // 计算b[i]的ASCII值
            int ascii = (int)b[i];
            dc[ascii] = i;
        }
    }

    private static int bmSearch(char[] a,char[] b){
        // 主串长度
        int n = a.length;
        // 模式串长度
        int m = b.length;
        // 创建字典
        int[] bc = new int[SIZE];
        // 构建坏字符串哈希表，记录模式串中每个字符最后出现的位置
        generateDict(b,m,bc);
        // i表示主串与模式串对齐的第一个字符
        int i = 0;
        while(i <= n - m){
            int j;
            // 模式串从后往前匹配
            for(j = m - 1;j >= 0; --j) {
                // i+j : 不匹配的位置
                if (a[i + j] != b[j]) {
                    // 坏字符对应模式串中的下标是j
                    break;
                }
            }
                if(j < 0){
                    // 匹配成功，返回主串与模式串第一个匹配的字符的位置
                    return i;
                }
            // 这里等同于将模式串往后滑动j-bc[(int)a[i+j]]位
            // j:如果不发生匹配，坏字符对应的模式串中的字符下标
            // bc[(int)a[i+j]:如果坏字符在模式串中存在，坏字符在模式串中的下标
            i = i +(j - bc[(int)a[i+j]]);
        }
        return -1;
    }
}
