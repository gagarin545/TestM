package ru;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.entity.DivisionEntity;
import ru.service.DivisionService;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DivisionTest {
    @Resource
    private DivisionService divisionService;

    @Test
    public void test() {
        List<DivisionEntity> divisionEntities = divisionService.divisionlist();

        divisionEntities.stream().forEach(x-> System.out.println(x.getNamedivision()));
    }
}
