import pagination.constant.PaginatorConstant;
import pagination.maker.PaginationHTMLMaker;
import pagination.maker.PagingMaker;
import pagination.object.PaginatedObject;
import pagination.paginator.KimchiPaginator;

public class Main {
    public static void main(String[] args) throws Throwable {

        KimchiPaginator paginator = new KimchiPaginator();

        int currentPage = 6;

        paginator.init(160,7,8, currentPage, PaginatorConstant.MYSQL_PAGING);
        PaginatedObject result = paginator.fixed()
                .build()
                .paginate();

        PagingMaker maker = new PagingMaker(result, "/board/list", true);
        maker.html().withCss().generate().download("/Users/jason/Documents/pagination/sample.html");

        String pagingLog = paginator.getPagingLog();
        System.out.println(pagingLog);
    }
}
