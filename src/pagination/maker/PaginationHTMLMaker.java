package pagination.maker;

import pagination.object.PaginatedObject;

import javax.swing.text.html.HTMLWriter;

public class PaginationHTMLMaker {

    private PaginatedObject target;
    private boolean exposeDisabledMoveBlock;
    private String pre;
    private String next;

    private static final String TAB = "\t";
    private static final String NEW = "\n";

    public PaginationHTMLMaker(PaginatedObject target) {
        this.target = target;
        this.exposeDisabledMoveBlock = false;
        this.pre = "Pre";
        this.next = "Next";
    }

    public PaginationHTMLMaker(PaginatedObject target, boolean exposeDisabledMoveBlock) {
        this.target = target;
        this.exposeDisabledMoveBlock = exposeDisabledMoveBlock;
        this.pre = "Pre";
        this.next = "Next";
    }

    public void setMoveButtonName(String pre, String next) {
        this.pre = pre;
        this.next = next;
    }

    public String generate(String endPoint) {
       StringBuilder builder = new StringBuilder();

       builder
               .append("<nav aria-label=\"Pagination Container\">").append(NEW)
               .append(TAB).append("<ul class=\"pagination\">").append(NEW);
       if(this.target.isAbleToPreStep()) {
           builder
                   .append(TAB).append(TAB).append("<li class=\"page-item\">").append(NEW)
                   .append(TAB).append(TAB).append(TAB).append("<a class=\"pre-button\" href=\""+endPoint+"?currentPage="+this.target.getCurrentPage()+"&pre=true\">"+pre+"</a>").append(NEW)
                   .append(TAB).append(TAB).append("</li>").append(NEW);
       } else if(this.exposeDisabledMoveBlock && ! this.target.isAbleToPreStep()) {
           builder
                   .append(TAB).append(TAB).append("<li class=\"page-item disabled\">").append(NEW)
                   .append(TAB).append(TAB).append(TAB).append("<span class=\"pre-button\">"+pre+"</span>").append(NEW)
                   .append(TAB).append(TAB).append("</li>").append(NEW);
       }
       for (int i = this.target.getStartPage();i <= this.target.getEndPage();i++) {

           if(i != this.target.getCurrentPage()) {
               builder
                       .append(TAB).append(TAB).append("<li class=\"page-item\" aria-current=\"page\">").append(NEW)
                       .append(TAB).append(TAB).append(TAB).append("<a class=\"page-link\" href=\""+endPoint+"?currentPage="+i+"\">"+i+"</a>").append(NEW)
                       .append(TAB).append(TAB).append("</li>").append(NEW);
           } else {
               builder
                       .append(TAB).append(TAB).append("<li class=\"page-item active disabled\"><a class=\"page-link\">"+i+"</a></li>\n");
           }
       }
       if(this.target.isAbleToNextStep()) {
           builder
                   .append(TAB).append(TAB).append("<li class=\"page-item\">").append(NEW)
                   .append(TAB).append(TAB).append(TAB).append("<a class=\"next-button\" href=\""+endPoint+"?currentPage="+this.target.getCurrentPage()+"&next=true\">"+next+"</a>").append(NEW)
                   .append(TAB).append(TAB).append("</li>").append(NEW);

       } else if(this.exposeDisabledMoveBlock && ! this.target.isAbleToNextStep()) {
           builder
                   .append(TAB).append(TAB).append("<li class=\"page-item disabled\">").append(NEW)
                   .append(TAB).append(TAB).append(TAB).append("<span class=\"next-button\">"+next+"</span>").append(NEW)
                   .append(TAB).append(TAB).append("</li>").append(NEW);
       }
       builder
               .append(TAB).append("</ul>").append(NEW)
               .append("</nav>").append(NEW)
               .append(getDefaultCSS()).append(NEW)
       ;



        return builder.toString();
    }

    private String getDefaultCSS() {
        String css =
                "<style>\n" +
                        "\t.pagination-container {\n" +
                        "\t\tpadding: auto 0;\n" +
                        "\t}\n" +
                        "\t\n" +
                        "\tul.pagination {\n" +
                        "\t\tmargin: 0 0;\n" +
                        "\t}\n" +
                        "\tul.pagination li {\n" +
                        "\t\tlist-style-type: none;\n" +
                        "\t\tfloat: left;\n" +
                        "\t}\n" +
                        "\n" +
                        "\t.pagination li {\n" +
                        "\t\tmargin: 0 6px;\n" +
                        "\t}\n" +
                        "\tli.page-item {\n" +
                        "\t\tfont-size: 1rem;\n" +
                        "\t}\n" +
                        "\t.pagination .active .page-link {\n" +
                        "\t\tbackground-color: #3b64e8;\n" +
                        "\t\tborder-radius: 5px;\n" +
                        "\t\tcolor: white;\n" +
                        "\t\tcursor: default;\n" +
                        "\t}\n" +
                        "\t\n" +
                        "\t.pagination .disabled span{\n" +
                        "\t\tcolor: gray;\n" +
                        "\t}\n" +
                        "\n" +
                        "\t:where(li.page-item a.page-link, a.pre-button, a.next-button):hover {\n" +
                        "\t\tbackground-color: #3b64e8;\n" +
                        "\t\tcolor: white;\n" +
                        "\t\ttransition: .6s;\n" +
                        "\t\tborder-radius: 5px;\n" +
                        "\t\tcursor: pointer;\n" +
                        "\t}\n" +
                        "\t\n" +
                        "\t:where(li.page-item a.page-link, a.pre-button,a.next-button) {\n" +
                        "\t\tbackground-color: white;\n" +
                        "\t\tcolor: black;\n" +
                        "\t\ttext-decoration: none;\n" +
                        "\t\ttransition: .6s;\n" +
                        "\t\tborder-radius: 5px;\n" +
                        "\t\tpadding: 2px 10px;\n" +
                        "\t\tcursor: pointer;\n" +
                        "\t}\n" +
                        "</style>";

        return css;
    }

}
