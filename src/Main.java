import pagination.constant.PaginatorConstant;
import pagination.object.PaginatedObject;
import pagination.paginator.KimchiPaginator;

public class Main {
    public static void main(String[] args) throws Throwable {

        KimchiPaginator paginator = new KimchiPaginator();
        boolean pre = true;
        boolean next = false;

        int currentPage = 12;
        paginator.init(1000,10,10, currentPage, PaginatorConstant.MYSQL_PAGING);
        paginator.elastic();

        if(pre) {
            paginator.pre();
        } else if (next) {
            paginator.next();
        }
        PaginatedObject paginate = paginator.build().paginate();
        System.out.println(paginator.getPagingLog());

    }
}
