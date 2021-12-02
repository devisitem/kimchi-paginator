package pagination.paginator;

import pagination.calculator.PagingOption;
import pagination.constant.PaginatorConstant;
import pagination.object.PaginatedObject;
import pagination.object.PaginationObject;

public interface Paginator {

    PagingOption getPagingOption();

    void setPagingObject(PaginationObject object, PaginatorConstant constant) throws Throwable;

    void init(int totalContentsCount, int numPerPage, int contentsPerPage, int currentPage, PaginatorConstant constant) throws Throwable;

    Paginator elastic() throws Throwable;

    Paginator fixed() throws Throwable;

    Paginator pre() throws Throwable;

    Paginator next() throws Throwable;

    ResultPaginator build() throws Throwable;

    String getPagingLog();
}
