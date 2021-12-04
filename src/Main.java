import pagination.constant.PaginatorConstant;
import pagination.maker.Maker;
import pagination.maker.PaginationHTMLMaker;
import pagination.maker.PagingMaker;
import pagination.object.PaginatedObject;
import pagination.paginator.KimchiPaginator;

public class Main {
    public static void main(String[] args) throws Throwable {

        int currentPage = 127764;


        KimchiPaginator paginator = new KimchiPaginator();
        paginator.init(7893929,11,17, currentPage, PaginatorConstant.MYSQL_PAGING);

        PaginatedObject result = paginator.elastic().build().paginate();

        PagingMaker maker = new PagingMaker(result, "/board/list");
        maker.html().withCss().generate().download("/Users/jason/Documents/pagination/sample.html");

        String pagingLog = paginator.getPagingLog();
        System.out.println(pagingLog);
    }
}
