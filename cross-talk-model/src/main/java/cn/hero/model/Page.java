package cn.hero.model;

/**
 * 分页查询使用
 * Author:lijie
 */
public class Page {
    private Integer pageNo; //前端传入第几页
    private Integer pageSize;   //每页数据条数
    private Integer pageStart;  //后台得出sql中所需

    public Page() {
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageNo, Integer pageSize) {
        this.pageStart = (pageNo - 1)*pageSize;
    }
}
