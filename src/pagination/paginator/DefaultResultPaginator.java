package pagination.paginator;

import pagination.calculator.Calculator;
import pagination.object.PaginatedObject;

public class DefaultResultPaginator implements ResultPaginator {
    private Calculator calculator;

    public DefaultResultPaginator(Calculator calculator) {
        this.calculator = calculator;
    }
    @Override
    public PaginatedObject paginate() {
        return calculator.getResult();
    }
}
