import java.io.*;

public class Task1 {
	//static DataOutputStream os;
    static StringBuilder hex = new StringBuilder();
    static PrintStream os;
	final static int FNV_32_PRIME = 0x01000193;
	static final byte[] HEXBYTES = { (byte) '0', (byte) '1', (byte) '2', (byte) '3',
    (byte) '4', (byte) '5', (byte) '6', (byte) '7', (byte) '8', (byte) '9', (byte) 'a',
    (byte) 'b', (byte) 'c', (byte) 'd', (byte) 'e', (byte) 'f' };

    public static void fPath(InputStream is) throws IOException {
    	String p = "";
        int c = 0;
        while ((c = is.read()) >= 0) 
        {
        	if (c != (byte)' ')
        		p += (char)(c & 0xFF);
        	else
        	{
        		opFile(p);
        		p = "";
        	}
        }
        opFile(p);
    }

    public static String fnv(byte[] buf) {
    	int res = 0x811c9dc5;
    	for (byte item : buf)
    	{
    		res *= FNV_32_PRIME;
    		item = (byte)(Character.toLowerCase((char)(item & 0xFF)));
    		res ^= item;
    	}
    	return Integer.toHexString(res);
    }

    public static void hs(InputStream fin, String fpath) throws IOException {
        byte[] b = new byte[1024];
        int l = fin.read(b);
        hex.append(fnv(b) + " " + fpath + "\n");
        os.print(hex);
    }

    public static void opFile(String p) {
    	try {
            InputStream fin = new FileInputStream(p);
            hs(fin, p);
        } catch (IOException e) {
            System.err.println("An I/O error:" + e.getMessage());
        }
    }

    /*
	public static byte[] toByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                             + Character.digit(s.charAt(i + 1), 16));
	    }
	    return data;
	}
	*/

    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream(args[0]);
            try {
                os = new PrintStream(args[1]);
                try {
                    fPath(is);
                } finally {
                    os.close();
                }
            } finally {
                is.close();
            }
        } catch (IOException e) {
            System.err.println("An I/O error:" + e.getMessage());
        }
    }
}