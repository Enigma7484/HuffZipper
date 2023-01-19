import java.util.*;
import java.io.*;

public class HuffCompression {
    private static StringBuilder sb = new StringBuilder();
    private static Map<Byte, String> huffmap = new HashMap<>();

    public static void compress(String src, String dst) {
        try {
            FileInputStream inStream = new FileInputStream(src);
            byte[] b = new byte[inStream.available()];
            inStream.read(b);
            byte[] huffmanBytes = createZip(b);
            OutputStream outStream = new FileOutputStream(dst);
            ObjectOutputStream objectOutStream = new ObjectOutputStream(outStream);
            objectOutStream.writeObject(huffmanBytes);
            objectOutStream.writeObject(huffmap);
            inStream.close();
            objectOutStream.close();
            outStream.close;
        } catch (Exception e) {
            e.printStackTrace(); }
        }
        private static byte[] createZip(byte[] bytes) {
            MinPriorityQueue<ByteNode> nodes = getByteNodes(bytes);
            ByteNode root = createHuffmanTree(nodes);
            Map<Byte, String> huffmanCodes = getHuffCodes(root);
            byte[] huffmanCodeBytes = zipBytesWithCodes(bytes, huffmanCodes);
            return huffmanCodeBytes;
        }
}
























