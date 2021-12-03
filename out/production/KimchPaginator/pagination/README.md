### Introduction

안녕하세요, 저는 Kimchi-dev입니다.
서버 개발자이지만, 페이징 처리가 필요한 업무를 하다, 소스 정리도 안되고 사용이 불편하여 이 페이지네이터를 만들게 되었습니다.

비록, 큰 기능은 아니지만 웹과 상관없이 자바 어플리케이션이라면 모두 사용가능한 페이지네이터 입니다.

### Usage

이 페이지 네이터는 크게 2가지 기능을 합니다.
- 페이징 처리
- DB 인덱스 추출

```java
public class BoardService {
    
    
    public Map<String, Object> getBoardList(int currentPage) {
        Map<String, Object> response = new HashMap<>();
        KimchiPaginator paginator = new KimchiPaginator();
        paginator.init(1000, 10, 10, currentPage, PaginatorConstant.MYSQL_PAGING);
        PaginatedObject paginated = paginator.elastic().build().paginate();
        
    }
    
}
```

![]()