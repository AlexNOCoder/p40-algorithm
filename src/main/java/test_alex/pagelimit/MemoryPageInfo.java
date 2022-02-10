package test_alex.pagelimit;

import com.google.common.base.Preconditions;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 分页信息
 * @date 2021-12-28 10:55:32
 */
public class MemoryPageInfo {
    private Integer pageSize;
    private Integer pageNum;

    public MemoryPageInfo(Integer pageSize, Integer pageNum) {
        checkNotNull(pageSize,pageNum);
        checkArgument(pageSize,pageNum);
        this.pageSize = pageSize;
        this.pageNum = pageNum;
    }
    private void checkNotNull(Integer pageSize, Integer pageNum){
        Preconditions.checkNotNull(pageSize);
        Preconditions.checkNotNull(pageNum);
    }
    private void checkArgument(Integer pageSize, Integer pageNum){
        Preconditions.checkArgument(pageSize > 0);
        Preconditions.checkArgument(pageNum > 0);
    }


    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }
}
