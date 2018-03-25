package ru.tkapkaev;

/**
 * Class Pair описывает пару <ключ:значение>.
 * @author Timur Kapakev (timur.kap@yandex.ru)
 * @version $Id$
 * @since 23.03.2018
 * @param <K> тип ключа
 * @param <V> - тип значения
 * */
public class Pair<K, V> {
    /** ключ. */
    private K key;
    /** значение. */
    private V value;
    /**
     * Конструктор класса Pair.
     * @param key - ключ
     * @param value - значение
     * */
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Возвращает ключ пары.
     * @return ключ пары
     * */
    public K getKey() {
        return key;
    }

    /**
     * Задает ключ пары.
     * @param key - ключ пары
     * */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Возвращает значение пары.
     * @return значение пары
     * */
    public V getValue() {
        return value;
    }

    /**
     * Задает значение пары.
     * @param value - значение пары
     * */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Проверяет равенство объектов.
     * @param o - сравниваемый объект
     * @return true, если объекты равны
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return key != null ? key.equals(pair.key) : pair.key == null;
    }

    /**
     * Вовзращает хеш-функцию.
     * @return хеш-код
     * */
    @Override
    public int hashCode() {
        return key != null ? key.hashCode() : 0;
    }
}
