import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
Задание №2: Предположить, что числа в исходном массиве из 9 элементов имеют 
диапазон[0, 3], и представляют собой, например, состояния ячеек 
поля для игры в крестикинолики, где 0 – это пустое поле, 1 – это поле с 
крестиком, 2 – это поле с ноликом, 3 – резервное значение. Такое 
предположение позволит хранить в одном числе типа int всё поле 3х3. 
Записать в файл 9 значений так, чтобы они заняли три байта.

как сказано на семинаре: Не обязательное задание *: скриншот запущенного и функционирующего приложения 
dvwa-docker; скриншот успешного цикла CI/CD для проекта dvwa-docker
 */

public class Array9 {

    public static void main(String[] args) throws IOException {
        
        int[] arrayXO = {0,1,2,3,0,1,2,3,0};
        int[] arrayXOFromFile = new int[9];
        FileOutputStream fOutputStream = new FileOutputStream("./arrayXO.txt");
        FileInputStream fInputStream = new FileInputStream("./arrayXO.txt");
        int byteRead;
        int c = 0;
        
        // запись в файл массива
        // запись в 3 байта (тоесть три раза - i = 0; i < 3; i++)
        // записываются 3 разных цифры в 3 байта
        // цифры создаются во вложенном цикле
        for (int i = 0; i < 3; i++) {
            byte wr = 0;
            for (int j = 0; j < 3; j++) { 
                // здесь 3 разных цифры складываются и помещаются в один байт.
                // и так 3 раза и все цифры разные
                wr += (byte) (arrayXO[3 * i + j] << (j * 2));
            }

            fOutputStream.write(wr);
            
        }

        fOutputStream.flush();
        fOutputStream.close();
        
        // Считывание данных из файла
        // Пока не достигнут конец файла (!= -1)
        // byteRead - имеет тип int
        while ((byteRead = fInputStream.read()) != -1) {
            // берем байт по очереди
            for (int i = 0; i < 3; ++i) {
                // этот байт сдвигается три раза,
                // каждый рас на разное количество знаков
                // а потом Битовая операция & сравнивает два числа
                // по правилам сровнения Битов в двоичной системе
                // 0x3 - это 011 в двоичной системе
                arrayXOFromFile[c++] = (byteRead >> (i * 2)) & 0x3;  
            }
        }
        
        fInputStream.close();

        System.out.println(Arrays.toString(arrayXOFromFile));



    }

}
