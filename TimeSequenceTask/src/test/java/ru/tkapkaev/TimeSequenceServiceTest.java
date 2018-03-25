package ru.tkapkaev;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class TimeSequenceServiceTest содержит тесты к классу SequenceServiceTest.
 * @author Timur Kapkaev (timur.kap@yandex.ru)
 * @version $Id$
 * @since 23.03.2018
 * */
public class TimeSequenceServiceTest {

    /**
     * Тест merge.
     * */
    @Test
    public void whenMergeThenGetMergedSequence() {
        ArrayList<TimePair<Integer>> pairs = new ArrayList<>(Arrays.asList(
                new TimePair<>(new Date(1), 1), new TimePair<>(new Date(2), 2), new TimePair<>(new Date(4), 3),
                new TimePair<>(new Date(4), 4), new TimePair<>(new Date(5), 5), new TimePair<>(new Date(6), 6)
        ));

        List<TimePair<Integer>> row1 = new ArrayList<>(Arrays.asList(pairs.get(0), pairs.get(3), pairs.get(4)));
        List<TimePair<Integer>> row2 = new ArrayList<>(Arrays.asList(pairs.get(1), pairs.get(2), pairs.get(5)));

        TimeSequenceService<Integer> service = new TimeSequenceService<>();
        List<TimePair<Integer>> result = service.merge(row1, row2);
        assertThat(result.get(0), is(pairs.get(1)));
        assertThat(result.get(1), is(pairs.get(2)));
        assertThat(result.get(2), is(pairs.get(4)));
        assertThat(result.get(3), is(pairs.get(5)));
    }

}
