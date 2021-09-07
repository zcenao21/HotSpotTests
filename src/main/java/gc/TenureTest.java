package gc;

public class TenureTest {
    public static void main(String[] args) {
        byte[] byte1m_1 = new byte[1 * 1024 * 1024];
        byte[] byte1m_2 = new byte[1 * 1024 * 1024];
        byte[] byte1m_3 = new byte[1 * 1024 * 1024];

        byte[] byte1m_4=makeGarbage(34);

        byte[] byte1m_5=makeGarbage(34);

    }

    private static byte[] makeGarbage(int size){
        byte[] byteArrTemp = new byte[size * 1024 * 1024];
        return byteArrTemp;
    }
}
