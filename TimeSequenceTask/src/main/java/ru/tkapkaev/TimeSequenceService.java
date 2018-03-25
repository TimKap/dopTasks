package ru.tkapkaev;


import java.util.LinkedList;
import java.util.List;

/**
 * Class TimeSequenceService описывает работу с временной последовательностью (dt:datetime, y:value).
 * @author Timur Kapkaev (timur.kap@yandex.ru)
 * @version $Id$
 * @since 23.02.218
 * @param <E> тип value
 * */
public class TimeSequenceService<E> {

    /**
     * Объединяет последовательности, образуя новую последовательность.
     * @param row1 - исходная последовательность
     * @param row2 - последовательность, смещенная относительно исходной
     * @return последовательность, образованная слиянием двух последователностей
     * */
    public List<TimePair<E>> merge(List<TimePair<E>> row1, List<TimePair<E>> row2) {
        TimePair<E> edge = row2.get(0);
        List<TimePair<E>> rightPartOfRow1 = rightPartOfSequence(edge, row1);
        List<TimePair<E>> row3 = new LinkedList<>();
        int i = 0;
        for (TimePair<E> pair : row2) {
            while (i < rightPartOfRow1.size() && i < row2.size() && rightPartOfRow1.get(i).getKey().compareTo(pair.getKey()) <= 0) {
                if (rightPartOfRow1.get(i).getKey().compareTo(pair.getKey()) < 0) {
                    row3.add(rightPartOfRow1.get(i));
                }
                i++;
            }
            row3.add(pair);
        }
        return row3;
    }

    /**
     * Возвращает правую часть последовательности, начиная с заданной пары (включительно).
     * @param edge - левая граница возвращаемой последовательности
     * @param sequence - исходная последовательность
     * @return правая часть последовательности, начиная с заданной пары (включительно)
     * */
    private List<TimePair<E>> rightPartOfSequence(TimePair<E> edge, List<TimePair<E>> sequence) {
        LinkedList<TimePair<E>> subSequence = new LinkedList<>();
        for (TimePair<E> pair : sequence) {
            if (edge.getKey().compareTo(pair.getKey()) <= 0) {
                subSequence.add(pair);
            }
        }
        return subSequence;
    }

}
