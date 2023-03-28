import java.util.*;

public class Array<T> {
    private T[] array;
    private Integer size;

    public Array() {
        this.array = (T[]) new Object[0];
        this.size = 0;
    }

    public Array(T[] array) {
        this.array = Arrays.copyOf(array, array.length);
        this.size = array.length;
    }

    public T[] inputElem(T[] array, T elem) {
        ArrayList<T> input = new ArrayList<>(Arrays.asList(array));
        input.add(elem);
        return (T[]) input.toArray();
    }

    public T[] deleteElem(T[] array, int index) throws Exception {
        if (size == 0)
        throw new Exception("Массив пустой");
        ArrayList<T> delete = new ArrayList<>(Arrays.asList(array));
        delete.remove(index);
        return (T[]) delete.toArray();
    }

    public T[] deleteValue(T[] array, T value) throws Exception {
        if (size == 0)
        throw new Exception("Массив пустой");
        ArrayList<T> deleteIf = new ArrayList<>(Arrays.asList(array));
        if (deleteIf.contains(value)) {
            deleteIf.remove(value);
        }

        return (T[]) deleteIf.toArray();

    }

    public T findMin() throws Exception {
        if (size == 0)
        throw new Exception("Массив пустой");
        T min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (((Comparable) array[i]).compareTo(min) < 0) {
                min = array[i];
            }
        }

        return min;
    }

    public T findMax() throws Exception {
        if (size == 0)
        throw new Exception("Массив пустой");
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (((Comparable) array[i]).compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }

    public Object sum() throws Exception {
        if (size == 0)
            throw new Exception("Массив пустой");
        if (array[0] instanceof Number) {
            Number sum = 0;
            for (int index = 0; index < array.length; index++) {
                sum = sum.intValue() + ((Number) (array[index])).intValue();
            }
            return sum;
        }
        if (array[0] instanceof String) {
            StringBuilder sumStr = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                sumStr.append((String) array[i]);
            }
            return sumStr;
        }
        return null;
    }

    public Object multiply() throws Exception {
        if (size == 0)
            throw new Exception("Массив пустой");
        if (array[0] instanceof String) {
            throw new Exception("Нельзя перемножить строковые значения");
        }
        if (array[0] instanceof Number) {
            Number result = 1;
            for (int i = 0; i < array.length; i++) {
                result = result.doubleValue() * ((Number) array[i]).doubleValue();
            }
            return result;
        }
        return null;
    }

    public Object fildIndex(int elem) throws Exception {
        if (size == 0)
        throw new Exception("Массив пустой");
        ArrayList<T> finder = new ArrayList<>(Arrays.asList(array));
        for (int index = 0; index < array.length; index++) {
            if (finder.contains(elem)) {
                String res = String.format("Элемент содержится под индексом %d", finder.indexOf(elem));
                return res;
            } else {
                return -1;
            }
        }
        return null;
    }

    public Boolean presense(T elem) {
        for (int j = 0; j < array.length; j++) {
            if (array[j].equals(elem)) {
                return true;
            }
        }
        return null;
    }

    public T bubbleSort() throws Exception {
        if (array[0] instanceof String) {
            throw new Exception("Массив не подлежит сортировке пузырьком");
        }

        if (array[0] instanceof Number) {

            Boolean sorted = false;
            while (!sorted) {
                sorted = true;
                for (int j = 0; j < array.length; j++) {
                    if (((Number) array[j]).doubleValue() < ((Number) array[j - 1]).doubleValue()) {
                        T temp = array[j];
                        array[j] = array[j - 1];
                        array[j - 1] = temp;
                        sorted = false;
                    }
                }

            }
            return (T) array;
        }
        return null;

    }

    public void insertSort() {
        for (int index = 1; index < array.length; index++) {
            T current = array[index];
            int i = index;
            while (i > 0 && ((Comparable) array[i - 1]).compareTo((Comparable) current) > 0) {
                array[i] = array[i - 1];
                i--;
            }
            array[i] = current;
        }
    }

    public void simpleChoiceSort() {
        for (int index = 0; index < array.length; index++) {
            int i = minIndex(array, index);

            T temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }

    public int minIndex(T[] array, int startIndex) {
        int minIndex = startIndex;
        T minVal = array[startIndex];
        for (int i = 0; i < array.length; i++) {
            if (((Comparable) array[i]).compareTo((Comparable) minVal) < 0) {
                minVal = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public T getElem(int index) {
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                return (T) array[i];
            }
        }
        return null;
    }

    public void setValue(int index, T value) {
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                array[i] = value;
            }
        }
    }

    public void print() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            out.append(array[i]);
        }

        System.out.println(out.toString());
    }

    public int sizeArray() {
        int count = 0;
        for (int index = 0; index < array.length; index++) {
            count += 1;
        }
        return count;
    }

}
