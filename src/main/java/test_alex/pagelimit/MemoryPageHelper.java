package test_alex.pagelimit;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author luoyuntian
 * @program: p40-algorithm
 * @description: 内存分页
 * @date 2021-12-28 10:44:31
 */
public class MemoryPageHelper<T> {
    private List<T> orginalData;
    private MemoryPageInfo pageInfo;

    public MemoryPageHelper(List<T> orginalData, MemoryPageInfo pageInfo) {
        this.orginalData = orginalData;
        this.pageInfo = pageInfo;
    }

    public MemoryPage<T> fetchData(){
        List<T> data = doFetchData();
        return  new MemoryPage(pageInfo,orginalData.size(),data);
    }

    private List<T> doFetchData(){
       return orginalData.stream().skip(pageInfo.getPageNum()-1 < 0 ? 0 :(pageInfo.getPageNum()-1)*pageInfo.getPageSize()).limit(pageInfo.getPageSize()).collect(Collectors.toList());
    }
}
