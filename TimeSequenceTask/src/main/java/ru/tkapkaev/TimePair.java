package ru.tkapkaev;

import java.util.Date;
/**
 * Class TimePair описывает временную пару.
 * @author Timur Kapkaev (timur.kap@yandex.ru)
 * @version $Id$
 * @since 23.03.2018
 * @param <E> - тип значения пары
 * */
public class TimePair<E> extends Pair<Date, E> {
    /**
     * Конструтктор класса TimePair.
     * @param key - ключ
     * @param value - значение
     * */
    public TimePair(Date key, E value) {
        super(key, value);
    }
}
