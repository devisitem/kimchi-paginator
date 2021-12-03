import pagination.constant.PaginatorConstant;
import pagination.maker.PaginationHTMLMaker;
import pagination.object.PaginatedObject;
import pagination.paginator.KimchiPaginator;

public class Main {
    public static void main(String[] args) throws Throwable {

        KimchiPaginator paginator = new KimchiPaginator();

        int currentPage = 9;

        paginator.init(125,8,3, currentPage, PaginatorConstant.MYSQL_PAGING);
        PaginatedObject result = paginator.elastic()
                .build()
                .paginate();


        PaginationHTMLMaker maker = new PaginationHTMLMaker(result);
        String html = maker.generate("/board/list");
        String pagingLog = paginator.getPagingLog();
        System.out.println(html);
        System.out.println(pagingLog);
    }
}
