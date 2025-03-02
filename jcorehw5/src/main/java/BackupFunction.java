import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;

/*
Задание №1: Написать функцию, создающую резервную копию всех файлов 
в директории(без поддиректорий) во вновь созданную папку ./backup 
 */

public class BackupFunction {
    public static void main(String[] args) throws IOException {
        
        
        if (Files.notExists(Path.of("./backup"))) {
        Files.createDirectory(Path.of("./backup"));
        }

        DirectoryStream<Path> dir = 
        Files.newDirectoryStream(Path.of("./123"));

        for (Path file : dir) {
            if (Files.isRegularFile(file)){
                if (Files.notExists(Path.of("./backup/" + file.getFileName()))) {
                    Files.copy(file,
                    Path.of("C:\\Users\\mrpar\\Desktop\\JCoreHW-5\\backup\\" + file.getFileName()));
            }
        }
        }


    
    }
}
