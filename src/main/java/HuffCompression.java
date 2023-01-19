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

        private static MinPriorityQueue<ByteNode> getByteNodes(byte[] bytes) {
            MinPriorityQueue<ByteNode> nodes = new MinPriorityQueue<ByteNode>();
            Map<Byte, Integer> tempMap = new HashMap<>();
            for (byte b : bytes) {
                Integer value = tempMap.get(b);
                if (value == null)
                    tempMap.put(b, 1);
                else
                    tempMap.put(b, value + 1);
            }
            for (Map.Entry<Byte, Integer> entry : tempMap.entrySet())
                nodes.add(new ByteNode(entry.getKey(), entry.getValue()));
            return nodes;
        }

        private static ByteNode createHuffmanTree(MinPriorityQueue<ByteNode> nodes) {
            while (nodes.len() > 1) {
                ByteNode left = nodes.poll();
                ByteNode right = nodes.poll();

            }
        }
}
























