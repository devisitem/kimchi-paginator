package pagination.object;

public class PaginatedObject {

    private int startIndex;
    private int endIndex;
    private boolean ableToPreStep;
    private boolean ableToNextStep;
    private int startPage;
    private int endPage;
    private int currentPage;

    void setResultData(int startIndex, int endIndex, boolean ableToPreStep, boolean ableToNextStep, int startPage, int endPage, int currentPage) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.ableToPreStep = ableToPreStep;
        this.ableToNextStep = ableToNextStep;
        this.startPage = startPage;
        this.endPage = endPage;
        this.currentPage = currentPage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public boolean isAbleToPreStep() {
        return ableToPreStep;
    }

    public boolean isAbleToNextStep() {
        return ableToNextStep;
    }

    public int getStartPage() {
        return startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }
}
