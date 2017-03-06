package javatopython.cwb.dhu.edu.cn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;
@SuppressWarnings("resource")
public final class JythonUtil {
     
    private JythonUtil(){}
     
    /**
     * ִ��ĳ��.py�ļ�
     * @param filePath
     * @throws IOException
     */
    public static void pythonExecute(String filePath) throws IOException{
        
		PythonInterpreter pin = new PythonInterpreter();
        InputStream is = new FileInputStream(filePath);
        pin.execfile(is);
        is.close();
    }
     
    /**
     * ��ȡpython����ı���ֵ
     * @param filePath
     * @param ponames
     * @return
     * @throws IOException
     */
    public static List<PyObject> transP2JData(String filePath, String...ponames) throws IOException{
        PythonInterpreter pin = new PythonInterpreter();
        InputStream is = new FileInputStream(filePath);
        pin.execfile(is);
        is.close();
        List<PyObject> pos = new ArrayList<>();
        for (String poname : ponames) {
            PyObject po = pin.get(poname);
            pos.add(po);
        }
        return pos;
    }
     
    /**
     * ����������python����ִ��
     * @param filePath
     * @param pomaps
     * @throws IOException
     */
    public static void transJ2PData(String filePath, Map<String, Object> pomaps) throws IOException {
        PythonInterpreter pin = new PythonInterpreter();
        InputStream is = new FileInputStream(filePath);
        for (String pomapkey : pomaps.keySet()) {
            pin.set(pomapkey, pomaps.get(pomapkey));
        }
        pin.execfile(is);
        is.close();
    }
     
    /**
     * ����������python����ִ��,����ȡpython�еı���ֵ
     * @param filePath
     * @param pomaps
     * @param ponames
     * @return
     * @throws IOException
     */
    public static List<PyObject> transJ2PData(String filePath, Map<String, Object> pomaps, String...ponames) throws IOException {
        PythonInterpreter pin = new PythonInterpreter();
        InputStream is = new FileInputStream(filePath);
        for (String pomapkey : pomaps.keySet()) {
            pin.set(pomapkey, pomaps.get(pomapkey));
        }
        pin.execfile(is);
        is.close();
        List<PyObject> pos = new ArrayList<>();
        for (String poname : ponames) {
            PyObject po = pin.get(poname);
            pos.add(po);
        }
        return pos;
    }
 
}
