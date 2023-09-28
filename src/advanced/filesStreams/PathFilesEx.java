package advanced.filesStreams;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.HashSet;
import java.util.List;

public class PathFilesEx {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("advanced\\filesStreams\\test.txt").toAbsolutePath();
        Path path1 = Paths.get("advanced\\filesStreams\\test2.txt");

        Files.copy(path, path1, StandardCopyOption.REPLACE_EXISTING);
        Files.move(path1, Paths.get("advanced\\filesStreams\\test3.txt"), StandardCopyOption.REPLACE_EXISTING);
        Files.deleteIfExists(path1);

        System.out.println(Files.size(path));
        System.out.println("is directory: "+Files.isDirectory(path));
        System.out.println("is executable: "+Files.isExecutable(path));
        System.out.println("is regular file: "+Files.isRegularFile(path));
        System.out.println("is hidden: "+Files.isHidden(path));
        System.out.println("is readable: "+Files.isReadable(path));
        System.out.println("is writable: "+Files.isWritable(path));

        System.out.println(Files.getAttribute(path,"size",LinkOption.NOFOLLOW_LINKS));
        System.out.println(Files.getAttribute(path,"isRegularFile",LinkOption.NOFOLLOW_LINKS));

        /*BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        PosixFileAttributes posix = Files.readAttributes(path, PosixFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
        attributes.creationTime();*/
        byte[] data = Files.readAllBytes(path);
        Files.write(path1, "bla\nla".getBytes());

        List<String> lines = Files.readAllLines(path1);

        try(DirectoryStream<Path> entries = Files.newDirectoryStream(Paths.get("advanced"))){
            for (Path entry : entries){
                System.out.println(entry.getFileName());
            }
        }
        System.out.println("FileVisitor:");
        Files.walkFileTree(Paths.get("advanced"),new MyFileVisitor());
        //Files.walkFileTree(Paths.get("advanced"), new HashSet<>(),2,new MyFileVisitor());
    }
    static class MyFileVisitor extends SimpleFileVisitor<Path>{
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            System.out.println(file.getFileName());
            return FileVisitResult.CONTINUE;
        }
    }
}
