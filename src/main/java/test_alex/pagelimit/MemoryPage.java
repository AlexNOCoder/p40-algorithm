package test_alex.pagelimit;

import java.util.List;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 分页内容
 * @date 2021-12-28 10:56:58
 */
public class MemoryPage<T> {
    private MemoryPageInfo memoryPageInfo;
    private Integer toatal;
    private List<T> pageData;


    public MemoryPage(MemoryPageInfo memoryPageInfo, Integer toatal, List<T> pageData) {
        this.memoryPageInfo = memoryPageInfo;
        this.toatal = toatal;
        this.pageData = pageData;
    }


    public MemoryPageInfo getMemoryPageInfo() {
        return memoryPageInfo;
    }

    public Integer getToatal() {
        return toatal;
    }

    public List<T> getPageData() {
        return pageData;
    }
}
