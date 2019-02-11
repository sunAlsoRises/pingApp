package commonSources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class myUtil {
	/**
	 * 获取验证码
	 * 
	 * @return
	 */
	public static String getCode() {
		String code = "";
		String AllChar = "0,1,2,3,4,5,6,7,8,9,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";
		String[] ArrAllChar = AllChar.split(",");
		for (int i = 0; i < 5; i++) {
			code += ArrAllChar[(int) (Math.random() * 36)];
		}
		System.out.println(code);
		return code;
	}
	
	
	/**
	 * 调取接口
	 * 
	 * @return
	 */
	public static Map<String,Object> getInterface(String path,String data) {
		Map<String,Object> mymap=new HashMap<String,Object>();
		try {
            URL url = new URL(path);
            //打开和url之间的连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            System.out.println("45行"+conn);
            PrintWriter out = null;
            //请求方式
//          conn.setRequestMethod("POST");
//           //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)"); 
            //设置是否向httpUrlConnection输出，设置是否从httpUrlConnection读入，此外发送post请求必须设置这两个
            //最常用的Http请求无非是get和post，get请求可以获取静态页面，也可以把参数放在URL字串后面，传递给servlet，
            //post与get的 不同之处在于post的参数不是放在URL字串里面，而是放在http请求的正文内。
            conn.setDoOutput(true);
            conn.setDoInput(true);
            //获取URLConnection对象对应的输出流
            System.out.println(conn.getOutputStream());
            out = new PrintWriter(conn.getOutputStream());
            System.out.println(out);
            //发送请求参数即数据
            out.print(data);
            //缓冲数据
            out.flush();
            //获取URLConnection对象对应的输入流
            InputStream is = conn.getInputStream();
            //构造一个字符流缓存
            BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
            String str = "";
            Gson gson = new Gson();
            Map<String, Object> map = new HashMap<String, Object>();
           
            while ((str = br.readLine()) != null) {
                System.out.println(str);
                map = gson.fromJson(str, map.getClass());
                mymap=map;
            }
            //关闭流
            is.close();
            //断开连接，最好写上，disconnect是在底层tcp socket链接空闲时才切断。如果正在被其他线程使用就不切断。
            //固定多线程的话，如果不disconnect，链接会增多，直到收发不出信息。写上disconnect后正常一些。
            conn.disconnect();
            System.out.println("完整结束");
        } catch (Exception e) {
            e.printStackTrace();
        }
		return mymap;
	}
}
