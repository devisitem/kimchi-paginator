import pagination.constant.PaginatorConstant;
import pagination.maker.PaginationHTMLMaker;
import pagination.maker.PagingMaker;
import pagination.object.PaginatedObject;
import pagination.paginator.KimchiPaginator;

public class Main {
    public static void main(String[] args) throws Throwable {

        KimchiPaginator paginator = new KimchiPaginator();

        int currentPage = 127764;

        paginator.init(7893929,11,17, currentPage, PaginatorConstant.MYSQL_PAGING);
        PaginatedObject result = paginator.elastic()
                .build()
                .paginate();

        PagingMaker maker = new PagingMaker(result, "/board/list", true);
        maker.html().withCss().generate().download("/Users/jason/Documents/pagination/sample.html");

        String pagingLog = paginator.getPagingLog();
        System.out.println(pagingLog);
    }
}
