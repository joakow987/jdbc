

import Bowl.SearchLogDao;
import org.junit.*;

import java.time.Clock;
import java.time.LocalDateTime;

public class SearchLogTest {

    private SearchLogDao searchLogDao;

    @Before
    public void Setup(){
        searchLogDao = new SearchLogDao();
        searchLogDao.deleteAll();
    }

    @Test
    public void SearchLogTest(){

        assert(searchLogDao.select().size() == 0);
        searchLogDao.insert("dupa", true, 1, LocalDateTime.now(Clock.systemUTC()));
        assert(searchLogDao.select().size() == 1);
    }
}
